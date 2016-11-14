package com.lab.colour.Activity;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.lab.colour.Adapter.DetailImagePagerAdapter;
import com.lab.colour.R;

/**
 * Created by SeoHyeonBae on 2016-09-24.
 */
public class DetailActivity extends Activity implements View.OnClickListener, ViewPager.OnPageChangeListener {


    DetailImagePagerAdapter mCustomPagerAdapter;
    ViewPager mViewPager;
    Button btn_call, btn_map, btn_share;
    ImageButton ib_back;
    TextView tv_image_cnt;
    RatingBar ratingBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        btn_call = (Button) findViewById(R.id.bt_detail_call);
        btn_map = (Button) findViewById(R.id.bt_detail_map);
        btn_share = (Button) findViewById(R.id.bt_detail_share);
        tv_image_cnt = (TextView) findViewById(R.id.tv_detail_image_cnt);
        ib_back = (ImageButton) findViewById(R.id.ib_detail_back);
        ratingBar = (RatingBar) findViewById(R.id.rb_detail);


        btn_call.setOnClickListener(this);
        btn_map.setOnClickListener(this);
        btn_share.setOnClickListener(this);
        ib_back.setOnClickListener(this);

        ratingBar.setStepSize((float)0.5);
        ratingBar.setRating((float)4.5);
        ratingBar.setIsIndicator(true);


        mCustomPagerAdapter = new DetailImagePagerAdapter(this);

        mViewPager = (ViewPager) findViewById(R.id.vp_detail);
        mViewPager.setAdapter(mCustomPagerAdapter);
        mViewPager.setOnPageChangeListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_detail_call:
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(getApplicationContext(),"[설정 > 권한]에서 전화하기 기능을 켜주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }else{
                    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:010-7160-3434"));
                    startActivity(intent);
                }
                break;
            case R.id.bt_detail_map:
                Intent mapIntent = new Intent(DetailActivity.this, MapActivity.class);
                startActivity(mapIntent);

                break;
            case R.id.bt_detail_share:
                Intent msg = new Intent(Intent.ACTION_SEND);
                msg.addCategory(Intent.CATEGORY_DEFAULT);
                msg.putExtra(Intent.EXTRA_SUBJECT, "컬러푸드");
                msg.putExtra(Intent.EXTRA_TEXT, "사용자별 맞춤 맛집 추천 서비스 컬러푸드입니다.");
                msg.putExtra(Intent.EXTRA_TITLE, "컬러푸드");
                msg.setType("text/plain");
                startActivity(Intent.createChooser(msg, "공유"));
                break;
            case R.id.ib_detail_back:
                this.onBackPressed();
                break;
        }
    }



    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        tv_image_cnt.setText(String.valueOf(position+1)+ "/3");
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


}
