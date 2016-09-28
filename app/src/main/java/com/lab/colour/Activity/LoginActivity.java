package com.lab.colour.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.lab.colour.R;

/**
 * Created by SeoHyeonBae on 2016-09-19.
 */
public class LoginActivity extends Activity {

    EditText et_id, et_pw;
    Button bt_login, bt_join;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initComponent();

    }

    private void initComponent() {
        et_id = (EditText) findViewById(R.id.et_login_id);
        et_pw = (EditText) findViewById(R.id.et_login_pw);
        bt_login = (Button) findViewById(R.id.bt_login_login);
        bt_join = (Button) findViewById(R.id.bt_login_join);

        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });


        bt_join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, JoinActivity.class);
                startActivity(i);
            }
        });
    }
}
