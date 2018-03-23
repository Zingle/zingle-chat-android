package me.zingle.zinglesdkdemo;

import android.app.Application;

import me.zingle.core.Settings;
import me.zingle.core.Zingle;
import me.zingle.core.ZingleCallback;

public class ZingleSdkDemoApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //Initialize Zingle with your app id in your Zingle Service Settings
        Zingle.init(this, new Settings("YOUR_APP_ID"), new ZingleCallback() {
            @Override
            public void run(Response response) {
                //Your code for an initialize response here
            }
        });
    }
}
