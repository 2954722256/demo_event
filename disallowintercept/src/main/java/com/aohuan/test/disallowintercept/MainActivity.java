package com.aohuan.test.disallowintercept;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWebView = (WebView) findViewById(R.id.webv);
//        mWebView.loadUrl("http://baidu.com");
        mWebView.loadUrl("http://www.jianshu.com/");
        mWebView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                return super.shouldOverrideUrlLoading(view, url);
                view.loadUrl(url);
                return true;
            }
        });
        mWebView.getSettings().setJavaScriptEnabled(true);


        setViewIntent(R.id.tv1, R.id.tv2, R.id.tv3, R.id.tv4, R.id.tv5);
    }


    public void setViewIntent(int... viewIds){
        for(int viewId: viewIds){
            findViewById(viewId).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(MainActivity.this, NestedScrollingActivity.class));
                }
            });
        }
    }

}
