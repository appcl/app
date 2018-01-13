package com.mt.cardletter.https;

import android.content.Context;
import android.webkit.JavascriptInterface;

import com.mt.cardletter.utils.ToastUtils;

/**
 * Date:2018/1/12
 * Time:16:43
 * author:demons
 */

public class JavaScriptQQ {
    Context context ;
    public JavaScriptQQ(Context context){
        this.context=context;
    }
    @JavascriptInterface
    public void submitEvent(String name,String psd){
        ToastUtils.makeShortText("账号："+name+" 密码："+psd,this.context);
    }
}
