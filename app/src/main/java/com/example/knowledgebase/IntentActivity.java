package com.example.knowledgebase;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class IntentActivity extends AppCompatActivity {
    TextView name,phone,age;
    Button submitBtn,webpageBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intent_layout);
        name=findViewById(R.id.name);
        phone=findViewById(R.id.phone);
        age=findViewById(R.id.age);
        submitBtn=findViewById(R.id.submitBtn);
        webpageBtn=findViewById(R.id.webpageBtn);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(IntentActivity.this, SecondIntentActivity.class);
                i.putExtra("name", name.getText().toString());
                i.putExtra("phone", phone.getText().toString());
                i.putExtra("age", age.getText().toString());
                startActivityForResult(i, 1);
            }
        });
        webpageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://www.google.com"));
                startActivity(i);
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            String result = data.getStringExtra("prev");
            TextView tv = findViewById(R.id.prevInput);
            tv.setText(result);
        }
    }
}
