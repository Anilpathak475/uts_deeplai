package com.example.androidexamp.example.room;

import android.os.AsyncTask;

public class DatabaseInitializer {

    private static final String TAG = DatabaseInitializer.class.getName();

    private static User addUser(final AppDatabase db, User user) {
        db.userDao().insert(user);
        return user;
    }

    private static User login(final AppDatabase database, String email, String password) {
        return database.userDao().login(email, password);
    }


    public static class AddUserAsync extends AsyncTask<Void, Void, Void> {

        private final AppDatabase mDb;
        private final User user;

        AddUserAsync(AppDatabase db, User user) {
            mDb = db;
            this.user = user;
        }

        @Override
        protected Void doInBackground(final Void... params) {
            addUser(mDb, user);
            return null;
        }

    }

    public static class LoginAsync extends AsyncTask<Void, Void, User> {

        private final AppDatabase mDb;
        private final String email;
        private final String password;

        LoginAsync(AppDatabase db, String email, String password) {
            mDb = db;
            this.email = email;
            this.password = password;
        }

        @Override
        protected User doInBackground(final Void... params) {
            return login(mDb, email, password);
        }

    }

}
