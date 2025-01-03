package com.example.ifrelix;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MeActivity extends AppCompatActivity {

    private static final String PREFS_NAME = "ProfilePrefs";

    // Declare UI components
    private EditText fullNameEditText, emailEditText, phoneNumberEditText, schoolEditText, addressEditText, skillsEditText, aboutEditText;
    private ImageView profileImageView;
    private Button saveProfileButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me);

        // Initialize UI components
        fullNameEditText = findViewById(R.id.fullName);
        emailEditText = findViewById(R.id.email);
        phoneNumberEditText = findViewById(R.id.phoneNumber);
        schoolEditText = findViewById(R.id.school);
        addressEditText = findViewById(R.id.address);
        skillsEditText = findViewById(R.id.skills);
        aboutEditText = findViewById(R.id.about);
        profileImageView = findViewById(R.id.profileImage);
        saveProfileButton = findViewById(R.id.saveProfileButton);

        // Set onClickListener for save button
        saveProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveProfile();
            }
        });
    }

    // Method to save profile data to SharedPreferences
    private void saveProfile() {
        // Get user input
        String fullName = fullNameEditText.getText().toString();
        String email = emailEditText.getText().toString();
        String phoneNumber = phoneNumberEditText.getText().toString();
        String school = schoolEditText.getText().toString();
        String address = addressEditText.getText().toString();
        String skills = skillsEditText.getText().toString();
        String about = aboutEditText.getText().toString();

        // Get SharedPreferences editor
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // Save data to SharedPreferences
        editor.putString("fullName", fullName);
        editor.putString("email", email);
        editor.putString("phoneNumber", phoneNumber);
        editor.putString("school", school);
        editor.putString("address", address);
        editor.putString("skills", skills);
        editor.putString("about", about);

        // Optionally, save profile picture (if applicable)
        // You can save a URI or file path if the user uploaded a photo.
        // Example: editor.putString("profileImageUri", profileImageUri);

        // Apply changes to SharedPreferences
        editor.apply();

        // Show confirmation message
        Toast.makeText(this, "Profile Saved!", Toast.LENGTH_SHORT).show();

        // Optionally, you can navigate to another activity or close the current one
        finish(); // Uncomment if you want to close the activity after saving
    }
}
