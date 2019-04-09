package com.example.less3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.design.widget.TextInputLayout;
import java.util.regex.Pattern;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private TextInputLayout inputemail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputemail = findViewById(R.id.input_mail);
    }

    private boolean validateEmail() {
        String emailInput = inputemail.getEditText().getText().toString().trim();

        if (emailInput.isEmpty()) {
            inputemail.setError("Field can't be empty");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            inputemail.setError("invalid");
            return false;
        } else {
            inputemail.setError(null);
            return true;
        }

    }

    public void confirmInput(View v) {
        if (!validateEmail()) {
            return;
        }

        String input = "Email: " + inputemail.getEditText().getText().toString();

    }

}