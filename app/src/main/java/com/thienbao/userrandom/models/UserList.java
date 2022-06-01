package com.thienbao.userrandom.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class UserList {
    @SerializedName("results")
    private ArrayList<User> list;

    public User getFirst() {
        return list.size() > 0 ? list.get(0) : null;
    }

    public ArrayList<User> getList() {
        return list;
    }

    public void setList(ArrayList<User> list) {
        this.list = list;
    }
}
