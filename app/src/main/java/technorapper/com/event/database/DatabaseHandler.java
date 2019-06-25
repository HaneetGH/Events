package technorapper.com.event.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static technorapper.com.event.database.Constracts.DB_NAME;
import static technorapper.com.event.database.Constracts.DB_VERSION;
import static technorapper.com.event.database.Constracts.JSON;
import static technorapper.com.event.database.Constracts.TABLE_NAME;
import static technorapper.com.event.database.Constracts.VALUE;
import static technorapper.com.event.database.Constracts._ID;

public class DatabaseHandler extends SQLiteOpenHelper {


    private static final String CREATE_TABLE = "create table " + TABLE_NAME + "(" + _ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + JSON + " TEXT NOT NULL, " + VALUE + " BLOB);";

    public DatabaseHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

   }
