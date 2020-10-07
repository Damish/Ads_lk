package com.damishs.ads_lk.ui.home;

public class AdItem {

    private String imageUrl;
    private String publishedDate;
    private String adId;
    private String adName;
    private String sellerName;
    private String specialText;
    private String price;

    public AdItem(String imageUrl, String publishedDate, String adId, String adName, String sellerName, String specialText, String price) {
        this.imageUrl = imageUrl;
        this.publishedDate = publishedDate;
        this.adId = adId;
        this.adName = adName;
        this.sellerName = sellerName;
        this.specialText = specialText;
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public String getAdId() {
        return adId;
    }

    public String getAdName() {
        return adName;
    }

    public String getSellerName() {
        return sellerName;
    }

    public String getSpecialText() {
        return specialText;
    }

    public String getPrice() {
        return price;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public void setAdId(String adId) {
        this.adId = adId;
    }

    public void setAdName(String adName) {
        this.adName = adName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public void setSpecialText(String specialText) {
        this.specialText = specialText;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
