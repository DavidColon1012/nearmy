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

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import com.example.nearmy.R;
import com.example.nearmy.activities.MainActivity;
import com.example.nearmy.bean.Category;
import com.example.nearmy.bean.Element;
import com.example.nearmy.frameworks.adapters.SwipeCategoryAdapter;
import com.example.nearmy.frameworks.adapters.SwipeElementAdapter;

import java.util.ArrayList;

import link.fls.swipestack.SwipeStack;

public class RecommendationFrament extends DialogFragment {
    private static String TAG = RecommendationFrament.class.getSimpleName();

    private MainActivity mContext;
    private SwipeStack swipeStack;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity) {
            this.mContext = (MainActivity) context;
        }
    }

    public static RecommendationFrament newInstance() {
        RecommendationFrament frag = new RecommendationFrament();
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
        ArrayList<Element> listElements = new ArrayList<>();

        Bitmap bImage = BitmapFactory.decodeResource(this.getResources(), R.drawable.element);

        Element element = new Element();
        element.setBtm(bImage);

        Element element2 = new Element();
        element2.setBtm(bImage);

        Element element3 = new Element();
        element3.setBtm(bImage);

        listElements.add(element);
        listElements.add(element2);
        listElements.add(element3);

        swipeStack.setAdapter(new SwipeElementAdapter(mContext, listElements));
    }
}
