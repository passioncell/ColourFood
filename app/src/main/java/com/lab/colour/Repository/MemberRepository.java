package com.lab.colour.Repository;

import android.util.Log;

import com.lab.colour.Abstract.IMemberRepository;
import com.lab.colour.Common.URLInfo;
import com.lab.colour.Model.JoinModel;
import com.lab.colour.Util.HttpMessage;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;

/**
 * Created by SeoHyeonBae on 2016-11-18.
 */

public class MemberRepository implements IMemberRepository {

    private static final String TAG = "MemberRepository";
    private URL url;
    private HttpMessage httpMessage;

    @Override
    public String join(JoinModel joinModel) {
        try {
            url = new URL(URLInfo.Member_Join);
            httpMessage = new HttpMessage(url);
            Properties prop = new Properties();
            prop.setProperty("id", joinModel.getId());
            prop.setProperty("pw", joinModel.getPw());
            prop.setProperty("sex", joinModel.getSex());
            prop.setProperty("birthday", String.valueOf(joinModel.getBirthday()));
            prop.setProperty("residentRagion", joinModel.getResidentRagion());
            prop.setProperty("preferRagion", joinModel.getPreferRagion());

            return HttpMessage.getWebContentText(httpMessage.sendGetMessage(prop));

        } catch (IOException e1) {
            Log.d(TAG,  e1.getMessage());
            return "catch";
        }
    }

    @Override
    public String login(String id, String pw) {
        try {
            url = new URL(URLInfo.Member_Login);
            httpMessage = new HttpMessage(url);
            Properties prop = new Properties();
            prop.setProperty("id", id);
            prop.setProperty("pw", pw);

            return HttpMessage.getWebContentText(httpMessage.sendGetMessage(prop));

        } catch (IOException e1) {
            Log.d(TAG,  e1.getMessage());
            return "catch";
        }
    }
}
