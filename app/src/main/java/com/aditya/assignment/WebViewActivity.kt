package com.aditya.assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.webkit.WebView
import android.webkit.WebViewClient
import com.aditya.assignment.databinding.ActivityWebViewBinding

class WebViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWebViewBinding
    private lateinit var webView : WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityWebViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Taking the Website Link from the user
        val websiteLink : String? = intent.getStringExtra("WebsiteLink")
        webView = binding.webView
        //This prevents WebView to open system default browser
        webView.webViewClient = WebViewClient()

        webView.settings.javaScriptEnabled = true

        //Loading Website in the webview
        webView.loadUrl(websiteLink!!)
    }


    //Implementing custom menu for the webview activity
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.webview_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    //Forward and Backward Browsing Button Handler
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(item.itemId == R.id.forward) {
            if(webView.canGoForward()) {
                webView.goForward()
            }
        } else if(item.itemId == R.id.backward) {
            if(webView.canGoBack()) {
                webView.goBack()
            }
        }

        return super.onOptionsItemSelected(item)
    }
}