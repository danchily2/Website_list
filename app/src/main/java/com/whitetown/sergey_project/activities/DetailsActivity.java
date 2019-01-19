package com.whitetown.sergey_project.activities;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.whitetown.sergey_project.R;
import com.whitetown.sergey_project.model.WebItem;

public class DetailsActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_activity);
        Intent intent = getIntent();
        Object webItemObject = intent.getParcelableExtra(ListActivity.INTENT_PARAM_WEB_ITEM);
        WebItem webItem = (WebItem)webItemObject;
        setTitle(webItem.getTitle());
        WebView mWebView =((WebView)findViewById(R.id.details_webview));
        setWebClient(mWebView);
        mWebView.loadUrl(webItem.getUrl());
    }

    public void setWebClient(WebView mWebView){
        mWebView.setWebViewClient(new WebViewClient() {
            @SuppressWarnings("deprecation")
            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(DetailsActivity.this, description, Toast.LENGTH_SHORT).show();
            }
            @TargetApi(android.os.Build.VERSION_CODES.M)
            @Override
            public void onReceivedError(WebView view, WebResourceRequest req, WebResourceError rerr) {
                // Redirect to deprecated method, so you can use it in all SDK versions
                onReceivedError(view, rerr.getErrorCode(), rerr.getDescription().toString(), req.getUrl().toString());
            }
        });
    }

    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        // Do something in response to button
    }
}