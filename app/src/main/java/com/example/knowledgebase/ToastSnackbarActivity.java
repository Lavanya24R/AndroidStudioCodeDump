package com.example.knowledgebase;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

public class ToastSnackbarActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.toast_snackbar_layout);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button nrmToastBtn=findViewById(R.id.nrmToastBtn);
        Button ctmToastBtn=findViewById(R.id.ctmToastBtn);
        Button nrmSnackbarBtn=findViewById(R.id.nrnSnackBtn);
        Button ctmSnackbarBtn=findViewById(R.id.ctmSnackBtn);
        TextView snackbarTest=findViewById(R.id.snackbarTest);
        nrmToastBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Toast.makeText(ToastSnackbarActivity.this,"Default Toast", Toast.LENGTH_SHORT).show();
            }
        });
        ctmToastBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = getLayoutInflater();
                View layout=inflater.inflate(R.layout.custom_toast_layout, findViewById(R.id.custom_toast_container));
                Toast t=new Toast(getApplicationContext());
                t.setDuration(Toast.LENGTH_SHORT);
                t.setView(layout);
                t.show();
            }
        });
        nrmSnackbarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                snackbarTest.setText("Default snackbar clicked!");
                Snackbar.make(v,"Default Snackbar", Snackbar.LENGTH_LONG)
                        .setAction("Undo", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                snackbarTest.setText("Default Snackbar Undo!");
                            }
                        })
                        .show();
            }
        });
        ctmSnackbarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar = Snackbar.make(v, "Custom Snackbar", Snackbar.LENGTH_LONG);
                View snackbarView = snackbar.getView();
                TextView textView = snackbarView.findViewById(
                        com.google.android.material.R.id.snackbar_text
                );
                textView.setTextColor(Color.MAGENTA);
                textView.setTextSize(18);

                snackbar.show();
            }
        });

    }
}

/*Button btn = findViewById(R.id.snackbarBtn);

btn.setOnClickListener(v -> {

Snackbar snackbar = Snackbar.make(v, "", Snackbar.LENGTH_LONG);

Snackbar.SnackbarLayout layout = (Snackbar.SnackbarLayout) snackbar.getView();

View customLayout = getLayoutInflater().inflate(R.layout.custom_snackbar, null);

    layout.addView(customLayout, 0);

    snackbar.show();

});*/
