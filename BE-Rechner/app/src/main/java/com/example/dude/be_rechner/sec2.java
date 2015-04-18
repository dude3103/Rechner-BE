package com.example.dude.be_rechner;



import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;


public class sec2 extends Activity {


    WebView mWeb;
    ProgressDialog mProgress;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // no need to use title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // set webview as main content only
        mWeb = new WebView(this);
        setContentView(mWeb);
        // set Javascript
        WebSettings settings = mWeb.getSettings();
        settings.setJavaScriptEnabled(true);
        // the init state of progress dialog
        mWeb.getSettings().setBuiltInZoomControls(true);
        mWeb.getSettings().setDisplayZoomControls(false);
        mProgress = ProgressDialog.show(this, "Lade", "Einen kleinen Moment Bitte...");

        // add a WebViewClient for WebView, which actually handles loading data from web
        mWeb.setWebViewClient(new WebViewClient() {
            // load url
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            // when finish loading page
            public void onPageFinished(WebView view, String url) {
                if (mProgress.isShowing()) {
                    mProgress.dismiss();
                }
            }
        });
        // set url for webview to load
        mWeb.loadUrl("http://szene38.de");
    }
}
