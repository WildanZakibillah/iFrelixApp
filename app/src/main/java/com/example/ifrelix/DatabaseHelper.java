package com.example.ifrelix;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "iFelix.db"; // Nama database
    private static final int DATABASE_VERSION = 2; // Versi database

    // Tabel pengguna
    private static final String USER_TABLE_NAME = "user";
    private static final String COL_ID = "id";
    private static final String COL_EMAIL = "email";
    private static final String COL_PASSWORD = "password";

    // Tabel pesan
    private static final String MESSAGE_TABLE_NAME = "messages";
    private static final String COL_MESSAGE_ID = "message_id";
    private static final String COL_SENDER = "sender";
    private static final String COL_CONTENT = "content";
    private static final String COL_TIMESTAMP = "timestamp";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Buat tabel pengguna
        String createUserTable = "CREATE TABLE " + USER_TABLE_NAME + " (" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_EMAIL + " TEXT UNIQUE NOT NULL, " +
                COL_PASSWORD + " TEXT NOT NULL)";
        db.execSQL(createUserTable);

        // Buat tabel pesan
        String createMessageTable = "CREATE TABLE " + MESSAGE_TABLE_NAME + " (" +
                COL_MESSAGE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_SENDER + " TEXT NOT NULL, " +
                COL_CONTENT + " TEXT NOT NULL, " +
                COL_TIMESTAMP + " TEXT NOT NULL)";
        db.execSQL(createMessageTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + USER_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + MESSAGE_TABLE_NAME);
        onCreate(db);
    }

    // Fungsi untuk menyimpan data pengguna
    public boolean insertUser(String email, String password) {
        if (email == null || password == null) return false; // Validasi
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_EMAIL, email);
        contentValues.put(COL_PASSWORD, password);

        long result = db.insert(USER_TABLE_NAME, null, contentValues);
        return result != -1;
    }

    // Fungsi untuk memperbarui password pengguna
    public boolean updatePassword(String email, String newPassword) {
        if (email == null || newPassword == null) return false; // Validasi
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_PASSWORD, newPassword);

        int rows = db.update(USER_TABLE_NAME, contentValues, COL_EMAIL + "=?", new String[]{email});
        return rows > 0;
    }

    // Fungsi untuk memvalidasi pengguna berdasarkan email dan password
    public boolean checkUser(String email, String password) {
        if (email == null || password == null) return false; // Validasi
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(USER_TABLE_NAME, null,
                COL_EMAIL + "=? AND " + COL_PASSWORD + "=?",
                new String[]{email, password}, null, null, null);

        boolean exists = (cursor != null && cursor.getCount() > 0);
        if (cursor != null) cursor.close();
        return exists;
    }

    // Fungsi untuk menyimpan pesan baru
    public boolean insertMessage(String sender, String content, String timestamp) {
        if (sender == null || content == null || timestamp == null) return false; // Validasi
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_SENDER, sender);
        contentValues.put(COL_CONTENT, content);
        contentValues.put(COL_TIMESTAMP, timestamp);

        long result = db.insert(MESSAGE_TABLE_NAME, null, contentValues);
        return result != -1;
    }

    // Fungsi untuk mengambil semua pesan
    public Cursor getAllMessages() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.query(MESSAGE_TABLE_NAME, null, null, null, null, null, COL_TIMESTAMP + " ASC");
    }

    // Fungsi untuk menghapus pengguna berdasarkan email
    public boolean deleteUser(String email) {
        if (email == null) return false; // Validasi
        SQLiteDatabase db = this.getWritableDatabase();
        int rows = db.delete(USER_TABLE_NAME, COL_EMAIL + "=?", new String[]{email});
        return rows > 0;
    }

    // Fungsi untuk menghapus semua pesan
    public boolean deleteAllMessages() {
        SQLiteDatabase db = this.getWritableDatabase();
        int rows = db.delete(MESSAGE_TABLE_NAME, null, null);
        return rows > 0;
    }
}
