package com.example.ifrelix;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ForgetPasswordActivity extends AppCompatActivity {

    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        EditText inputEmail = findViewById(R.id.input_email);
        EditText inputNewPassword = findViewById(R.id.input_new_password);
        EditText inputConfirmNewPassword = findViewById(R.id.input_confirm_new_password);
        Button btnResetPassword = findViewById(R.id.btn_reset_password);

        databaseHelper = new DatabaseHelper(this);

        btnResetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = inputEmail.getText().toString().trim();
                String newPassword = inputNewPassword.getText().toString().trim();
                String confirmNewPassword = inputConfirmNewPassword.getText().toString().trim();

                if (TextUtils.isEmpty(email) || TextUtils.isEmpty(newPassword) || TextUtils.isEmpty(confirmNewPassword)) {
                    Toast.makeText(ForgetPasswordActivity.this, "All fields are required", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!newPassword.equals(confirmNewPassword)) {
                    Toast.makeText(ForgetPasswordActivity.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                    return;
                }

                boolean isUpdated = databaseHelper.updatePassword(email, newPassword);
                if (isUpdated) {
                    Toast.makeText(ForgetPasswordActivity.this, "Password reset successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(ForgetPasswordActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(ForgetPasswordActivity.this, "Email not found", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}