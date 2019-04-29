package com.db.loan.loancenter.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.db.loan.loancenter.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.web_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainWebViewActivity.class);
                intent.putExtra(MainWebViewActivity.WEB_TITLE, "贷款超市");
                intent.putExtra(MainWebViewActivity.WEB_URL, "http://h5.ad05.pw/sys-loan/14364803240765182454.do");
                startActivity(intent);
            }
        });
    }
}
