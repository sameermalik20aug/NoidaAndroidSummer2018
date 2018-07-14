package com.example.shubhamgulati.browser;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText edittxt;
    Button btnsearch ;
    WebView webview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edittxt = findViewById(R.id.edittxt);
        btnsearch = findViewById(R.id.btnsearch);
        webview = findViewById(R.id.webview);
        Intent i = getIntent();
        final String uri = String.valueOf(i.getData());
        Log.e("MainActivity",uri);
        edittxt.setText(uri);

        btnsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String search = String.valueOf(edittxt.getText());
                //webview.loadUrl("https://www.google.co.in/search?q="+search+"&oq="+search+"&aqs=chrome..69i57j69i61j69i60l2j0l2.994j0j7&sourceid=chrome&ie=UTF-8");
                webview.loadUrl(search);
                webview.setWebViewClient(new WebViewClient());
                WebSettings webSettings = webview.getSettings();
                webSettings.setJavaScriptEnabled(true);
                
            }
        });
    }
}
