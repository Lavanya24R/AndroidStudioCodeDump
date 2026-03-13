package com.example.knowledgebase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondIntentActivity extends AppCompatActivity {
    TextView name,phone,age;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_intent_layout);
        Intent i=getIntent();
        String n=i.getStringExtra("name");
        String p=i.getStringExtra("phone");
        String a=i.getStringExtra("age");
        name=findViewById(R.id.name);
        phone=findViewById(R.id.phone);
        age=findViewById(R.id.age);
        name.setText(n);
        phone.setText(p);
        age.setText(a);
        Button backBtn=findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(SecondIntentActivity.this, IntentActivity.class);
                in.putExtra("prev",n+"\n"+p+"\n"+a);
                setResult(RESULT_OK, in);
                finish();
            }
        });


    }
}
