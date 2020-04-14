package com.example.nearmy.frameworks.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.nearmy.R;
import com.example.nearmy.activities.MainActivity;
import com.example.nearmy.bean.Category;
import com.example.nearmy.bean.Category;

import java.util.ArrayList;

public class SwipeCategoryAdapter extends BaseAdapter {
    private ArrayList<Category> listCategorys;
    private MainActivity context;

    public SwipeCategoryAdapter(MainActivity context, ArrayList<Category> data) {
        this.context = context;
        this.listCategorys = data;
    }

    @Override
    public int getCount() {
        return listCategorys.size();
    }

    @Override
    public Category getItem(int position) {
        return listCategorys.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        convertView = context.getLayoutInflater().inflate(R.layout.item_element, parent, false);
        ImageView imv = convertView.findViewById(R.id.imv);
        Category Category = listCategorys.get(position);
        imv.setImageBitmap(Category.getBtmCategory());
        return convertView;
    }

}
