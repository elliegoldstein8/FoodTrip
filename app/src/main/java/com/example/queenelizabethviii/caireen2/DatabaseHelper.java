package com.example.queenelizabethviii.caireen2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper{


    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "menu.db";

    private static final String TABLE_CATEGORIES = "menu_categories", TABLE_ITEMS = "menu_items", TABLE_TRANSACTION = "transaction_table",
    TABLE_TRANSIT = "transaction_items";

    //columns for menu_categories table
    private static final String COLUMN_ID = "menu_id", COLUMN_NAME = "menu_name";
    //columns for menu_items table
    private static final String COLUMN_MENID = "menu_id", COLUMN_ITNAME = "menu_item_name", COLUMN_PRICE = "price",
    COLUMN_ITID ="menu_item_id";
    //columns for transaction table
    private static final String COLUMN_TRANSID ="transaction_id";
    //columns for transaction_items table
    private static final String COLUMN_TRANSIDF="transaction_id", COLUMN_MENUDO = "menu_item_id";

    SQLiteDatabase database;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        database = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        database.execSQL("CREATE TABLE " + TABLE_CATEGORIES +" (" + COLUMN_ID + " INTEGER PRIMARY KEY, " + COLUMN_NAME +" TEXT)");
        database.execSQL("CREATE TABLE " + TABLE_ITEMS + "(" + COLUMN_ITNAME + " TEXT, " + COLUMN_PRICE + " INTEGER, " + COLUMN_ITID + "INTEGER PRIMARY KEY, " +
                COLUMN_MENID + " INTEGER, FOREIGN KEY (" + COLUMN_MENID + ") REFERENCES " + TABLE_CATEGORIES + "(" + COLUMN_ID + "));"
        );
        database.execSQL("CREATE TABLE " + TABLE_TRANSACTION + " (" + COLUMN_TRANSID + " INTEGER PRIMARY KEY)" );
        database.execSQL("CREATE TABLE " + TABLE_TRANSIT + " (" + COLUMN_TRANSIDF + " INTEGER NOT NULL REFERENCES "+
        TABLE_TRANSACTION + "(" + COLUMN_TRANSID + "), " + COLUMN_MENUDO + " INTEGER, FOREIGN KEY (" + COLUMN_MENUDO + ") REFERENCES " +
                TABLE_ITEMS + "(" + COLUMN_ITNAME + "));");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_CATEGORIES);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_ITEMS);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_TRANSACTION);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_TRANSIT);
        onCreate(sqLiteDatabase);
    }
}
