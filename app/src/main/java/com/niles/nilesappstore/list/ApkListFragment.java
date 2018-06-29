package com.niles.nilesappstore.list;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.niles.nilesappstore.R;
import com.niles.nilesappstore.base.BaseFragment;
import com.niles.nilesappstore.databinding.ListLayoutBinding;
import com.niles.nilesappstore.model.ApkInfoModel;

import java.util.List;

/**
 * Created by Niles
 * Date 2018/6/29 15:20
 * Email niulinguo@163.com
 */
public class ApkListFragment extends BaseFragment implements ApkListView, ApkItemClickCallback {

    static final String TAG = ApkListFragment.class.getSimpleName();

    private ApkListPresenter mApkListPresenter;
    private ApkListAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final ListLayoutBinding binding = DataBindingUtil.inflate(inflater, R.layout.list_layout, container, false);
        mAdapter = new ApkListAdapter(this);
        binding.recyclerView.setAdapter(mAdapter);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mApkListPresenter.start();
    }

    @Override
    public void onLoadApkListSuccess(@NonNull List<ApkInfoModel> list) {
        mAdapter.setList(list);
    }

    @Override
    public void onLoadApkListFailure(@NonNull String message) {
        Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPresenter(ApkListPresenter presenter) {
        mApkListPresenter = presenter;
    }

    @Override
    public void onClick(ApkInfoModel model) {
        Toast.makeText(mContext, "点击了" + model.getBuildName(), Toast.LENGTH_SHORT).show();
    }
}
