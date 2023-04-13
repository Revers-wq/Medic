package com.example.medic.data;

import static com.example.medic.R.*;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.medic.R;
import com.example.medic.controllers.Category;
import com.example.medic.models.Catalog;

import org.w3c.dom.Text;

import java.util.List;
import java.util.Objects;

public class CatalogAdapter extends BaseAdapter{
    Category category = new Category();
    public Context mContext;

    public CatalogAdapter(Context mContext, List<Catalog> catalogList) {
        this.mContext = mContext;
        this.catalogList = catalogList;
    }

    public List<Catalog> catalogList;


    @Override
    public int getCount() {
        return catalogList.size();
    }

    @Override
    public Object getItem(int position) {
        return catalogList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return Long.parseLong(catalogList.get(position).getId());
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String qwe =catalogList.get(position).getCategory();

        if(category.category=="all") {
            View v = View.inflate(mContext, layout.item_catalog, null);
            TextView mainText = v.findViewById(id.textView17);
            TextView day = v.findViewById(id.textView18);
            TextView price = v.findViewById(id.textView19);
            mainText.setText(catalogList.get(position).getName());
            day.setText(catalogList.get(position).getTime_result());
            price.setText(catalogList.get(position).getPrice());
            return v;
        }
        if(category.category=="Популярные")
        {
            if(Objects.equals(qwe, "Популярные"))
            {
                View v = View.inflate(mContext, layout.item_catalog, null);
                TextView mainText = v.findViewById(id.textView17);
                TextView day = v.findViewById(id.textView18);
                TextView price = v.findViewById(id.textView19);
                mainText.setText(catalogList.get(position).getName());
                day.setText(catalogList.get(position).getTime_result());
                price.setText(catalogList.get(position).getPrice());
                return v;
            }
        }
        if(category.category=="COVID")
        {
            if(Objects.equals(qwe, "COVID"))
            {
                View v = View.inflate(mContext, layout.item_catalog, null);
                TextView mainText = v.findViewById(id.textView17);
                TextView day = v.findViewById(id.textView18);
                TextView price = v.findViewById(id.textView19);
                mainText.setText(catalogList.get(position).getName());
                day.setText(catalogList.get(position).getTime_result());
                price.setText(catalogList.get(position).getPrice());
                return v;
            }
        }
        if(category.category=="Онкогенетиеские")
        {
            if(Objects.equals(qwe, "Онкогенетиеские"))
            {
                View v = View.inflate(mContext, layout.item_catalog, null);
                TextView mainText = v.findViewById(id.textView17);
                TextView day = v.findViewById(id.textView18);
                TextView price = v.findViewById(id.textView19);
                mainText.setText(catalogList.get(position).getName());
                day.setText(catalogList.get(position).getTime_result());
                price.setText(catalogList.get(position).getPrice());
                return v;
            }
        }
        if(category.category=="ЗОЖ")
        {
            if( Objects.equals(qwe, "ЗОЖ"))
            {
                View v = View.inflate(mContext, layout.item_catalog, null);
                TextView mainText = v.findViewById(id.textView17);
                TextView day = v.findViewById(id.textView18);
                TextView price = v.findViewById(id.textView19);
                mainText.setText(catalogList.get(position).getName());
                day.setText(catalogList.get(position).getTime_result());
                price.setText(catalogList.get(position).getPrice());
                return v;
            }
        }
        View v = View.inflate(mContext, layout.item_catalog, null);

        return v;
    }
}
