package com.hail.customdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.hail.customdemo.activity.ClockActivity;
import com.hail.customdemo.activity.ViewPagerActivity;
import com.hail.customdemo.activity.WaterWaveActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.clock, R.id.viewPager, R.id.water})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.clock:
                startActivity(new Intent(this, ClockActivity.class));
                break;
            case R.id.viewPager:
                startActivity(new Intent(this, ViewPagerActivity.class));
                break;
            case R.id.water:
                startActivity(new Intent(this, WaterWaveActivity.class));
                break;
        }
    }
}
