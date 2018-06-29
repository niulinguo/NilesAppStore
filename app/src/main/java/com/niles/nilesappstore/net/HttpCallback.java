package com.niles.nilesappstore.net;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by Niles
 * Date 2018/6/28 15:04
 * Email niulinguo@163.com
 */
public interface HttpCallback<T> {

    void onSuccess(@Nullable T result);

    void onFailure(int code, @NonNull String message, @Nullable Throwable e);

}
