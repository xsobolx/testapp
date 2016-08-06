package comxsobolx.github.testapp.database;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.text.TextUtils;

/**
 * Created by aleksandr on 05.08.16.
 */
public class LoginContentProvider extends ContentProvider {
    private static final UriMatcher URI_MATCHER;

    private static final int LOGIN_TABLE = 1;

    static {
        URI_MATCHER = new UriMatcher(UriMatcher.NO_MATCH);
        URI_MATCHER.addURI(DatabaseHelper.CONTENT_AUTHORITY, DatabaseHelper.TABLE_USER, LOGIN_TABLE);
    }

    private DatabaseHelper databaseHelper;

    @Override
    public boolean onCreate() {
        databaseHelper = new DatabaseHelper(getContext());
        return false;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] strings, String s, String[] strings1, String s1) {
        SQLiteDatabase database = databaseHelper.getWritableDatabase();
        String table = getType(uri);
        if (TextUtils.isEmpty(table)) {
            throw new UnsupportedOperationException("No such table to query");
        } else {
            return database.query(table,
                    strings,
                    s,
                    strings1,
                    null,
                    null,
                    s1);
        }
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        switch (URI_MATCHER.match(uri)) {
            case LOGIN_TABLE:
                return DatabaseHelper.TABLE_USER;
            default:
                return "";
        }
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
        SQLiteDatabase database = databaseHelper.getWritableDatabase();
        String table = getType(uri);
        if (TextUtils.isEmpty(table)) {
            throw new UnsupportedOperationException("No such table to query");
        }
        else {
            long id = database.insertWithOnConflict(table, null, contentValues, SQLiteDatabase.CONFLICT_REPLACE);
            return ContentUris.withAppendedId(uri, id);
        }    }

    @Override
    public int delete(Uri uri, String s, String[] strings) {
        SQLiteDatabase database = databaseHelper.getWritableDatabase();
        String table = getType(uri);
        if (TextUtils.isEmpty(table)) {
            throw new UnsupportedOperationException("No such table to query");
        }
        else {
            return database.delete(table, s, strings);
        }    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String s, String[] strings) {
        return 0;
    }
}
