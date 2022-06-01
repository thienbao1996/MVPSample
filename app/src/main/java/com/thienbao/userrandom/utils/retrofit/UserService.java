package com.thienbao.userrandom.utils.retrofit;

import com.thienbao.userrandom.models.UserList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UserService {
    @GET("api/")
    Call<UserList> getUsers();
}
