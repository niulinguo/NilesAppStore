package com.niles.nilesappstore.list;

import android.support.annotation.NonNull;

import com.niles.nilesappstore.base.BaseView;
import com.niles.nilesappstore.model.ApkInfoModel;

import java.util.List;

/**
 * Created by Niles
 * Date 2018/6/29 15:32
 * Email niulinguo@163.com
 */
public interface ApkListView extends BaseView<ApkListPresenter> {

    void onLoadApkListSuccess(@NonNull List<ApkInfoModel> list);

    void onLoadApkListFailure(@NonNull String message);

}
