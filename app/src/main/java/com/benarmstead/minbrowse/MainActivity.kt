package com.benarmstead.minbrowse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.CookieManager
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeUrl = "https://www.duckduckgo.com/?&t=ddg_android"

        val view = findViewById<WebView>(R.id.webView)
        view.webViewClient = WebViewClient()
        view.loadUrl(homeUrl)
        val settings = view.settings
        settings.javaScriptEnabled = true

        findViewById<Button>(R.id.homeButton).setOnClickListener{
            view.loadUrl(homeUrl)
        }

        findViewById<Button>(R.id.clearIdentity).setOnClickListener{
            CookieManager.getInstance().removeAllCookies(null)
            CookieManager.getInstance().flush()

            view.clearCache(true)
            view.clearHistory()

            view.loadUrl(homeUrl)
        }
    }
}