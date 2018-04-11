package com.manooz.myjobs;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.manooz.jobs_search_engine_material.R;

public class about extends AppCompatActivity {
    private TextView email;
    private TextView appname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        email = (TextView)findViewById(R.id.email);
        appname = (TextView)findViewById(R.id.appname2);

        email.setText("This App Made By Yaman AlKhateeb \n" +" You Can Contact Me At My Email manoo.sar@gmail.com \n  the app is free and open source \n check the source From here \n " +
                "https://goo.gl/zKhj8Q");

    }
}
