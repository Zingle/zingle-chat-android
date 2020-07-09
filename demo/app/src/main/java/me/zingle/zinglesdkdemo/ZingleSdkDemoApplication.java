package me.zingle.zinglesdkdemo;

import android.app.Application;

import androidx.annotation.NonNull;

import me.zingle.core.InitializationStatus;
import me.zingle.core.Settings;
import me.zingle.core.Zingle;
import me.zingle.core.ZingleCallback;

public class ZingleSdkDemoApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //Initialize Zingle with your app id in your Zingle Service Settings
        Zingle.init(this, new Settings("YOUR_APP_ID"), new ZingleCallback<InitializationStatus>() {
            @Override
            public void run(@NonNull Response<InitializationStatus> response) {
                //Your code for an initialize response here
            }
        });
    }
}
