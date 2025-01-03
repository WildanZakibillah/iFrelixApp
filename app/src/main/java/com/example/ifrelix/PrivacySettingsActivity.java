package com.example.ifrelix;

import android.os.Bundle;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PrivacySettingsActivity extends AppCompatActivity {

    private Switch switchPrivacy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy_settings);

        // Inisialisasi
        switchPrivacy = findViewById(R.id.switch_privacy);

        // Atur status switch
        switchPrivacy.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                Toast.makeText(PrivacySettingsActivity.this, "Privacy settings enabled", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(PrivacySettingsActivity.this, "Privacy settings disabled", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
