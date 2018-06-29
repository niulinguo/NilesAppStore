package com.niles.nilesappstore.list;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;

import com.niles.nilesappstore.MyApp;
import com.niles.nilesappstore.R;
import com.niles.nilesappstore.base.BaseActivity;
import com.niles.nilesappstore.net.PgyerServiceWrapper;

public class ApkListActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frame_layout);

        final FragmentManager fragmentManager = getSupportFragmentManager();
        ApkListFragment fragment = (ApkListFragment) fragmentManager.findFragmentByTag(ApkListFragment.TAG);
        if (fragment == null) {
            fragment = new ApkListFragment();
            final PgyerServiceWrapper pgyerServiceWrapper = MyApp.getInstance().getRetrofitManager().getPgyerServiceWrapper();
            final ApkListPresenter apkListPresenter = new ApkListPresenterImpl(fragment, pgyerServiceWrapper);
            fragment.setPresenter(apkListPresenter);
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.fl_content, fragment, ApkListFragment.TAG)
                    .commit();
        }
    }

}
