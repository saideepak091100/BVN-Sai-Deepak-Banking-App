package com.example.basicbankingapp.DBase;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.basicbankingapp.DBase.UserContract.UserEntry;

public class UserHelper extends SQLiteOpenHelper {

    String TABLE_NAME = UserEntry.TABLE_NAME;

    /** Name of the database file */
    private static final String DATABASE_NAME = "User.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.*/
    private static final int DATABASE_VERSION = 1;

    public UserHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_USER_TABLE =  "CREATE TABLE " + UserEntry.TABLE_NAME + " ("
                + UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " INTEGER, "
                + UserEntry.COLUMN_USER_NAME + " VARCHAR, "
                + UserEntry.COLUMN_USER_EMAIL + " VARCHAR, "
                + UserEntry.COLUMN_USER_IFSC_CODE + " VARCHAR, "
                + UserEntry.COLUMN_USER_PHONE_NO + " VARCHAR, "
                + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " INTEGER NOT NULL);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_USER_TABLE);

        // Insert Into Table
        db.execSQL("insert into " + TABLE_NAME + " values(2340,'aditya Sai', 'aditya@gmail.com','7584','2343441238', 15220)");
        db.execSQL("insert into " + TABLE_NAME + " values(2322,'rishabh jay', 'rishabh@gmail.com','1258','3443441238', 5200)");
        db.execSQL("insert into " + TABLE_NAME + " values(6595,'pratap kumar', 'pratap@gmail.com','8896','7645645896', 1100)");
        db.execSQL("insert into " + TABLE_NAME + " values(4438,'shiva shukla', 'shiva@gmail.com','7752','6456640038', 8040)");
        db.execSQL("insert into " + TABLE_NAME + " values(4350,'Shivani Kumari', 'Shivani@gmail.com','3669','6747648962',42300)");
        db.execSQL("insert into " + TABLE_NAME + " values(2329,'priyank Joshi', 'priyankh@gmail.com','9985','8855640238', 23500)");
        db.execSQL("insert into " + TABLE_NAME + " values(3438,'shivam joshi', 'shivam@gmail.com','1207','8895640215', 45000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7853,'Khush soni', 'Khush@gmail.com','4522','9985021539', 24500)");
        db.execSQL("insert into " + TABLE_NAME + " values(8762,'soumya kumari', 'soumya@gmail.com','6582','9309565238', 2500)");
        db.execSQL("insert into " + TABLE_NAME + " values(4065,'rajat Patidar', 'rajat@gmail.com','5450','8292591201', 3400)");
        db.execSQL("insert into " + TABLE_NAME + " values(7854,'Anurag desaii', 'Anurag@gmail.com','2656','9015641200', 6800)");
        db.execSQL("insert into " + TABLE_NAME + " values(3621,'bhuneshwar Kumar', 'bhuneshwar@gmail.com','1203','9995641999', 1000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1122,'virat kohli', 'virat@gmail.com','5566','9119541001', 3400)");
        db.execSQL("insert into " + TABLE_NAME + " values(9512,'rohit sharma', 'rohit@gmail.com','2236','6254642205', 6700)");
        db.execSQL("insert into " + TABLE_NAME + " values(7530,'mohammad shami', 'mohammad@gmail.com','6692','6893641266', 1410)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + UserEntry.TABLE_NAME);
            onCreate(db);
        }
    }

    public Cursor readAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME, null);
        return cursor;
    }

    public Cursor readParticularData (int accountNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME + " where " +
                                        UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo, null);
        return cursor;
    }

    public void updateAmount(int accountNo, int amount) {
        Log.d ("TAG", "update Amount");
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update " + UserEntry.TABLE_NAME + " set " + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " = " + amount + " where " +
                UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo);
    }
}