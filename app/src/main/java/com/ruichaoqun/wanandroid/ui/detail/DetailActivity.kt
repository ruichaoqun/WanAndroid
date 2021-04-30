package com.ruichaoqun.wanandroid.ui.detail

import android.annotation.SuppressLint
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.JavascriptInterface
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import com.ruichaoqun.wanandroid.MainActivity
import com.ruichaoqun.wanandroid.R

class DetailActivity : AppCompatActivity() {
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val webview = findViewById<WebView>(R.id.web_view)
        initWebview(webview)
    }

    @SuppressLint("JavascriptInterface", "SetJavaScriptEnabled")
    @JavascriptInterface
    private fun initWebview(webview:WebView) {
        webview.addJavascriptInterface(JSInterface(), "imagelistner")
        webview.settings.javaScriptEnabled = true
        webview.webViewClient = object : WebViewClient() {
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                webview.settings.blockNetworkImage = true
                Log.w("onPageFinished","onPageStarted")
            }

            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
            ): Boolean {
                view?.loadUrl(request?.url.toString())
                return true
            }

            override fun onPageFinished(view: WebView, url: String) {
                super.onPageFinished(view, url)
                webview.settings.blockNetworkImage = false
                Log.w("onPageFinished","onPageFinished")
                webview.loadUrl("""javascript:(function(){
                        var imgs = document.getElementsByTagName('img');
                        var srcList = "";
                        var length=imgs.length;
                        for(let i=0; i < length;i++){
                          img=imgs[i];
                          srcList = srcList + "," + img.src;
                        }
                        for(let i=0; i < length;i++){
                          img=imgs[i];
                          img.onclick=function(){
                             window.imagelistner.openImage(srcList,i)
                          }
                        }
                      })()"""
//                    "javascript:(function(){"
//                            + "var objs = document.getElementsByTagName(\"img\"); "
//                            + "for(var i=0;i<objs.length;i++)  " + "{"
//                            + "    objs[i].οnclick=function()  " + "    {  "
//                            + "        imagelistner.openImage(this.getAttribute(\"src\"));  "
//                            + "    }  " + "}" + "})()"
                )
            }
        }
        webview.loadUrl("file:android_asset/test.html")
    }

    class JSInterface{
        @JavascriptInterface
        fun openImage(urls:String,index:Int){
            Log.w("onPageFinished","${urls}  $index   register")
        }
    }
}