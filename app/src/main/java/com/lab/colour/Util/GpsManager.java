package com.lab.colour.Util;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

/**
 * Created by SeoHyeonBae on 2016-09-19.
 */

public class GpsManager {

    boolean isGPSEnabled;
    boolean isNetworkEnabled;

    LocationManager locationManager;
    Context context;

    public GpsManager(Context mContext){

        context = mContext;

    }

    public boolean checkEnabled(){
        // Acquire a reference to the system Location Manager
        locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);

        // GPS 프로바이더 사용가능여부
        isGPSEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        // 네트워크 프로바이더 사용가능여부
        isNetworkEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

        Log.d("Main", "isGPSEnabled=" + isGPSEnabled);
        Log.d("Main", "isNetworkEnabled=" + isNetworkEnabled);

        if(isNetworkEnabled == false || isGPSEnabled == false){
            Toast.makeText(context, "GPS를 켜주세요.", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }


    public void getUserLocationInfo(){

        LocationListener locationListener = new LocationListener() {
            public void onLocationChanged(Location location) {
                double lat = location.getLatitude();
                double lng = location.getLongitude();

                findAddress(lat, lng);
                Log.d("GpsManager", "latitude: " + lat + ", longitude: " + lng);
            }

            public void onStatusChanged(String provider, int status, Bundle extras) {
                Log.d("GpsManager", "OnStatusChanged|");
            }

            public void onProviderEnabled(String provider) {
                Log.d("GpsManager", "onProviderEnabled|");
            }

            public void onProviderDisabled(String provider) {
                Log.d("GpsManager", "onProviderDisabled|");
            }
        };

        // Register the listener with the Location Manager to receive location updates
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }else{
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
        }


        // 수동으로 위치 구하기
        String locationProvider = LocationManager.GPS_PROVIDER;
        Location lastKnownLocation = locationManager.getLastKnownLocation(locationProvider);
        if (lastKnownLocation != null) {
            double lng = lastKnownLocation.getLatitude();
            double lat = lastKnownLocation.getLatitude();
            Log.d("GpsManager", "longtitude=" + lng + ", latitude=" + lat);
            //Toast.makeText(context,  "latitude: " + String.valueOf(lat) + ", longitude: " + String.valueOf(lng),Toast.LENGTH_SHORT).show();
        }

    }


    /**
     * 위도,경도로 주소취득
     * @param lat
     * @param lng
     * @return 주소
     */
    private String findAddress(double lat, double lng) {
        String currentLocationAddress;
        StringBuffer bf = new StringBuffer();
        Geocoder geocoder = new Geocoder(context, Locale.KOREA);
        List<Address> address;
        try {
            if (geocoder != null) {
                // 세번째 인수는 최대결과값인데 하나만 리턴받도록 설정했다
                address = geocoder.getFromLocation(lat, lng, 1);
                // 설정한 데이터로 주소가 리턴된 데이터가 있으면
                if (address != null && address.size() > 0) {
                    // 주소
                    currentLocationAddress = address.get(0).getAddressLine(0).toString();

                    // 전송할 주소 데이터 (위도/경도 포함 편집)
                    bf.append(currentLocationAddress).append("#");
                    bf.append(lat).append("#");
                    bf.append(lng);

                    Log.d("주소", currentLocationAddress);
                    //Toast.makeText(context, "접속지 : " +currentLocationAddress, Toast.LENGTH_SHORT).show();
                }
            }

        } catch (IOException e) {
            Toast.makeText(context, "주소취득 실패"
                    , Toast.LENGTH_LONG).show();

            e.printStackTrace();
        }
        return bf.toString();
    }

}
