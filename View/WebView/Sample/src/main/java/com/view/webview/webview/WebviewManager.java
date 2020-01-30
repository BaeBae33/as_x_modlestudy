package com.view.webview.webview;

import android.content.Context;
import android.os.Build;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class WebviewManager {
    private WebviewManager() {
    }


    public static void decorateSetting(Context context, WebView webView) {
        WebSettings settings = webView.getSettings();

        // 5.0以上开启混合模式加载
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            settings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }

        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);

        // 设置WebView是否允许执行JavaScript脚本，默认【false-不允许】
        settings.setJavaScriptEnabled(true);

        // 如果启用了JavaScript，务必做好安全措施，防止远程执行漏洞
        // 参考：https://blog.csdn.net/self_study/article/details/55046348
        removeJavascriptInterfaces(webView);

        // DOM存储API是否可用，默认false。 -->  SessionStorage/LocalStorage存储
        settings.setDomStorageEnabled(true);

        // 使用内置的缩放机制时是否展示缩放控件，默认值true
        settings.setDisplayZoomControls(false);

        // 是否使用内置的缩放机制。
        settings.setBuiltInZoomControls(false);

        // 禁用文字缩放
        settings.setTextZoom(100);

        // 10M缓存，api 18后，系统自动管理。
        settings.setAppCacheMaxSize(10 * 1024 * 1024);

        // 应用缓存API是否可用，默认值false
        settings.setAppCacheEnabled(true);

        // 设置缓存位置
        settings.setAppCachePath(context.getDir("appcache", 0).getPath());

        // 允许WebView使用File协议
        settings.setAllowFileAccess(true);

        //不保存密码
        settings.setSavePassword(false);

        // 设置UA
        settings.setUserAgentString(settings.getUserAgentString() + " kjtApp/" + "1.0.0");

        // 移除部分系统JavaScript接口
        // KaolaWebViewSecurity.removeJavascriptInterfaces(webView);

        /*WebView是否下载图片资源，默认为true。注意，该方法控制所有图片的下载，包括使用URI嵌入的图片（使用setBlockNetworkImage(boolean) 只控制使用网络URI的图片的下载）*/
        if (Build.VERSION.SDK_INT >= 19) {
            settings.setLoadsImagesAutomatically(true);
            settings.setMediaPlaybackRequiresUserGesture(true);
            WebView.setWebContentsDebuggingEnabled(true);
            /*是否允许运行在一个URL环境（the context of a file scheme URL）中的JavaScript访问来自其他URL环境的内容*/
            settings.setAllowFileAccessFromFileURLs(true);
            /*是否允许运行在一个file schema URL环境下的JavaScript访问来自其他任何来源的内容*/
            settings.setAllowUniversalAccessFromFileURLs(true);
        } else {
            settings.setLoadsImagesAutomatically(false);
        }


        settings.setAllowContentAccess(true);

        /*是否禁止从网络下载数据，如果app有INTERNET权限，默认值为false，否则默认为true。*/
        settings.setBlockNetworkLoads(false);

        /*重写使用缓存的方式，默认值LOAD_DEFAULT。 LOAD_DEFAULT, LOAD_CACHE_ELSE_NETWORK, LOAD_NO_CACHE or LOAD_CACHE_ONLY*/
        settings.setCacheMode(WebSettings.LOAD_DEFAULT);
        /*数据库存储API是否可用，默认值false。*/
        settings.setDatabaseEnabled(true);

        /*定位是否可用，默认为true。(1) app必须有定位的权限 (2) 提供onGeolocationPermissionsShowPrompt(String, GeolocationPermissions.Callback)回调方法*/
        settings.setGeolocationEnabled(true);
        /*让JavaScript自动打开窗口，默认false。适用于JavaScript方法window.open()。*/
        settings.setJavaScriptCanOpenWindowsAutomatically(true);

        /*设置默认编码*/
        settings.setDefaultTextEncodingName("utf-8");
    }

    private static void removeJavascriptInterfaces(WebView webView) {
        try {
            if (Build.VERSION.SDK_INT >= 11 && Build.VERSION.SDK_INT < 17) {
                webView.removeJavascriptInterface("searchBoxJavaBridge_");
                webView.removeJavascriptInterface("accessibility");
                webView.removeJavascriptInterface("accessibilityTraversal");
            }
        } catch (Throwable tr) {
            tr.printStackTrace();
        }
    }

}
