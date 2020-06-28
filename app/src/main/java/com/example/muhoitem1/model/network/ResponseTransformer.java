package com.example.muhoitem1.model.network;

import com.example.muhoitem1.model.BaseResponse;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class ResponseTransformer {
    private ResponseTransformer() {throw new AssertionError();}

    public static <T> ObservableTransformer<T, T> switchSchedulers(){
        return upstream -> upstream.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    /**
     * 对结果进行预处理,只返回成功的结果
     */
    public static <T> ObservableTransformer<BaseResponse<T>, T> handleRequest2(){
        return upstream -> upstream.flatMap((Function<BaseResponse<T>, ObservableSource<T>>) tBaseResponse -> createObservable(tBaseResponse.getData()));
    }

    private static <T> Observable<T> createObservable(T data) {
        return Observable.create(emitter -> {
            emitter.onNext(data);
            emitter.onComplete();
        });
    }
}
