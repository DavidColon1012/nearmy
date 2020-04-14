package com.example.nearmy.frameworks.adapters;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nearmy.R;
import com.example.nearmy.activities.MainActivity;
import com.example.nearmy.bean.Element;
import com.example.nearmy.frameworks.itemsAdapter.ItemElement;

import java.util.ArrayList;

public class ElementAdapter extends RecyclerView.Adapter<ItemElement> {

    private ArrayList<Element> listElements;
    private MainActivity context;

    public ElementAdapter(MainActivity context, ArrayList<Element> listElements) {
        this.context = context;
        this.listElements = listElements;
    }

    @NonNull
    @Override
    public ItemElement onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_element, parent, false);
        return new ItemElement(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemElement holder, int position) {
        holder.bind(context, listElements.get(position));
    }

    @Override
    public int getItemCount() {
        if (listElements != null) {
            return listElements.size();
        } else {
            return 0;
        }
    }
}
