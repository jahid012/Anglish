package com.learn.anglish.modals;

import android.webkit.JavascriptInterface;

import com.learn.anglish.activities.CallActivity;

public class InterfaceJava {
    CallActivity callActivity;

    public InterfaceJava (CallActivity callActivity){
        this.callActivity = callActivity;
    }

    @JavascriptInterface
    public void onPeerConnected(){

    }
}
