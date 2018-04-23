package com.codefordevs.lesserorgreater.model;

import com.google.firebase.auth.FirebaseUser;

import java.io.Serializable;

/**
 * Created by NAGARAJ SRJ on 4/21/2018.
 */

public class User implements Serializable {

    private String displayName;
    private String email;
    private String photoURL;

    public User(FirebaseUser firebaseUser) {
        this.displayName = firebaseUser.getDisplayName();
        this.email = firebaseUser.getEmail();
        this.photoURL = firebaseUser.getPhotoUrl().getEncodedPath();
    }

    public User() {
        super();
    }
}
