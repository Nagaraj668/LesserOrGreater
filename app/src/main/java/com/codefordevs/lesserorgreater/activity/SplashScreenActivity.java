package com.codefordevs.lesserorgreater.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.codefordevs.lesserorgreater.MainActivity;
import com.codefordevs.lesserorgreater.R;
import com.codefordevs.lesserorgreater.auth.AuthStateMaintainer;


public class SplashScreenActivity extends AppCompatActivity implements Runnable {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Handler handler = new Handler();

        handler.postDelayed(this, 3000);
    }

    @Override
    public void run() {
        finish();
        AuthStateMaintainer maintainer = new AuthStateMaintainer();
        boolean flag = maintainer.isAuthSuccess(this);

        if (flag) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } else {
            Intent intent = new Intent(this, AuthActivity.class);
            startActivity(intent);
        }
    }
}
