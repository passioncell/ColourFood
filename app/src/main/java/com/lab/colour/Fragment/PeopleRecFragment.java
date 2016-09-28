package com.lab.colour.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.lab.colour.Activity.DetailActivity;
import com.lab.colour.Activity.FilterActivity;
import com.lab.colour.Adapter.RestaurantAdapter;
import com.lab.colour.Model.Restaurant;
import com.lab.colour.R;
import com.melnykov.fab.FloatingActionButton;

import java.util.Vector;

/**
 * Created by SeoHyeonBae on 2016-09-18.
 */
public class PeopleRecFragment extends Fragment implements AdapterView.OnItemClickListener {

    View view;
    private ListView m_ListView;
    private RestaurantAdapter m_Adapter;
    public Vector<Restaurant> vector = new Vector<Restaurant>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.fragment_people_rec, container, false);

        initFab();

        m_ListView = (ListView) view.findViewById(R.id.lv_people);
        m_Adapter = new RestaurantAdapter(getContext());
        m_ListView.setAdapter(m_Adapter);
        m_ListView.setOnItemClickListener(this);

        Restaurant restaurant = new Restaurant();
        restaurant.setImageURL("http://cfile27.uf.tistory.com/image/223604505122FD960ED899");
        restaurant.setRating(4.7f);
        restaurant.setDistance(0.4f);
        restaurant.setRestaurantName("현배 레스토랑");
        restaurant.setAddress("춘천시 효자동 123-12 1층");
        restaurant.setReviewCnt(270);
        restaurant.setLike(false);

        Restaurant restaurant2 = new Restaurant();
        restaurant2.setImageURL("http://cfile27.uf.tistory.com/image/20055D4D4D94104230AA52");
        restaurant2.setRating(2.5f);
        restaurant2.setDistance(0.9f);
        restaurant2.setRestaurantName("메칸더 찬민 분식집");
        restaurant2.setAddress("춘천시 효자동 123-12 2층");
        restaurant2.setReviewCnt(5);
        restaurant2.setLike(false);

        Restaurant restaurant3 = new Restaurant();
        restaurant3.setImageURL("http://cfile8.uf.tistory.com/image/2334274953DFBCF3378D69");
        restaurant3.setRating(2.5f);
        restaurant3.setDistance(0.9f);
        restaurant3.setRestaurantName("메칸더 찬민 분식집");
        restaurant3.setAddress("춘천시 효자동 123-12 2층");
        restaurant3.setReviewCnt(5);
        restaurant3.setLike(false);

        m_Adapter.addItem(restaurant);
        m_Adapter.addItem(restaurant2);
        m_Adapter.addItem(restaurant3);

        return view;
    }

    private void initFab() {
        ListView listView = (ListView) view.findViewById(R.id.lv_people);
        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab_people);
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
        Log.e("zz", "Item Clicked #");
        Intent goDetail = new Intent(getContext(), DetailActivity.class);
        startActivity(goDetail);
    }
}