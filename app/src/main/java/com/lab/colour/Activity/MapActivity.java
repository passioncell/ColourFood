package com.lab.colour.Activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.lab.colour.R;
import com.melnykov.fab.FloatingActionButton;

import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapView;

/**
 * Created by SeoHyeonBae on 2016-09-26.
 */
public class MapActivity extends Activity implements MapView.MapViewEventListener, MapView.CurrentLocationEventListener, MapView.POIItemEventListener, View.OnClickListener {

    private static final String DAUM_MAP_API_KEY = "35ecdad2e410370f26fd64a30d971a3b";
    MapView mapView;
    MapPoint userCurrentPoint;

    ProgressDialog progressDialog;
    boolean isFindUserTracking = false;

    ImageButton ib_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        initMapAndComponent();
        initFab();

    }

    private void initMapAndComponent() {
        //다음이 제공하는 MapView객체 생성 및 API Key 설정\
        mapView = new MapView(this);
        mapView.setDaumMapApiKey(DAUM_MAP_API_KEY);
        ViewGroup mapContainer = (ViewGroup) findViewById(R.id.map_view);

        mapContainer.addView(mapView);

        mapView.setMapViewEventListener(this);
        mapView.setCurrentLocationEventListener(this);
        mapView.setPOIItemEventListener(this);
        mapView.setMapType(MapView.MapType.Standard);

        ib_back = (ImageButton) findViewById(R.id.ib_map_back);
        ib_back.setOnClickListener(this);
    }

    private void initFab() {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_map_my_point);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mapView.setMapCenterPoint(userCurrentPoint, true);
            }
        });
    }


    @Override
    public void onMapViewInitialized(MapView mapView) {

//        //Move
        MapPoint restaurantPoint = MapPoint.mapPointWithGeoCoord(37.8853782, 127.7362327);
        mapView.setMapCenterPoint(restaurantPoint, true);

        //Make Marker
        MapPOIItem marker = new MapPOIItem();
        marker.setItemName("만석식당");
        marker.setTag(0);
        marker.setMapPoint(restaurantPoint);
        marker.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        marker.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.

        //Add Marker
        mapView.addPOIItem(marker);

        //사용자 트랙킹
        mapView.setCurrentLocationTrackingMode(
                MapView.CurrentLocationTrackingMode.TrackingModeOnWithHeading);
        new ShowProgress().execute(true);


    }

    @Override
    public void onMapViewCenterPointMoved(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onMapViewZoomLevelChanged(MapView mapView, int i) {

    }

    @Override
    public void onMapViewSingleTapped(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onMapViewDoubleTapped(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onMapViewLongPressed(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onMapViewDragStarted(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onMapViewDragEnded(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onMapViewMoveFinished(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onCurrentLocationUpdate(MapView mapView, MapPoint mapPoint, float v) {
        Log.e("dada", "onCurrentLocationUpdate");
        userCurrentPoint = mapPoint;
        isFindUserTracking = true;
    }

    @Override
    public void onCurrentLocationDeviceHeadingUpdate(MapView mapView, float v) {
        //Log.e("dada", String.valueOf(v));
    }

    @Override
    public void onCurrentLocationUpdateFailed(MapView mapView) {
        Log.e("dada", "onCurrentLocationUpdateFailed");
    }

    @Override
    public void onCurrentLocationUpdateCancelled(MapView mapView) {
        Log.e("dada", "onCurrentLocationUpdateCancelled");
    }

    @Override
    public void onPOIItemSelected(MapView mapView, MapPOIItem mapPOIItem) {
        Log.e("dada", "onPOIItemSelected");
    }

    @Override
    public void onCalloutBalloonOfPOIItemTouched(MapView mapView, MapPOIItem mapPOIItem) {

    }

    @Override
    public void onCalloutBalloonOfPOIItemTouched(MapView mapView, MapPOIItem mapPOIItem, MapPOIItem.CalloutBalloonButtonType calloutBalloonButtonType) {

    }

    @Override
    public void onDraggablePOIItemMoved(MapView mapView, MapPOIItem mapPOIItem, MapPoint mapPoint) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ib_map_back:
                this.onBackPressed();
                break;
            case R.id.fab_map_my_point:

        }
    }


    private class ShowProgress extends AsyncTask <Boolean, Void, Void> {

            @Override
            protected Void doInBackground(Boolean... params) {

                while(isFindUserTracking == false){
                    ;
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                progressDialog.dismiss();
            }

            @Override
            protected void onPreExecute() {
                progressDialog = new ProgressDialog(MapActivity.this);
                progressDialog.setMessage("사용자 위치 찾는중..");
                progressDialog.setCancelable(true);
                progressDialog.show();
            }
    }
}