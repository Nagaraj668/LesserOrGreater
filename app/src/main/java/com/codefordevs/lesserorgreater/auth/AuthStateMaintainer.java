package com.codefordevs.lesserorgreater.auth;

import android.content.Context;
import android.content.SharedPreferences;

import com.codefordevs.lesserorgreater.model.User;
import com.codefordevs.lesserorgreater.utils.Constants;
import com.google.firebase.auth.FirebaseUser;
import com.google.gson.Gson;

import org.json.JSONObject;

/**
 * Created by NAGARAJ SRJ on 4/21/2018.
 */

public class AuthStateMaintainer {

    public boolean isAuthSuccess(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.SHARED_PREFS, Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(Constants.Keys.AUTH, false);
    }

    public void setAuthState(FirebaseUser firebaseUser, Context context) {
        try {
            User user = new User(firebaseUser);
            Gson gson = new Gson();
            SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.SHARED_PREFS, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(Constants.Keys.AUTH_INFO, gson.toJson(user));
            editor.putBoolean(Constants.Keys.AUTH, true);
            editor.apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void reset(Context context) {
        try {
            User user = new User();
            Gson gson = new Gson();
            SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.SHARED_PREFS, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(Constants.Keys.AUTH_INFO, gson.toJson(user));
            editor.putBoolean(Constants.Keys.AUTH, false);
            editor.apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
