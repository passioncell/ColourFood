package com.lab.colour.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.lab.colour.Activity.DetailActivity;
import com.lab.colour.Activity.FilterActivity;
import com.lab.colour.Adapter.LvRestaurantAdapter;
import com.lab.colour.Model.Restaurant;
import com.lab.colour.R;
import com.melnykov.fab.FloatingActionButton;

import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by SeoHyeonBae on 2016-09-18.
 */
public class CustomRecFragment extends Fragment implements AdapterView.OnItemClickListener {

    View view;
    private ListView m_ListView;
    private LvRestaurantAdapter m_Adapter;
    public Vector<Restaurant> vector = new Vector<Restaurant>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.fragment_custom_rec, container, false);

        initFab();

        m_ListView = (ListView) view.findViewById(R.id.lv_custom);
        m_Adapter = new LvRestaurantAdapter(getContext());
        m_ListView.setAdapter(m_Adapter);
        m_ListView.setOnItemClickListener(this);

        Restaurant restaurant = new Restaurant();
        ArrayList<String> imageUrls = new ArrayList<String>();
        imageUrls.add("http://scontent.cdninstagram.com/t51.2885-15/s480x480/e35/c236.0.608.608/13562048_252704298440920_205929756_n.jpg?ig_cache_key=MTI4MjMyNDgzNDM4MjQwOTUyMQ%3D%3D.2.c");
        imageUrls.add("https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcS29dh4OZzULJ_BdHALqYeKQP4mBMEWyrv6iQRD_sjTAboR6Z2X");
        imageUrls.add("https://scontent-ams3-1.cdninstagram.com/t51.2885-15/s640x640/sh0.08/e35/c135.0.810.810/12959989_555597221266462_1239938265_n.jpg?ig_cache_key=MTIyMzA5MjA5MDExMTA1Mjc5NQ%3D%3D.2.c");
        restaurant.setImageUrls(imageUrls);
        restaurant.setRating(4.5f);
        restaurant.setDistance(0.4f);
        restaurant.setRestaurantName("만석식당");
        restaurant.setAddress("강원도 춘천시 우두동 충열로 70");
        restaurant.setReviewCnt(270);
        restaurant.setLike(false);
        restaurant.setPhoneNumber("033-256-6711");
        restaurant.setLat("37.8853782");
        restaurant.setLon("127.7362327");
        restaurant.setTag("#점심밥집 #한식 #가성비깡패");
        restaurant.setCategory("한식");
        restaurant.setDetail("이용시간 09:00 ~ 24:00\n" +
        "특이사항 : 주차 불가능");

        Restaurant restaurant2 = new Restaurant();
        ArrayList<String> imageUrls2 = new ArrayList<String>();
        imageUrls2.add("https://s3-ap-northeast-1.amazonaws.com/withblog/post/8a/3a/8a3ae5cbe1789f8be84720346d978152");
        imageUrls2.add("http://cfile235.uf.daum.net/image/2565803E55C8B5B21F01BB");
        imageUrls2.add("https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcSeY4PwxWOqNCWliFbYlu7Zu9xdsnyr0gGGYrzv5CSI4T2aT16W");
        restaurant2.setImageUrls(imageUrls2);
        restaurant2.setRating(3.2f);
        restaurant2.setDistance(0.9f);
        restaurant2.setRestaurantName("금정수제갈비");
        restaurant2.setAddress("강원도 춘천시 석사동 737-6");
        restaurant2.setReviewCnt(5);
        restaurant2.setLike(false);
        restaurant2.setPhoneNumber("033-264-3989");
        restaurant2.setLat("37.8669560");
        restaurant2.setLon("127.7522080");
        restaurant2.setTag("#고기 #가족끼리 #수제");
        restaurant2.setCategory("한식");
        restaurant2.setDetail("이용시간 09:00 ~ 24:00\n" +
                "특이사항 : 주차 불가능");

        Restaurant restaurant3 = new Restaurant();
        ArrayList<String> imageUrls3 = new ArrayList<String>();
        imageUrls3.add("https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcTcc8XWS-7aLngzaQ9zzY5cbVRAeMVQeT9Cqydc-9FNA-a03HNY");
        imageUrls3.add("https://thumb-wishbeen.akamaized.net/medium/img-wishbeen.akamaized.net/post/1455364708968_IMG_1335.jpeg");
        imageUrls3.add("http://mblogthumb2.phinf.naver.net/20120623_89/jg_koo_1340452849268tR6Cb_JPEG/003.jpg?type=w2");
        restaurant3.setImageUrls(imageUrls3);
        restaurant3.setRating(4.5f);
        restaurant3.setDistance(0.9f);
        restaurant3.setRestaurantName("중화요리 죽향");
        restaurant3.setAddress("강원도 춘천시 효자2동 183-6");
        restaurant3.setReviewCnt(5);
        restaurant3.setLike(false);
        restaurant3.setPhoneNumber("033-253-9031");
        restaurant3.setLat("37.8707240");
        restaurant3.setLon("127.7393240");
        restaurant3.setTag("#대식가 #중식 #가성비깡패");
        restaurant3.setCategory("중식");
        restaurant3.setDetail("이용시간 09:00 ~ 24:00\n" +
                "특이사항 : 주차 불가능");

        m_Adapter.addItem(restaurant);
        m_Adapter.addItem(restaurant2);
        m_Adapter.addItem(restaurant3);

        vector.add(restaurant);
        vector.add(restaurant2);
        vector.add(restaurant3);

        return view;
    }

    private void initFab() {
        ListView listView = (ListView) view.findViewById(R.id.lv_custom);
        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab_custom);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), FilterActivity.class);
                startActivity(intent);

            }
        });
        fab.attachToListView(listView);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent goDetail = new Intent(getContext(), DetailActivity.class);
        goDetail.putExtra("restaurantDetailObject", vector.get(position));
        startActivity(goDetail);
    }
}