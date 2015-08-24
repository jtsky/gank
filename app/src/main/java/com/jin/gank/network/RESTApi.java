package com.jin.gank.network;

import com.jin.gank.data.GankCategory;
import com.jin.gank.data.GankDay;
import com.jin.gank.data.GankRandom;

import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

/**
 * Created by Administrator on 2015/8/21.
 * 干货集中营 API
 */
public interface RESTApi {
    @GET("/data/{category}/{count}/{page}")
    Observable<GankCategory> listGankCategory(@Path("category") String category, @Path("count") int count, @Path("page") int page);


    @GET("/day/{year}/{month}/{day}")
    Observable<GankDay> listGankDay(@Path("year") int year, @Path("month") int month, @Path("day") int day);

    @GET("/random/data/{category}/{count}")
    Observable<GankRandom> listGankRandom(@Path("category") String category, @Path("count") int count);


}
