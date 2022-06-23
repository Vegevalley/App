package com.example.vegevellay;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface PostVegBoard {
    @POST("content/vege/new/{post}")
    Call<PostDataClass> getPosts(@Path("post") String post);
}
