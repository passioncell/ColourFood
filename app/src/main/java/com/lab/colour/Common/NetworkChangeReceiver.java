package com.lab.colour.Common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.lab.colour.R;
import com.lab.colour.Util.NetworkUtil;

public class NetworkChangeReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(final Context context, final Intent intent) {

        String status = NetworkUtil.getConnectivityStatusString(context);

        if(status.equals(context.getResources().getString(R.string.network_not_connected))){
           //네트워크 연결 끊긴경우 나중에 구현한다.
        }

        Toast.makeText(context, status, Toast.LENGTH_LONG).show();
    }
}