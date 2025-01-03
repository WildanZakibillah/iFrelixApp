package com.example.ifrelix;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class Item1Activity extends AppCompatActivity {

    private Button applyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item1);

        // Menghubungkan elemen tombol Apply
        applyButton = findViewById(R.id.btnApply);

        // Menambahkan klik listener pada tombol Apply
        applyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Membuat intent untuk membuka activity ApplyJobActivity
                Intent intent = new Intent(Item1Activity.this, ApplyJobActivity1.class);

                // Menambahkan informasi pekerjaan sebagai extras
                intent.putExtra("jobTitle", "Selamat! Anda telah berhasil menyelesaikan proses pendaftaran untuk posisi Digital Marketing di PT. Bintang Global - Surabaya.");
                intent.putExtra("company", "Kami dengan senang hati mengonfirmasi jika Anda telah diterima, dan sekarang Anda berada dalam tahap seleksi untuk posisi yang sangat kami nantikan.");
                intent.putExtra("salary", "Gaji yang akan anda terima: Rp 3-4 jt");
                intent.putExtra("deadline", "Daftar pada: 4 Januari 2025");

                // Memulai activity ApplyJobActivity
                startActivity(intent);
            }
        });
    }
}