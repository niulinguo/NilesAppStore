package com.niles.nilesappstore.net;

import android.support.annotation.NonNull;
import android.util.Log;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Niles
 * Date 2018/6/28 10:15
 * Email niulinguo@163.com
 */
public final class RetrofitManager {

    /**
     * 蒲公英服务 Retrofit
     */
    @NonNull
    private final Retrofit mPgyerRetrofit;

    private PgyerService mPgyerService;
    private PgyerServiceWrapper mPgyerServiceWrapper;

    public RetrofitManager() {
        mPgyerRetrofit = new Retrofit.Builder()
                .baseUrl("https://www.pgyer.com/apiv2/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient.Builder()
                        .addInterceptor(new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                            @Override
                            public void log(String message) {
                                Log.d("http", message);
                            }
                        })
                                .setLevel(HttpLoggingInterceptor.Level.BODY))
                        .build())
                .build();
    }

    @NonNull
    public PgyerService getPgyerService() {
        if (mPgyerService == null) {
            mPgyerService = mPgyerRetrofit.create(PgyerService.class);
        }
        return mPgyerService;
    }

    @NonNull
    public PgyerServiceWrapper getPgyerServiceWrapper() {
        if (mPgyerServiceWrapper == null) {
            mPgyerServiceWrapper = new PgyerServiceWrapper(this);
        }
        return mPgyerServiceWrapper;
    }

    public <T> void execute(@NonNull Call<T> call, @NonNull final HttpCallback<T> callback) {
        call.enqueue(new Callback<T>() {
            @Override
            public void onResponse(@NonNull Call<T> call, @NonNull Response<T> response) {
                final int code = response.code();
                if (code == 200) {
                    callback.onSuccess(response.body());
                } else {
                    callback.onFailure(code, response.message(), null);
                }
            }

            @Override
            public void onFailure(@NonNull Call<T> call, @NonNull Throwable t) {
                callback.onFailure(-1, t.getMessage(), t);
            }
        });
    }
}
