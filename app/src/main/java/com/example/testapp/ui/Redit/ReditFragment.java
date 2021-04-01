package com.example.testapp.ui.Redit;

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
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.testapp.R;

public class ReditFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View myView = inflater.inflate(R.layout.fragment_redit, container, false);

        WebView myWebView = myView.findViewById(R.id.webView_yt);
        myWebView.loadUrl("https://www.reddit.com/");
        WebSettings webSettings = myWebView.getSettings();
        myWebView.setWebViewClient(new WebViewClient()
        {            @Override
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

        webSettings.setJavaScriptEnabled(true);

        myWebView.setOnKeyListener(new View.OnKeyListener()
        {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event)
            {
                if(event.getAction() == KeyEvent.ACTION_DOWN)
                {
                    WebView webView = (WebView) v;

                    switch(keyCode)
                    {
                        case KeyEvent.KEYCODE_BACK:
                            if(webView.canGoBack())
                            {
                                webView.goBack();
                                return true;
                            }
                            break;
                    }
                }
                return false;}
        });

        return myView;
    }
}