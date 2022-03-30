package com.learn.anglish.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.webkit.PermissionRequest;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.firebase.auth.FirebaseAuth;
import com.learn.anglish.R;
import com.learn.anglish.databinding.ActivityCallBinding;
import com.learn.anglish.modals.InterfaceJava;

public class CallActivity extends AppCompatActivity {

    ActivityCallBinding binding;
    String uniqueId = "";
    FirebaseAuth auth;
    String username = "";
    String friendsUsername = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);

        auth = FirebaseAuth.getInstance();
        uniqueId = auth.getUid();
    }

    void setupWebView(){
        binding.webView.setWebChromeClient( new WebChromeClient(){
            @Override
            public void onPermissionRequest(PermissionRequest request) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                request.grant(request.getResources());
                }
            }
        });

        binding.webView.getSettings().setJavaScriptEnabled(true);
        binding.webView.getSettings().setMediaPlaybackRequiresUserGesture(false);
        binding.webView.addJavascriptInterface( new InterfaceJava(this),"Anglish");

        //loadVideoCall()
    }

    public void loadVideoCall(){
        String filePath = "file;android_asset/call.html";
        binding.webView.loadUrl(filePath);

        binding.webView.setWebViewClient( new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                initializePeer();
            }

        });
    }
    void initializePeer(){
        callJavaScriptFunction("javascript:init(\""+ uniqueId +"\")");
    }
    void callJavaScriptFunction( String function){
        binding.webView.post(new Runnable() {
            @Override
            public void run() {
                binding.webView.evaluateJavascript(function,null);
            }
        });
    }
}