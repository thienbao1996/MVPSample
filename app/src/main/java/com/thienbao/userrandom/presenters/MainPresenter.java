package com.thienbao.userrandom.presenters;

import android.util.Log;

import com.thienbao.userrandom.models.UserList;
import com.thienbao.userrandom.utils.interfaces.RetrofitCallBack;
import com.thienbao.userrandom.utils.mvp.BasePresenter;
import com.thienbao.userrandom.utils.retrofit.RetrofitInstance;
import com.thienbao.userrandom.utils.retrofit.UserService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter {
    /** Create handle for the RetrofitInstance interface*/
    private UserService userService = RetrofitInstance.getRetrofitInstance().create(UserService.class);
    protected RetrofitCallBack callBack;

    public MainPresenter(RetrofitCallBack callBack) {
        this.callBack = callBack;
    }

    @Override
    public void getUsers() {
        Call<UserList> call = userService.getUsers();
        call.enqueue(new Callback<UserList>() {
            @Override
            public void onResponse(Call<UserList> call, Response<UserList> response) {
                callBack.onGetUserSuccess(response.body().getFirst());
            }

            @Override
            public void onFailure(Call<UserList> call, Throwable t) {
                Log.d("MainPresenter", t.getMessage());
            }
        });
    }
}
