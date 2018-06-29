package com.niles.nilesappstore.utils;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by Niles
 * Date 2018/6/28 14:10
 * Email niulinguo@163.com
 */
public final class AppExecutors {

    private final Executor mMainThread;
    private final Executor mDiskThread;
    private final Executor mNetThread;

    private AppExecutors(Executor mainThread, Executor diskThread, Executor netThread) {
        mMainThread = mainThread;
        mDiskThread = diskThread;
        mNetThread = netThread;
    }

    public AppExecutors() {
        this(new MathExecutorService(),
                Executors.newSingleThreadExecutor(),
                Executors.newFixedThreadPool(3));
    }

    public void main(Runnable runnable) {
        mMainThread.execute(runnable);
    }

    public void disk(Runnable runnable) {
        mDiskThread.execute(runnable);
    }

    public void net(Runnable runnable) {
        mNetThread.execute(runnable);
    }

    private static final class MathExecutorService implements Executor {

        private final Handler mHandler;

        MathExecutorService() {
            mHandler = new Handler(Looper.getMainLooper());
        }

        @Override
        public void execute(@NonNull Runnable command) {
            mHandler.post(command);
        }
    }
}
