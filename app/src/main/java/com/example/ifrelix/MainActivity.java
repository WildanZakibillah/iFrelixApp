package com.example.ifrelix;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.ifrelix.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Set Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Replace default fragment and set title
        replaceFragment(new JobsFragment(), "Jobs");

        // Bottom Navigation Listener
        binding.bottomNavigation.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.jobs) {
                replaceFragment(new JobsFragment(), "Jobs");
            } else if (itemId == R.id.interviews) {
                replaceFragment(new InterviewsFragment(), "Interviews");
            } else if (itemId == R.id.profile) {
                replaceFragment(new ProfileFragment(), "Profile");
            }
            return true;
        });
    }

    // Replace fragment and set toolbar title
    private void replaceFragment(Fragment fragment, String title) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();

        // Set Toolbar Title
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    // Menampilkan menu di toolbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu); // Inflate menu dari XML
        return true;
    }

    // Menangani klik item menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.settings) {
            // Pindah ke Activity Settings
            Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(intent);
            return true;
        } else if (item.getItemId() == R.id.info) {
            // Pindah ke Activity Info
            Intent intent = new Intent(MainActivity.this, InfoActivity.class);
            startActivity(intent);
            return true;
        } else if (item.getItemId() == R.id.exit) {
            // Menampilkan dialog konfirmasi saat keluar
            new AlertDialog.Builder(MainActivity.this)
                    .setMessage("Apakah Anda yakin ingin keluar?")
                    .setCancelable(false)
                    .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // Keluar dari aplikasi
                            finishAffinity();  // Untuk menutup aplikasi sepenuhnya
                        }
                    })
                    .setNegativeButton("Tidak", null)
                    .show();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}
