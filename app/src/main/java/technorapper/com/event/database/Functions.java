package technorapper.com.event.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.google.gson.Gson;

import retrofit2.Response;
import technorapper.com.event.networking.model.UnisysModel;

public class Functions {

    public static UnisysModel getLocalData(Context context) {

        UnisysModel data = new UnisysModel();
        DatabaseHandler dbp = new DatabaseHandler(context);
        SQLiteDatabase db = dbp.getReadableDatabase();
        String sql = "SELECT * FROM " + Constracts.TABLE_NAME + " WHERE " + Constracts.JSON + "='" + "JSON1" + "'";

        Cursor c = db.rawQuery(sql, null);
        if (c != null && !c.isClosed()) {
            if (c.moveToFirst()) {
                do {
                    byte[] blob = c.getBlob(c.getColumnIndex(Constracts.VALUE));
                    String json = new String(blob);
                    Gson gson = new Gson();
                    data = gson.fromJson(json, UnisysModel.class);

                } while (c.moveToNext());
            }
            c.close();
        }
        db.close();


        return data;
    }
    public static void insertInDb(Context context, Response<UnisysModel> response) {
        String deleteSql = "DELETE FROM " + Constracts.TABLE_NAME;
        Gson gson = new Gson();
        DatabaseHandler dbp = new DatabaseHandler(context);
        SQLiteDatabase db = dbp.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Constracts.JSON, "JSON1");
        values.put(Constracts.VALUE, gson.toJson(response.body()).getBytes());
        db.rawQuery(deleteSql, null);
        db.insert(Constracts.TABLE_NAME, null, values);
        db.close();

    }

}
