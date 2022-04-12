package com.learn.anglish;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void process(View view) {

        EditText t0 = (EditText)findViewById(R.id.t0);
        EditText t1 = (EditText)findViewById(R.id.t1);
        EditText t2 = (EditText)findViewById(R.id.t2);
        EditText t3 = (EditText)findViewById(R.id.t3);

        String roll = t0.getText().toString().trim();
        String name = t1.getText().toString().trim();
        String course = t2.getText().toString().trim();
        String duration = t3.getText().toString().trim();



        DataHolder data = new DataHolder(name, course, duration);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference root = database.getReference("Student");

        root.child(roll).setValue(data);

        t0.setText("");
        t1.setText("");
        t2.setText("");
        t3.setText("");

        Toast.makeText(this, "Data Inserted Successfully.", Toast.LENGTH_SHORT).show();
        
    }
}