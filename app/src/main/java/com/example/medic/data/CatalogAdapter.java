package com.example.medic.controllers;

import static com.example.medic.R.*;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;

import com.example.medic.R;
import com.example.medic.models.Catalog;

import java.util.List;

public class CatalogAdapter implements Adapter {
    public Context mContext;
    public List<Catalog> catalogList;

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public int getCount() {
        return  catalogList.size();
    }

    @Override
    public Object getItem(int i) {
        return catalogList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return Long.parseLong(catalogList.get(i).getId());
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = new View(mContext, null, id.item_catalog);
        TextView mainText = null;
        TextView day = null;
        TextView prise = null;
        mainText.findViewById(id.textView17);
        day.findViewById(id.textView18);
        prise.findViewById(id.textView19);
        mainText.setText(catalogList.get(position).getName());
        mainText.setText(catalogList.get(position).getTime_result());
        mainText.setText(catalogList.get(position).getPrice());
        return v;
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
