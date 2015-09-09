package com.jin.gank.network;

import com.jin.gank.data.Constant;
import com.squareup.okhttp.OkHttpClient;

import java.util.concurrent.TimeUnit;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;


/**
 * Created by Administrator on 2015/8/21.
 */
public class RetrofitHelp {
    private static RESTApi api;

    public static RESTApi getApi() {
        if (api == null) {
            OkHttpClient client = new OkHttpClient();
            client.setReadTimeout(12, TimeUnit.SECONDS);

            Retrofit retrofit = new Retrofit.Builder().client(client)
                    .baseUrl(Constant.ROOT_PATH)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
            api = retrofit.create(RESTApi.class);
        }

        return api;
    }
}
