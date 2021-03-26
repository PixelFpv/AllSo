package com.example.testapp.ui.youtube;

import android.content.ClipData;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;


import com.example.testapp.R;


public class YoutubeFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View myView = inflater.inflate(R.layout.fragment_youtube, container, false);
        WebView myWebView = myView.findViewById(R.id.webView_yt);




        myWebView.loadUrl("https://www.youtube.com");
        WebSettings webSettings = myWebView.getSettings();
        myWebView.setWebViewClient(new WebViewClient()


        {   @Override
            public boolean shouldOverrideUrlLoading (WebView view, WebResourceRequest request) {
                return false; }});

        super.onCreate(savedInstanceState);
        setRetainInstance(true);

        webSettings.setJavaScriptEnabled(true);
        myWebView.setOnKeyListener(new View.OnKeyListener()
        {   @Override
            public boolean onKey(View v, int keyCode, KeyEvent event)
            { if(event.getAction() == KeyEvent.ACTION_DOWN)
                { WebView webView = (WebView) v;
                    switch(keyCode)
                    {case KeyEvent.KEYCODE_BACK:
                        if(webView.canGoBack())
                            { webView.goBack();
                            return true; }
                            break; } }
                return false; }});



//        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh () {
//
//
//                refreshLayout.setRefreshing(false);
//            }
//        });


        return myView;

    }
}