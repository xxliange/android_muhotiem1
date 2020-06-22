package com.example.muhoitem1.model;

import com.example.muhoitem1.model.domain.HomeData.BannerData;
import com.example.muhoitem1.model.domain.HomeData.HomeGraduateData;
import com.example.muhoitem1.model.domain.HomeData.HomeNewVideoData;
import com.example.muhoitem1.model.domain.HomeData.HomePayAlbumListData;
import com.example.muhoitem1.model.domain.HomeData.HomePrivateData;
import com.example.muhoitem1.model.domain.HomeData.HomeTeachData;
import com.example.muhoitem1.model.domain.HotData.HotListData;
import com.example.muhoitem1.model.domain.HomeData.StarListData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {
    /**
     * 获取首页banner图数据
     * @param device_type
     * @param business_type
     * @return
     */
    @GET("getBanner")
    Call<BannerData> getBannerData(@Query("device_type") int device_type,@Query("business_type") int business_type);

    /**
     * 获取热点列表
     * @param l
     * @return
     */
    @GET("hotlist")
    Call<HotListData> getHotListData(@Query("l") int l);

    /**
     * 获取首页球星列表
     * @return
     */
    @GET("getVipPlayer")
    Call<StarListData> getStarListData();

    /**
     * 获取首页精品专辑列表
     * @return
     */
    @GET("getTeachingAlbum")
    Call<HomePayAlbumListData> getHomePayAlbumListData();

    /**
     * 获取首页幕后教学列表
     * @return
     */
    @GET("teachGroupByCategory")
    Call<HomeTeachData> getHomeTeachData();

    /**
     * 获取首页研究所列表
     * @return
     */
    @GET("getSubjectByType")
    Call<HomeGraduateData> getHomeGraduateData(@Query("type") int type, @Query("l") int l);

    /**
     * 获取首页最新视频列表
     * @return
     */
    @GET("webHomeContentVideo")
    Call<HomeNewVideoData> getHomeNewVideoData();
    @GET("getPrivateWorkouts")
    Call<HomePrivateData> getHomePrivateData(@Query("l") int l);
}
