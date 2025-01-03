package com.example.ifrelix;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Activity3 extends AppCompatActivity {

    private CheckBox agreeCheckBox;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        // Initialize UI components
        agreeCheckBox = findViewById(R.id.agreeCheckBox);
        submitButton = findViewById(R.id.submitButton);

        // Set listener for the submit button
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check if the checkbox is checked
                if (agreeCheckBox.isChecked()) {
                    // If checked, proceed to LoginActivity
                    Intent intent = new Intent(Activity3.this, LoginActivity.class);
                    startActivity(intent);
                    finish(); // Close MainActivity3
                } else {
                    // If not checked, show a message
                    Toast.makeText(Activity3.this, "You must agree to the terms first", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
