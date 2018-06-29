package com.niles.nilesappstore.net;

import android.support.annotation.NonNull;

import com.google.gson.JsonObject;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;

/**
 * Created by Niles
 * Date 2018/6/28 15:32
 * Email niulinguo@163.com
 */
public class PgyerServiceWrapper implements PgyerService {

    private static final String API_KEY = "9891ae79f24a1aa79647d6a43c553c3a";

    @NonNull
    private final PgyerService mPgyerService;
    @NonNull
    private final RetrofitManager mRetrofitManager;

    PgyerServiceWrapper(@NonNull RetrofitManager retrofitManager) {
        mRetrofitManager = retrofitManager;
        mPgyerService = retrofitManager.getPgyerService();
    }

    @Override
    public Call<JsonObject> uploadApk(@NonNull RequestBody apiKey, @NonNull MultipartBody.Part filePart, @NonNull Map<String, RequestBody> params) {
        return mPgyerService.uploadApk(apiKey, filePart, params);
    }

    public void uploadApk(@NonNull File file, @NonNull JsonObjectCallback<?> callback) {
        final MultipartBody.Part filePart = MultipartBody.Part.createFormData("file", file.getName(), RequestBody.create(MultipartBody.FORM, file));
        mRetrofitManager.execute(uploadApk(RequestBody.create(MultipartBody.FORM, API_KEY), filePart, new HashMap<String, RequestBody>()), callback);
    }

}
