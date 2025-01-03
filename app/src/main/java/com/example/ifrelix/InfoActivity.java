package com.example.ifrelix;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class InfoActivity extends AppCompatActivity {

    private Button btnBack; // Deklarasi tombol kembali

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Jika EdgeToEdge adalah pustaka pihak ketiga, pastikan Anda menambahkan dependensi terkait.
        // Jika tidak diperlukan, hapus panggilan ini.
        // EdgeToEdge.enable(this); // Pastikan metode ini tersedia

        setContentView(R.layout.activity_info);

        // Menghubungkan tombol kembali dengan ID-nya
        btnBack = findViewById(R.id.btn_back);

        // Listener untuk tombol kembali
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Kembali ke halaman SettingsActivity
                Intent intent = new Intent(InfoActivity.this, SettingsActivity.class);
                startActivity(intent);
                finish(); // Menutup InfoActivity
            }
        });
    }
}
