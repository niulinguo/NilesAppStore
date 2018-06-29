package com.niles.nilesappstore;

import android.app.Application;
import android.content.Context;

import com.google.gson.Gson;
import com.niles.nilesappstore.net.RetrofitManager;
import com.niles.nilesappstore.utils.AppExecutors;
import com.niles.nilesappstore.utils.GsonUtils;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.pgyersdk.crash.PgyCrashManager;
import com.pgyersdk.crash.PgyerCrashObservable;
import com.pgyersdk.crash.PgyerObserver;

/**
 * Created by Niles
 * Date 2018/6/28 10:27
 * Email niulinguo@163.com
 */
public class MyApp extends Application {

    private static MyApp sInstance;
    private RetrofitManager mRetrofitManager;
    private AppExecutors mAppExecutors;
    private GsonUtils mGsonUtils;

    public static MyApp getInstance() {
        return sInstance;
    }

    public AppExecutors getAppExecutors() {
        return mAppExecutors;
    }

    public RetrofitManager getRetrofitManager() {
        return mRetrofitManager;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        sInstance = this;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Logger.addLogAdapter(new AndroidLogAdapter());
        Logger.e("application create");
        PgyCrashManager.register();
        PgyerCrashObservable.get().attach(new PgyerObserver() {
            @Override
            public void receivedCrash(Thread thread, Throwable throwable) {
                Logger.e(throwable.getMessage(), throwable);
            }
        });
        mGsonUtils = new GsonUtils();
        mRetrofitManager = new RetrofitManager();
        mAppExecutors = new AppExecutors();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        sInstance = null;
    }

    public Gson getGson() {
        return mGsonUtils.getGson();
    }
}
