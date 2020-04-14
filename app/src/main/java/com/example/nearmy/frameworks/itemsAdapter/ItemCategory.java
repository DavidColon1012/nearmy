package com.example.nearmy.frameworks.itemsAdapter;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nearmy.R;
import com.example.nearmy.activities.MainActivity;
import com.example.nearmy.bean.Category;
import com.example.nearmy.bean.Element;
import com.example.nearmy.frameworks.adapters.ElementAdapter;
import com.example.nearmy.frameworks.adapters.SwipeElementAdapter;

import java.util.ArrayList;

import link.fls.swipestack.SwipeStack;

public class ItemCategory extends RecyclerView.ViewHolder implements SwipeStack.SwipeProgressListener {

    private TextView titleCategory;
    private RecyclerView rlvElement;
    private FrameLayout fmlSwipeStack;
    private SwipeStack swipeStack;

    private ArrayList<Element> listEventos;

    public ItemCategory(@NonNull View itemView) {
        super(itemView);
        titleCategory = itemView.findViewById(R.id.titleCategory);
        fmlSwipeStack = itemView.findViewById(R.id.frameSwipeStack);
        swipeStack = itemView.findViewById(R.id.swipeStack);
        swipeStack.setSwipeProgressListener(this);

        LinearLayoutManager layoutManager
                = new LinearLayoutManager(itemView.getContext(), LinearLayoutManager.HORIZONTAL, false);

        rlvElement = itemView.findViewById(R.id.rlvElement);

        rlvElement.setLayoutManager(layoutManager);
    }

    public void bind(MainActivity context, Category category) {
        if (!category.isEvento()) {
            fmlSwipeStack.setVisibility(View.GONE);

            titleCategory.setVisibility(View.VISIBLE);
            titleCategory.setText(category.getTitle());

            rlvElement.setVisibility(View.VISIBLE);
            rlvElement.setAdapter(new ElementAdapter(context, category.getListElements()));
        } else {
            titleCategory.setVisibility(View.GONE);
            rlvElement.setVisibility(View.GONE);

            fmlSwipeStack.setVisibility(View.VISIBLE);
            listEventos = category.getListElements();
            swipeStack.setAdapter(new SwipeElementAdapter(context, category.getListElements()));
        }
    }

    @Override
    public void onSwipeStart(int position) {

    }

    @Override
    public void onSwipeProgress(int position, float progress) {
        if (position == (listEventos.size() - 1)) {
            fmlSwipeStack.setVisibility(View.GONE);
        }
    }

    @Override
    public void onSwipeEnd(int position) {

    }
}
