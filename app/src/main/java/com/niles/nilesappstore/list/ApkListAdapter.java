package com.niles.nilesappstore.list;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.niles.nilesappstore.R;
import com.niles.nilesappstore.databinding.ItemApkInfoBinding;
import com.niles.nilesappstore.model.ApkInfoModel;

import java.util.List;

/**
 * Created by Niles
 * Date 2018/6/29 16:02
 * Email niulinguo@163.com
 */
public class ApkListAdapter extends RecyclerView.Adapter<ApkListAdapter.ViewHolder> {

    @NonNull
    private final ApkItemClickCallback mClickCallback;
    @Nullable
    private List<ApkInfoModel> mList;

    ApkListAdapter(@NonNull ApkItemClickCallback clickCallback) {
        mClickCallback = clickCallback;
    }

    public void setList(@NonNull List<ApkInfoModel> list) {
        if (mList == null) {
            mList = list;
            notifyItemRangeChanged(0, list.size());
        } else {
            final DiffUtil.DiffResult result = DiffUtil.calculateDiff(new ApkInfoModelDiffCallback(mList, list), true);
            mList = list;
            result.dispatchUpdatesTo(this);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        final ItemApkInfoBinding binding = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.item_apk_info, viewGroup, false);
        binding.setCallback(mClickCallback);
        return new ViewHolder(binding.getRoot(), binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        assert mList != null;
        viewHolder.binding.setModel(mList.get(i));
        viewHolder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    static final class ViewHolder extends RecyclerView.ViewHolder {

        private final ItemApkInfoBinding binding;

        ViewHolder(@NonNull View itemView, ItemApkInfoBinding binding) {
            super(itemView);
            this.binding = binding;
        }
    }

}
