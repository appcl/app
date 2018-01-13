package com.mt.cardletter.entity.bank;

import android.graphics.drawable.Drawable;

/**
 * Date:2018/1/13
 * Time:16:20
 * author:demons
 */

public class BankEntity {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Drawable getPic() {
        return pic;
    }

    public void setPic(Drawable pic) {
        this.pic = pic;
    }

    private String name;
    private Drawable pic;
}
