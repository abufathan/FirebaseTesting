package com.testing.firebasetesting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.adjust.sdk.Adjust;
import com.adjust.sdk.AdjustEvent;
import com.google.firebase.analytics.FirebaseAnalytics;

import java.util.Random;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {
    private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        String id = getId();
        String name = getName();

        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, id);
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, name);
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "image");
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);

        System.out.println("NOVAL : " + id + "-" + name);

        AdjustEvent event = new AdjustEvent("szg9mf");
        event.addPartnerParameter("id", id + "kirim");
        event.addPartnerParameter("name", name);
        event.addPartnerParameter("content_type", "image");


        AdjustEvent event1 = new AdjustEvent("z18b6m");
        event1.addPartnerParameter("id", id + "kirim");
        event1.addPartnerParameter("name", name);
        event1.addPartnerParameter("content_type", "image");

        Adjust.trackEvent(event);
        Adjust.trackEvent(event1);


    }

    private String getName() {
        char[] chars1 = "ABCDEF012GHIJKL345MNOPQR678STUVWXYZ9".toCharArray();
        StringBuilder sb1 = new StringBuilder();
        Random random1 = new Random();
        for (int i = 0; i < 6; i++)
        {
            char c1 = chars1[random1.nextInt(chars1.length)];
            sb1.append(c1);
        }
        return sb1.toString();
    }

    private String getId() {
        return String.valueOf(System.currentTimeMillis());
    }
}
