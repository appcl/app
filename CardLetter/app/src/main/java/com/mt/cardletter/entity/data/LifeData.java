package com.mt.cardletter.entity.data;

/**
 * Date:2017/12/19
 * Time:19:52
 * author:demons
 */

public class LifeData {

    public LifeData(String brf, String type, int imageId){
        this.brf= brf;
        this.type = type;
        this.imageId = imageId;
    }

    public String getBrf() {
        return brf;
    }

    public void setBrf(String brf) {
        this.brf = brf;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    private String brf;
    private String type;
    private int imageId;
}
