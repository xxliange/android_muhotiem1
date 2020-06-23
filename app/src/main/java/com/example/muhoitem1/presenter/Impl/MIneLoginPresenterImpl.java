package com.example.muhoitem1.presenter.Impl;

import com.example.muhoitem1.model.Api;
import com.example.muhoitem1.model.domain.MineData.MineLoginData;
import com.example.muhoitem1.presenter.IMineLoginPresenter;
import com.example.muhoitem1.utils.LogUtils;
import com.example.muhoitem1.utils.RetrofitManaget;
import com.example.muhoitem1.view.IMineLoginCallback;

import java.net.HttpURLConnection;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MIneLoginPresenterImpl implements IMineLoginPresenter {
    private IMineLoginCallback mViewCallback = null;

    @Override
    public void registerViewCallback(IMineLoginCallback callback) {
        this.mViewCallback = callback;
    }

    @Override
    public void unregisterViewCallback(IMineLoginCallback callback) {
        mViewCallback = null;
    }

    @Override
    public void userLogin(String user, String pass) {
        Retrofit retrofit = RetrofitManaget.getInstance().getRetrofit();
        Api api = retrofit.create(Api.class);
        Call<MineLoginData> task = api.getMineLoginData(user, pass);
        task.enqueue(new Callback<MineLoginData>() {
            @Override
            public void onResponse(Call<MineLoginData> call, Response<MineLoginData> response) {
                int code = response.code();
                if (code == HttpURLConnection.HTTP_OK) {
//                    LogUtils.d(MIneLoginPresenterImpl.this,"data --> " + response.body().getData().toString());
                    MineLoginData data = response.body();
//                    LogUtils.d(MIneLoginPresenterImpl.this, "data --> " + data);
                    mViewCallback.onSuccessLogin(data);
                }

            }

            @Override
            public void onFailure(Call<MineLoginData> call, Throwable t) {

            }
        });
    }
}
