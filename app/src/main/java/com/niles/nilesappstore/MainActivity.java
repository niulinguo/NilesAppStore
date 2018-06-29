package com.niles.nilesappstore;

import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.niles.nilesappstore.model.UploadApkResultModel;
import com.niles.nilesappstore.net.JsonObjectCallback;
import com.niles.nilesappstore.net.PgyerServiceWrapper;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private PgyerServiceWrapper mPgyerServiceWrapper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPgyerServiceWrapper = MyApp.getInstance().getRetrofitManager().getPgyerServiceWrapper();
    }

    public void onUploadApkClicked(View view) {
        final File file = new File(Environment.getExternalStorageDirectory(), "app-debug.apk");
        if (!file.exists()) {
            Toast.makeText(this, "文件不存在", Toast.LENGTH_SHORT).show();
            return;
        }
        mPgyerServiceWrapper.uploadApk(file, new JsonObjectCallback<UploadApkResultModel>() {
            @Override
            public void onFailure(int code, @NonNull String message, @Nullable Throwable e) {
                Toast.makeText(MainActivity.this, message + "(" + code + ")", Toast.LENGTH_SHORT).show();
            }

            @Override
            protected void onSuccess(int code, @NonNull String message, UploadApkResultModel data) {
                Toast.makeText(MainActivity.this, message + "(" + code + ")", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
