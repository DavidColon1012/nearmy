package com.example.nearmy.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.nearmy.R;
import com.example.nearmy.activities.LoginActivity;
import com.example.nearmy.activities.MainActivity;
import com.example.nearmy.bean.Category;
import com.example.nearmy.frameworks.adapters.SwipeCategoryAdapter;
import com.example.nearmy.frameworks.adapters.SwipeElementAdapter;

import java.util.ArrayList;

import link.fls.swipestack.SwipeStack;

public class FiltreFrament extends DialogFragment {
    private static String TAG = FiltreFrament.class.getSimpleName();

    private MainActivity mContext;
    private SwipeStack swipeStack;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity) {
            this.mContext = (MainActivity) context;
        }
    }

    public static FiltreFrament newInstance() {
        FiltreFrament frag = new FiltreFrament();
        return frag;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
                .setNegativeButton(R.string.cancel,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View mFragmentView = inflater.inflate(R.layout.fragment_filtre, null);

        swipeStack = mFragmentView.findViewById(R.id.swipeStack);
        LoadCategorias();

        builder.setView(mFragmentView);
        AlertDialog mDialog = builder.create();

        return mDialog;
    }

    private void LoadCategorias() {
        ArrayList<Category> listCategories = new ArrayList<>();

        Category category = new Category();
        Bitmap bImage = BitmapFactory.decodeResource(this.getResources(), R.drawable.bar);
        category.setBtmCategory(bImage);

        Category category2 = new Category();
        Bitmap bImage2 = BitmapFactory.decodeResource(this.getResources(), R.drawable.restaurant);
        category2.setBtmCategory(bImage2);

        Category category3 = new Category();
        Bitmap bImage3 = BitmapFactory.decodeResource(this.getResources(), R.drawable.movie);
        category3.setBtmCategory(bImage3);

        listCategories.add(category);
        listCategories.add(category2);
        listCategories.add(category3);

        swipeStack.setAdapter(new SwipeCategoryAdapter(mContext, listCategories));
    }
}
