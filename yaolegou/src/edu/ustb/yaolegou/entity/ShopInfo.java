package edu.ustb.yaolegou.entity;

public class ShopInfo {
    private int shopId;
    private String shopName;
    private String color;
    private String shopMiaoShu;
    private double shopPrice;
    private String chiCun;
    private String zhuRenUser;
    private int shopTypeId;
    private String image;
    private String context;

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getShopMiaoShu() {
        return shopMiaoShu;
    }

    public void setShopMiaoShu(String shopMiaoShu) {
        this.shopMiaoShu = shopMiaoShu;
    }

    public double getShopPrice() {
        return shopPrice;
    }

    public void setShopPrice(double shopPrice) {
        this.shopPrice = shopPrice;
    }

    public String getChiCun() {
        return chiCun;
    }

    public void setChiCun(String chiCun) {
        this.chiCun = chiCun;
    }

    public String getZhuRenUser() {
        return zhuRenUser;
    }

    public void setZhuRenUser(String zhuRenUser) {
        this.zhuRenUser = zhuRenUser;
    }

    public int getShopTypeId() {
        return shopTypeId;
    }

    public void setShopTypeId(int shopTypeId) {
        this.shopTypeId = shopTypeId;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "\nShopInfo{" +
                "shopId=" + shopId +
                ", shopName='" + shopName + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
