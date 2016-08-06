package comxsobolx.github.testapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.util.Log;

import comxsobolx.github.testapp.model.User;

/**
 * Created by aleksandr on 05.08.16.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    public final static String TABLE_USER = "user";
    public static final String TABLE_MESSAGES = "messages";
    public final static String DATABASE_NAME = "test";
    private final static int DATABASE_VERSION = 5;
    public static final String CONTENT_AUTHORITY = "comxsobolx.github.testapp";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
    public static final Uri URI = BASE_CONTENT_URI.buildUpon().appendEncodedPath(TABLE_USER).build();

    public static final String KEY_ID = "id";
    public static final String KEY_LOGIN = "login";
    public static final String KEY_TOKEN = "token";
    public static final String KEY_IMAGE_URL = "image_url";
    public static final String KEY_IMAGE_BYTES = "image_bytes";

    public static final String KEY_MESSAGE = "message";
    public static final String KEY_RECEIVER = "receiver";

    private String selectUserQuery = "SELECT * FROM " + TABLE_USER + " LIMIT 1";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_LOGIN_TABLE = "" +
                "CREATE TABLE IF NOT EXISTS " +
                TABLE_USER + "(" +
                KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                KEY_LOGIN + " TEXT, " +
                KEY_TOKEN + " TEXT, " +
                KEY_IMAGE_URL + " TEXT, " +
                KEY_IMAGE_BYTES + " BLOB" +
                ");";

        String CREATE_MESSAGES_TABLE = "" +
                "CREATE TABLE IF NOT EXISTS " +
                TABLE_MESSAGES + "(" +
                KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                KEY_LOGIN + " TEXT, " +
                KEY_RECEIVER + " TEXT, " +
                KEY_MESSAGE + " TEXT(1000) " +
                ");";
        sqLiteDatabase.execSQL(CREATE_LOGIN_TABLE);
        sqLiteDatabase.execSQL(CREATE_MESSAGES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        onCreate(sqLiteDatabase);
    }

    public void insertLogin(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        if (!userExist()) {
            ContentValues values = new ContentValues();
            values.put(KEY_LOGIN, user.getLogin());
            values.put(KEY_TOKEN, user.getToken());
            values.put(KEY_IMAGE_URL, user.getImageUrl());

            db.insert(TABLE_USER, null, values);
            Log.d("DATABASE", user.getToken() + " " + user.getImageUrl());
        }
        db.close();
    }

    public void insertMessage(String login, String receiver, String message) {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_LOGIN, login);
        contentValues.put(KEY_RECEIVER, receiver);
        contentValues.put(KEY_MESSAGE, message);
        db.insert(TABLE_MESSAGES, null, contentValues);
        db.close();
    }

    private boolean userExist(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectUserQuery, null);
        if (cursor.moveToFirst()){
            return true;
        }
        cursor.close();
        return false;
    }

    public User getUser() {
        SQLiteDatabase db = this.getReadableDatabase();
        User user = new User();

        Cursor cursor = db.rawQuery(selectUserQuery, null);
        if (cursor != null && cursor.moveToFirst()) {
            do {
                user.setLogin(cursor.getString(1));
                user.setToken(cursor.getString(2));
                user.setImageUrl(cursor.getString(3));
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return user;
    }

    public void insertImageBlob(String login, byte[] imageBytes) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_IMAGE_BYTES, imageBytes);
        SQLiteDatabase db = this.getWritableDatabase();
        db.update(TABLE_USER, contentValues, KEY_LOGIN + "=?", new String[]{login});
        db.close();
    }


    public void delete(){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_USER);
        db.close();
    }

}
