package com.example.muhoitem1.model.network;

import android.util.Log;

import com.example.muhoitem1.model.BaseResponse;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public abstract class BaseObserver<T> implements Observer<BaseResponse<T>> {
    private static final String TAG = "BaseObserver";

    @Override
    public void onSubscribe(Disposable d) {
        Log.e(TAG, "onSubscribe: ");
    }

    @Override
    public void onNext(BaseResponse<T> tBaseResponse) {
        if (tBaseResponse.getStateCode() == 200) {
            onSuccess(tBaseResponse.getData());
        } else {
            onFailure(null, tBaseResponse.getMessage());
        }
    }

    @Override
    public void onError(Throwable e) {
        Log.e(TAG, "Throwable: " + e.getMessage());
    }

    @Override
    public void onComplete() {
        Log.e(TAG, "onComplete: ");
    }

    protected abstract void onFailure(Throwable e, String message);

    protected abstract void onSuccess(T data);
}
