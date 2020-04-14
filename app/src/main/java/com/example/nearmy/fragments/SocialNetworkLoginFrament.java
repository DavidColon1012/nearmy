package com.example.nearmy.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;


import com.example.nearmy.R;
import com.example.nearmy.activities.LoginActivity;

public class SocialNetworkLoginFrament extends DialogFragment {
    private static String TAG = SocialNetworkLoginFrament.class.getSimpleName();
    private static LoginActivity myloginActivity;

    private Context mContext;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    public static SocialNetworkLoginFrament newInstance(LoginActivity loginActivity) {
        SocialNetworkLoginFrament frag = new SocialNetworkLoginFrament();
        myloginActivity = loginActivity;
        return frag;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
                .setTitle(R.string.social_network)
                .setPositiveButton(R.string.login,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                myloginActivity.goToMain(null);
                            }
                        })
                .setNegativeButton(R.string.cancel,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View mFragmentView = inflater.inflate(R.layout.fragment_social_network_login, null);

        mContext = mFragmentView.getContext();

        builder.setView(mFragmentView);
        AlertDialog mDialog = builder.create();

        return mDialog;
    }
}
