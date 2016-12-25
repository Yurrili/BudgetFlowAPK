package com.uj.yuri.budgetflow.db_managment.Gateway;


import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.uj.yuri.budgetflow.db_managment.Frequency;
import com.uj.yuri.budgetflow.db_managment.db_helper_objects.Entries;
import com.uj.yuri.budgetflow.db_managment.db_helper_objects.Income;


/**
 * Created by Yuri on 23.12.2016.
 */

public class IncomeGateway extends Gateway<Income> {


    @Override
    public void insert(Income ob, SQLiteDatabase dba) {

        String dateTimeStart = ob.getStartTime();
        String dateTimeFinish = ob.getEndTime();

        ContentValues values = new ContentValues();

        values.put(Entries.Incomes.COLUMN_INCOME_NAME, ob.getName());
        values.put(Entries.Incomes.COLUMN_DURATION, ob.getDuration());
        values.put(Entries.Incomes.COLUMN_DESCRIPTION, ob.getDescription());
        values.put(Entries.Incomes.COLUMN_DATETIME_START, dateTimeStart);
        values.put(Entries.Incomes.COLUMN_DATETIME_FINISH, dateTimeFinish);
        values.put(Entries.Incomes.COLUMN_ACTIVE, ob.isActive());
        values.put(Entries.Incomes.COLUMN_FREQUENCY, ob.getFrequency());
        values.put(Entries.Incomes.COLUMN_AMOUNT, ob.getAmount());

        dba.insert(Entries.Incomes.TABLE_NAME, null, values);
        dba.close();
    }

    @Override
    public void update(Income ob, SQLiteDatabase dba) {
        String dateTimeStart = ob.getStartTime();
        String dateTimeFinish = ob.getEndTime();

        ContentValues values = new ContentValues();

        values.put(Entries.Incomes.COLUMN_INCOME_NAME, ob.getName());
        values.put(Entries.Incomes.COLUMN_DURATION, ob.getDuration());
        values.put(Entries.Incomes.COLUMN_DESCRIPTION, ob.getDescription());
        values.put(Entries.Incomes.COLUMN_DATETIME_START, dateTimeStart);
        values.put(Entries.Incomes.COLUMN_DATETIME_FINISH, dateTimeFinish);
        values.put(Entries.Incomes.COLUMN_ACTIVE, ob.isActive());
        values.put(Entries.Incomes.COLUMN_FREQUENCY, ob.getFrequency());
        values.put(Entries.Incomes.COLUMN_AMOUNT, ob.getAmount());

        dba.update( Entries.Incomes.TABLE_NAME,
                    values,
                    Entries.Incomes._ID ,
                    new String[]{ ob.getId() });
        dba.close();
    }

    @Override
    public void remove(Income ob, SQLiteDatabase dba) {
        dba.delete( Entries.Incomes.TABLE_NAME,
                    Entries.Incomes._ID ,
                    new String[]{ ob.getId() });
        dba.close();
    }

    @Override
    public Cursor findAll(SQLiteDatabase dba) {
        Cursor cursor = dba.query(  Entries.Incomes.TABLE_NAME,
                                    Entries.Incomes.selectAllList,
                                    null, null, null, null, null);
        dba.close();
        return cursor;
    }

    @Override
    public Cursor find(String id, SQLiteDatabase dba) {
        Cursor cursor = dba.query(  Entries.Incomes.TABLE_NAME,
                                    Entries.Incomes.selectAllList,
                                    Entries.Incomes._ID ,
                                    new String[]{ id },
                                    null, null, null);
        dba.close();
        return cursor;
    }

    public Cursor selectFrequency(Frequency frequency, SQLiteDatabase dba) {
        String selection;
        switch (frequency){
            case MONTHLY:
                selection =  Entries.Incomes.COLUMN_FREQUENCY + " = '1' ";
                break;
            case YEARLY:
                selection =  Entries.Incomes.COLUMN_FREQUENCY + " = '2' ";
                break;
            default:
                selection =  Entries.Incomes.COLUMN_FREQUENCY + " = '1' " +
                            " OR " + Entries.Incomes.COLUMN_FREQUENCY + " = '0'";
                break;
        }

        Cursor cc = dba.query(  Entries.Incomes.TABLE_NAME,
                                Entries.Incomes.selectAllList,
                                selection, null, null, null, null);

        dba.close();
        return cc;
    }
}