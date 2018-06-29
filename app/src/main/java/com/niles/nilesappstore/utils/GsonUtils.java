package com.niles.nilesappstore.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by Niles
 * Date 2018/6/28 17:58
 * Email niulinguo@163.com
 */
public final class GsonUtils {

    private final Gson mGson;

    public GsonUtils() {
        mGson = new GsonBuilder()
                .create();
    }

    public Gson getGson() {
        return mGson;
    }
}
