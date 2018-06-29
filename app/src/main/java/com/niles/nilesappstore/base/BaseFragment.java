package com.niles.nilesappstore.base;

import android.content.Context;
import android.support.v4.app.Fragment;

/**
 * Created by Niles
 * Date 2018/6/29 15:20
 * Email niulinguo@163.com
 */
public class BaseFragment extends Fragment {

    protected Context mContext;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mContext = null;
    }

    public boolean isActive() {
        return mContext != null;
    }
}
