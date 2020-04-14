package com.example.nearmy.activities;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.example.nearmy.R;
import com.example.nearmy.fragments.SocialNetworkLoginFrament;

public class LoginActivity extends AppCompatActivity {

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        context = this;
    }


    public void goToMain(View view) {
        Intent intent = new Intent(context, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void goToSocialNetwork(View view) {
        FragmentManager fm = getSupportFragmentManager();
        SocialNetworkLoginFrament socialNetworkLoginFrament = SocialNetworkLoginFrament.newInstance(LoginActivity.this);
        socialNetworkLoginFrament.show(fm, "socialNetworkLoginFrament");
    }
}
