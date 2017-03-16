package org.truongpq.newsbox.utils;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by truongpq on 14/03/2017.
 */

public class DBUtils {
    public static final String TAG = "DBUTILS";
    public static final String DB_NAME = "news";

    public static void createDatabase(Context context) {

        if (!databaseExists(context)) {
            Log.i(TAG, "OpenHelper createDatabase, database does NOT exist, will be copied/created...");
            try {
                copyDatabase(context);
            } catch (IOException e) {
                Log.e(TAG, "OpenHelper error copying database " + e.getMessage(), e);
            }
        } else {
            Log.d(TAG, "OpenHelper createDatabase, database exists, leaving it alone");
        }
    }

    private static void copyDatabase(Context context) throws IOException {

        InputStream is = context.getAssets().open(DB_NAME + ".sqlite");

        File dbFile = context.getDatabasePath(DB_NAME);
        dbFile.getParentFile().mkdirs();
        Log.i(TAG, "OpenHelper copyDatabase creating file at path:" + dbFile.getAbsolutePath());

        OutputStream os = new FileOutputStream(dbFile.getAbsolutePath());

        byte[] buffer = new byte[1024];
        int length;
        while ((length = is.read(buffer)) > 0) {
            os.write(buffer, 0, length);
        }

        os.flush();
        os.close();
        is.close();
    }

    private static boolean databaseExists(Context context) {
        File dbFile = context.getDatabasePath(DB_NAME);
        return dbFile.exists();
    }


}
