package com.example.shopper;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class ShoppingLists extends CursorAdapter {

    public ShoppingLists(Context context, Cursor cursor, int flags) {
        super(context, cursor, flags);
    }
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.li_shopping_list, viewGroup, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ((TextView) view.findViewById(R.id.nameTextView)).
                setText(cursor.getString(cursor.getColumnIndex( "name")));
        ((TextView) view.findViewById(R.id.storeTextView)).
                setText(cursor.getString(cursor.getColumnIndex( "store")));
        ((TextView) view.findViewById(R.id.dateTextView)).
                setText(cursor.getString(cursor.getColumnIndex( "date")));
    }
}

