package com.niles.nilesappstore.list;

import android.support.annotation.Nullable;
import android.support.v7.util.DiffUtil;

import com.niles.nilesappstore.model.ApkInfoModel;

import java.util.List;

/**
 * Created by Niles
 * Date 2018/6/29 16:20
 * Email niulinguo@163.com
 */
public class ApkInfoModelDiffCallback extends DiffUtil.Callback {

    @Nullable
    private final List<ApkInfoModel> mOldList;
    @Nullable
    private final List<ApkInfoModel> mNewList;

    ApkInfoModelDiffCallback(@Nullable List<ApkInfoModel> oldList, @Nullable List<ApkInfoModel> newList) {
        mOldList = oldList;
        mNewList = newList;
    }

    @Override
    public int getOldListSize() {
        return mOldList == null ? 0 : mOldList.size();
    }

    @Override
    public int getNewListSize() {
        return mNewList == null ? 0 : mNewList.size();
    }

    @Override
    public boolean areItemsTheSame(int i, int i1) {
        assert mOldList != null;
        assert mNewList != null;
        return mOldList.get(i).getBuildIdentifier().equals(mNewList.get(i1).getBuildIdentifier());
    }

    @Override
    public boolean areContentsTheSame(int i, int i1) {
        assert mOldList != null;
        assert mNewList != null;
        return mOldList.get(i).equals(mNewList.get(i1));
    }
}
