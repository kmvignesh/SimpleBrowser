package com.example.vicky.simplebrowser

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val context = this

        webview.webViewClient = MyWebViewClient()

        btnGo.setOnClickListener({
            webview.loadUrl("https://" + edtUrl.text.toString())
        })

        btnGoBack.setOnClickListener({
            if(webview.canGoBack()) {
                webview.goBack()
                edtUrl.setText(webview.url)
            }
            else
                Toast.makeText(context,"No History Available",Toast.LENGTH_SHORT).show()
        })
        btnGoForward.setOnClickListener({
            if(webview.canGoForward()) {
                webview.goForward()
                edtUrl.setText(webview.url)
            }
            else
                Toast.makeText(context,"No History Available",Toast.LENGTH_SHORT).show()
        })
    }

    @Suppress("OverridingDeprecatedMember")
    class MyWebViewClient : WebViewClient(){

        @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
        override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
            view?.loadUrl(request?.url.toString())
            return true
        }

        override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
            view?.loadUrl(url)
            return true
        }

    }

}
