package com.example.muhoitem1.model;

import com.example.muhoitem1.model.domain.BannerData;
import com.example.muhoitem1.model.domain.HotListData;
import com.example.muhoitem1.model.domain.StarListData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {
    @GET("getBanner")
    Call<BannerData> getBannerData(@Query("device_type") int device_type,@Query("business_type") int business_type);
    @GET("hotlist")
    Call<HotListData> getHotListData(@Query("l") int l);
    @GET("getVipPlayer")
    Call<StarListData> getStarListData();
}
