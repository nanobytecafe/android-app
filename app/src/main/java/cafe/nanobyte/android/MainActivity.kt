package cafe.nanobyte.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.webkit.WebView
import android.webkit.WebViewClient

class MainActivity : AppCompatActivity() {

    lateinit var myWebView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        myWebView = WebView(this)
        myWebView.webViewClient = WebViewClient()
        myWebView.settings.javaScriptEnabled = true

        setContentView(myWebView)

        myWebView.loadUrl( "https://nanobyte.cafe" )
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean{

        // check if the webview needs to handle the back button or not
        if( keyCode == KeyEvent.KEYCODE_BACK && myWebView.canGoBack()){

            myWebView.goBack()
            return true
        }

        return super.onKeyDown(keyCode, event)
    }
}