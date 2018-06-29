package com.niles.nilesappstore.list;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.niles.nilesappstore.model.ApkInfoModel;
import com.niles.nilesappstore.model.ApkListModel;
import com.niles.nilesappstore.net.JsonObjectCallback;
import com.niles.nilesappstore.net.PgyerServiceWrapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Niles
 * Date 2018/6/29 15:33
 * Email niulinguo@163.com
 */
public class ApkListPresenterImpl implements ApkListPresenter {

    @NonNull
    private final PgyerServiceWrapper mPgyerServiceWrapper;
    @NonNull
    private final ApkListView mApkListView;

    ApkListPresenterImpl(@NonNull ApkListView apkListView, @NonNull PgyerServiceWrapper pgyerServiceWrapper) {
        mApkListView = apkListView;
        mPgyerServiceWrapper = pgyerServiceWrapper;
    }

    @Override
    public void start() {
        loadApkList();
    }

    @Override
    public void loadApkList() {
        mPgyerServiceWrapper.apkList(null, new JsonObjectCallback<ApkListModel>() {
            @Override
            protected void onSuccess(int code, @NonNull String message, @Nullable ApkListModel data) {
                if (mApkListView.isActive()) {
                    final List<ApkInfoModel> list = data == null ? new ArrayList<ApkInfoModel>() : data.getList();
                    mApkListView.onLoadApkListSuccess(list == null ? new ArrayList<ApkInfoModel>() : list);
                }
            }

            @Override
            public void onFailure(int code, @NonNull String message, @Nullable Throwable e) {
                if (mApkListView.isActive()) {
                    mApkListView.onLoadApkListFailure(message + "(" + code + ")");
                }
            }
        });
    }
}
