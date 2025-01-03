package com.example.ifrelix;

import android.database.Cursor; // Tambahkan ini untuk mengimpor Cursor
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ChatActivity extends AppCompatActivity {

    private DatabaseHelper databaseHelper;
    private RecyclerView recyclerView;
    private MessageAdapter adapter;
    private List<Message> messages;
    private EditText editMessage;
    private ImageView btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        databaseHelper = new DatabaseHelper(this);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        messages = new ArrayList<>();
        adapter = new MessageAdapter(messages);
        recyclerView.setAdapter(adapter);

        editMessage = findViewById(R.id.edit_message);
        btnSend = findViewById(R.id.btn_send);

        loadMessages();

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = editMessage.getText().toString().trim();
                if (!content.isEmpty()) {
                    String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date());
                    databaseHelper.insertMessage("You", content, timestamp);

                    messages.add(new Message("You", content));
                    adapter.notifyDataSetChanged();
                    editMessage.setText("");
                    recyclerView.scrollToPosition(messages.size() - 1);
                }
            }
        });
    }

    private void loadMessages() {
        Cursor cursor = databaseHelper.getAllMessages();
        if (cursor != null) {
            while (cursor.moveToNext()) {
                String sender = cursor.getString(cursor.getColumnIndex("sender"));
                String content = cursor.getString(cursor.getColumnIndex("content"));
                messages.add(new Message(sender, content));
            }
            cursor.close(); // Perbaikan: Tambahkan tanda kurung penutup
        }
    }
}
