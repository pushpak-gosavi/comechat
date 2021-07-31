package com.example.chatuidemo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.cometchat.pro.core.CometChat;
import com.cometchat.pro.exceptions.CometChatException;
import com.cometchat.pro.models.User;
import com.cometchat.pro.uikit.ui_components.cometchat_ui.CometChatUI;
import com.example.chatuidemo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        //setContentView(R.layout.activity_main);
        comeChatLogin();
        activityMainBinding.btnChat.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, CometChatUI.class))
        );
    }


    private void comeChatLogin() {
        CometChat.login("superhero5", getString(R.string.comechat_auth_key), new CometChat.CallbackListener<User>() {
            @Override
            public void onSuccess(User user) {
                Log.e("comchatLogin",user.getName());
            }

            @Override
            public void onError(CometChatException e) {

            }
        });
    }
}