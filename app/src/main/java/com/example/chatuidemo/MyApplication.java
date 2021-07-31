package com.example.chatuidemo;

import android.app.Application;
import android.util.Log;

import com.cometchat.pro.core.AppSettings;
import com.cometchat.pro.core.CometChat;
import com.cometchat.pro.exceptions.CometChatException;
import com.cometchat.pro.uikit.ui_settings.UIKitSettings;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();


        // ComeChat
        AppSettings appSettings=new AppSettings.AppSettingsBuilder().subscribePresenceForAllUsers().setRegion(getString(R.string.comeChat_region)).build();

        CometChat.init(this, getString(R.string.comeChat_app_Id),appSettings, new CometChat.CallbackListener<String>() {
            @Override
            public void onSuccess(String successMessage) {
                UIKitSettings.setAuthKey(getString(R.string.comechat_auth_key));
                CometChat.setSource("ui-kit","android","java");
                Log.d("ComeChat", "Initialization completed successfully");
            }
            @Override
            public void onError(CometChatException e) {
                Log.d("ComeChat", "Initialization failed with exception: " + e.getMessage());
            }
        });
    }
}
