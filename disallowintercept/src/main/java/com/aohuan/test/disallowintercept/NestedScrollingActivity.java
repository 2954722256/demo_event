package com.aohuan.test.disallowintercept;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.aohuan.test.disallowintercept.view.ListViewForScrollView;
import com.zhy.adapter.abslistview.CommonAdapter;
import com.zhy.adapter.abslistview.ViewHolder;

import java.util.ArrayList;

public class NestedScrollingActivity extends AppCompatActivity {
    WebView mWebView;
    ListViewForScrollView lv;
    ArrayList<String> strList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nested_scrolling);

        getView();
    }

    private void getView() {

        mWebView = (WebView) findViewById(R.id.webv);
//        mWebView.loadUrl("http://baidu.com");
        mWebView.loadUrl("http://www.jianshu.com/");
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

        lv = (ListViewForScrollView) findViewById(R.id.lv);
        lv.setAdapter(new CommonAdapter<String>(this, R.layout.item_lv_string, initData()) {
            @Override
            protected void convert(ViewHolder viewHolder, String item, int position) {
                viewHolder.setText(R.id.tv_item, item);
            }
        });
    }

    private ArrayList<String> initData() {
        if(strList.size() != 0)
            return strList;
        for(int i=0; i<20; i++){
            strList.add("item : " + i);
        }
        return strList;
    }
}
