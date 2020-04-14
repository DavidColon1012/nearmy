package com.example.nearmy.frameworks.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.nearmy.R;
import com.example.nearmy.activities.MainActivity;
import com.example.nearmy.bean.Element;

import java.util.ArrayList;

public class SwipeElementAdapter extends BaseAdapter {
    private ArrayList<Element> listElements;
    private int index;
    private MainActivity context;

    public SwipeElementAdapter(MainActivity context, ArrayList<Element> data) {
        this.context = context;
        this.listElements = data;
    }

    @Override
    public int getCount() {
        return listElements.size();
    }

    @Override
    public Element getItem(int position) {
        return listElements.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        index = position;
        convertView = context.getLayoutInflater().inflate(R.layout.item_element, parent, false);
        ImageView imv = convertView.findViewById(R.id.imv);
        Element element = listElements.get(position);
        imv.setImageBitmap(element.getBtm());
        return convertView;
    }
}
