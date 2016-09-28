package com.lab.colour.Activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.lab.colour.Adapter.TabPagerAdapter;
import com.lab.colour.R;
import com.lab.colour.Util.GpsManager;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    static GpsManager gpsManager;
    boolean isUserPreferCheck = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.small_icon);
        toolbar.setTitle("컬러푸드");

        setTabMenu();

        gpsManager = new GpsManager(getBaseContext());
        if( gpsManager.checkEnabled() ){
            gpsManager.getUserLocationInfo();
        }

//        //취향 선호도 조사가 안된 유저에게 취향분석 할것이냐고 요청.
        if(isUserPreferCheck == false){
            askPrefer();
        }
    }

    private void askPrefer() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                MainActivity.this);

        // 제목셋팅
        alertDialogBuilder.setTitle("사용자 취향 분석");

        // AlertDialog 셋팅
        alertDialogBuilder
                .setMessage("사용자의 취향을 분석해야 정확한 맛집추천이 가능합니다. 평가 늘리기메뉴를 이용해주세요.")
                .setCancelable(false)
                .setPositiveButton("예",
                        new DialogInterface.OnClickListener() {
                            public void onClick(
                                    DialogInterface dialog, int id) {
                                // 선호도 조사 창띄우기
//                                Intent intent = new Intent(MainActivity.this, UserPrefer.class);
//                                startActivity(intent);
                            }
                        })
                .setNegativeButton("아니오",
                        new DialogInterface.OnClickListener() {
                            public void onClick(
                                    DialogInterface dialog, int id) {
                                // 다이얼로그를 취소한다
                                dialog.cancel();
                            }
                        });

        // 다이얼로그 생성
        AlertDialog alertDialog = alertDialogBuilder.create();

        // 다이얼로그 보여주기
        alertDialog.show();
    }

    //상단 메뉴 및 뷰페이저
    private void setTabMenu() {
        // Adding Toolbar to the activity
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Initializing the TabLayout
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.addTab(tabLayout.newTab().setText(getResources().getString(R.string.custom_recommend)));
        tabLayout.addTab(tabLayout.newTab().setText(getResources().getString(R.string.people_recommend)));
        tabLayout.addTab(tabLayout.newTab().setText(getResources().getString(R.string.add_review)));
        tabLayout.addTab(tabLayout.newTab().setText(getResources().getString(R.string.setting)));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        // Initializing ViewPager
        viewPager = (ViewPager) findViewById(R.id.pager);

        // Creating TabPagerAdapter adapter
        TabPagerAdapter pagerAdapter = new TabPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        // Set TabSelectedListener
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}