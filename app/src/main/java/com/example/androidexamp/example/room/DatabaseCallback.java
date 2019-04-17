package com.example.androidexamp.example.room;

import java.util.List;

/**
 * Created by alahammad on 10/4/17.
 */

public interface DatabaseCallback {


    abstract void onUserAdded();
    abstract void onLogin();
    abstract void onFailed();

}
