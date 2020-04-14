package com.example.nearmy.frameworks.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nearmy.R;
import com.example.nearmy.activities.MainActivity;
import com.example.nearmy.bean.Category;
import com.example.nearmy.frameworks.itemsAdapter.ItemCategory;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<ItemCategory> {

    private ArrayList<Category> listCategories;
    private MainActivity context;

    public CategoryAdapter(MainActivity context, ArrayList<Category> listCategories) {
        this.context = context;
        this.listCategories = listCategories;
    }

    @NonNull
    @Override
    public ItemCategory onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent, false);
        return new ItemCategory(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemCategory holder, int position) {
        holder.bind(context, listCategories.get(position));
    }

    @Override
    public int getItemCount() {
        return listCategories.size();
    }
}
