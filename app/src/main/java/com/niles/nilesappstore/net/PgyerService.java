package com.niles.nilesappstore.net;

import android.support.annotation.NonNull;

import com.google.gson.JsonObject;

import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;

/**
 * Created by Niles
 * Date 2018/6/28 10:21
 * Email niulinguo@163.com
 */
public interface PgyerService {

    @Multipart
    @POST("app/upload")
    Call<JsonObject> uploadApk(@NonNull @Part("_api_key") RequestBody apiKey, @NonNull @Part MultipartBody.Part filePart, @NonNull @PartMap Map<String, RequestBody> params);
}
