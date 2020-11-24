package com.example.emailsender;

import androidx.appcompat.app.AppCompatActivity;

import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText from, to, subject, message, app_password;
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        from = findViewById(R.id.From);
        to = findViewById(R.id.To);
        subject = findViewById(R.id.Subject);
        message = findViewById(R.id.Message);
        app_password = findViewById(R.id.App_Password);
        send = findViewById(R.id.btn_send);
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (ValidateInput()) {
                    if (connectivityManager.getActiveNetworkInfo().isConnected()) {
                        SendMailTask sm = new SendMailTask(MainActivity.this, from.getText().toString(), to.getText().toString(), subject.getText().toString(), message.getText().toString(), app_password.getText().toString());
                        sm.execute();
                        Toast.makeText(MainActivity.this, "Sending Mail", Toast.LENGTH_SHORT).show();
                    }else
                        Toast.makeText(MainActivity.this, "Please check your internet connection", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    public boolean ValidateInput() {
        if (from.getText().toString().isEmpty() | !Patterns.EMAIL_ADDRESS.matcher(from.getText().toString()).matches()) {
            Toast.makeText(MainActivity.this, "Please enter valid sender email id ", Toast.LENGTH_SHORT).show();
            return false;
        } else if (to.getText().toString().isEmpty() | !Patterns.EMAIL_ADDRESS.matcher(to.getText().toString()).matches()) {
            Toast.makeText(MainActivity.this, "Please enter valid receiver email id ", Toast.LENGTH_SHORT).show();
            return false;
        } else if (subject.getText().toString().isEmpty() && message.getText().toString().isEmpty()) {
            Toast.makeText(MainActivity.this, "Can't send empty mail ", Toast.LENGTH_SHORT).show();
            return false;
        } else if (app_password.getText().toString().isEmpty() | app_password.getText().toString().length() != 16) {
            Toast.makeText(MainActivity.this, "Please enter 16 digit valid app password ", Toast.LENGTH_SHORT).show();
            return false;
        } else return true;
    }

}