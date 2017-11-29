package com.example.student.test04;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    private EditText editUrl;
    private Button btnGo;
    private WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //

        editUrl = (EditText) findViewById(R.id.edit_url);
        btnGo = (Button) findViewById(R.id.btn_go);
        webView = (WebView) findViewById(R.id.webview);

        webView.setWebViewClient(new WebViewClient());

        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);

        webView.loadUrl("file:///android_res/raw/ladder.html");

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = editUrl.getText().toString();
                webView.loadUrl("http://"+url);
            }
        });
        }
    }