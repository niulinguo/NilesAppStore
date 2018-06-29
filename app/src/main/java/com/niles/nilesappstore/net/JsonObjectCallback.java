package com.niles.nilesappstore.net;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.google.gson.JsonObject;
import com.google.gson.internal.$Gson$Types;
import com.niles.nilesappstore.MyApp;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by Niles
 * Date 2018/6/28 15:06
 * Email niulinguo@163.com
 */
public abstract class JsonObjectCallback<T> implements HttpCallback<JsonObject> {

    private static Type getSuperclassTypeParameter(Class<?> subclass) {
        final Type superclass = subclass.getGenericSuperclass();
        if (superclass instanceof Class) {
            throw new RuntimeException("Missing type parameter.");
        }
        final ParameterizedType parameterized = (ParameterizedType) superclass;
        return $Gson$Types.canonicalize(parameterized.getActualTypeArguments()[0]);
    }

    @Override
    public void onSuccess(@Nullable JsonObject result) {
        if (result == null) {
            onFailure(-2, "result is null", null);
        } else {
            final int code = result.get("code").getAsInt();
            final String message = result.get("message").getAsString();
            if (code == 0) {
                final Type type = getSuperclassTypeParameter(getClass());
                final T data = MyApp.getInstance().getGson().fromJson(result.get("data"), type);
                onSuccess(code, TextUtils.isEmpty(message) ? "Success" : message, data);
            } else {
                onFailure(code, message, null);
            }
        }
    }

    protected abstract void onSuccess(int code, @NonNull String message, @Nullable T data);
}
