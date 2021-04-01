package com.example.testapp.ui.youtube;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;


import com.example.testapp.R;
import com.example.testapp.ui.Facebook.FacebookFragment;

import java.time.Instant;


public class YoutubeFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View myView = inflater.inflate(R.layout.fragment_youtube, container, false);
        WebView myWebView = myView.findViewById(R.id.webView_yt);
        myWebView.loadUrl("https://m.youtube.com");
        WebSettings webSettings = myWebView.getSettings();
        myWebView.setWebViewClient(new WebViewClient()


        {   @Override
            public boolean shouldOverrideUrlLoading (WebView view, WebResourceRequest request) {
                return false; }});

        ProgressBar progressBar = myView.findViewById(R.id.progressBar);
        myWebView.setWebViewClient(new WebViewClient() {
            public void onPageFinished(WebView view, String url) {
                progressBar.setVisibility(View.GONE);
            }
        });




        SwipeRefreshLayout swipeRefreshLayout = myView.findViewById(R.id.swiperefresh);

        String url = myWebView.getUrl();
        swipeRefreshLayout.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh () {
                        myWebView.loadUrl(url);
                        myWebView.setWebViewClient(new WebViewClient() {
                            public void onPageFinished(WebView view, String url) {
                                swipeRefreshLayout.setRefreshing(false);
                            }
                        });
                    }
                }
        );



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
        return myView;
    }
}