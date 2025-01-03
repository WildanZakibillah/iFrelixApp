package com.example.ifrelix;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ApplyJobActivity1 extends AppCompatActivity {

    private TextView jobTitleTextView;
    private TextView companyTextView;
    private TextView salaryTextView;
    private TextView deadlineTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply_job1);

        // Menghubungkan elemen-elemen UI
        jobTitleTextView = findViewById(R.id.jobTitle);
        companyTextView = findViewById(R.id.company);
        salaryTextView = findViewById(R.id.salary);
        deadlineTextView = findViewById(R.id.deadline);

        // Mengambil data yang dikirimkan melalui Intent
        String jobTitle = getIntent().getStringExtra("jobTitle");
        String company = getIntent().getStringExtra("company");
        String salary = getIntent().getStringExtra("salary");
        String deadline = getIntent().getStringExtra("deadline");

        // Menampilkan data di TextViews
        jobTitleTextView.setText(jobTitle);
        companyTextView.setText(company);
        salaryTextView.setText(salary);
        deadlineTextView.setText(deadline);
    }
}