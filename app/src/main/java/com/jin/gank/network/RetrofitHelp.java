package com.jin.gank.network;

import com.jin.gank.data.Constant;
import com.squareup.okhttp.OkHttpClient;

import java.util.concurrent.TimeUnit;

import retrofit.RestAdapter;
import retrofit.client.OkClient;

/**
 * Created by Administrator on 2015/8/21.
 */
public class RetrofitHelp {
    private static RESTApi api;

    public static RESTApi getApi() {
        if (api == null) {
            OkHttpClient client = new OkHttpClient();
            client.setReadTimeout(12, TimeUnit.SECONDS);

            RestAdapter restAdapter = new RestAdapter.Builder().setClient(new OkClient(client))
                    .setEndpoint(Constant.ROOT_PATH)
                    .build();
            api = restAdapter.create(RESTApi.class);
        }

        return api;
    }
}
