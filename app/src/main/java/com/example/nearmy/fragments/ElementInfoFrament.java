package com.example.nearmy.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import com.example.nearmy.R;
import com.example.nearmy.activities.LoginActivity;
import com.example.nearmy.activities.MainActivity;

public class ElementInfoFrament extends DialogFragment {
    private static String TAG = ElementInfoFrament.class.getSimpleName();


    private Context mContext;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    public static ElementInfoFrament newInstance() {
        ElementInfoFrament frag = new ElementInfoFrament();
        return frag;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View mFragmentView = inflater.inflate(R.layout.fragment_element_info, null);

        mContext = mFragmentView.getContext();

        builder.setView(mFragmentView);
        AlertDialog mDialog = builder.create();

        return mDialog;
    }
}
