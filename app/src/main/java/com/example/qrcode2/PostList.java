package com.example.qrcode2;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PostList {
    @SerializedName("list")
    private List<Post> list;

    public List<Post> getList() {
        return list;
    }
}
