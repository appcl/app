package com.mt.cardletter.view.exchange;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.mt.cardletter.R;

/**
 * Date:2018/3/13
 * Time:10:25
 * author:demons
 */

public class ShopInfoContainer extends RelativeLayout {

    public TextView shop_name, shop_sum, shop_type, shop_send;
    private ImageView shop_arrow, iv_pin;
    public SimpleDraweeView iv_shop;

    public ShopInfoContainer(Context context) {
        super(context);
    }

    public ShopInfoContainer(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        inflate(context, R.layout.view_shopinfo, this);
        shop_name = (TextView) findViewById(R.id.tv_shop_name);
        shop_arrow = (ImageView) findViewById(R.id.tv_shop_arrow);
        iv_pin = (ImageView) findViewById(R.id.iv_pin);
        shop_sum = (TextView) findViewById(R.id.tv_shop_summary);
        shop_type = (TextView) findViewById(R.id.tv_shop_type);
        shop_send = (TextView) findViewById(R.id.tv_shop_send);
        ViewUtils.getBlurFresco(context, (SimpleDraweeView) findViewById(R.id.iv_shop_bg), "res:///" + R.drawable.icon_shop);
        iv_shop = (SimpleDraweeView) findViewById(R.id.iv_shop);
        ViewUtils.getFrescoController(context, iv_shop, "res:///" + R.drawable.icon_shops, 100, 100);
    }

    public ShopInfoContainer(Context context, AttributeSet attrs, int defStyle){
        super(context,attrs,defStyle);
    }

    public void setWgAlpha(float alpha) {
        shop_sum.setAlpha(alpha);
        shop_arrow.setAlpha(alpha);
        shop_sum.setAlpha(alpha);
        shop_type.setAlpha(alpha);
        shop_send.setAlpha(alpha);
        iv_shop.setAlpha(alpha);
        iv_pin.setAlpha(alpha);
    }
}
