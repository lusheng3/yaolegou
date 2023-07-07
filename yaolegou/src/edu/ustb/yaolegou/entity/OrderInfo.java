package edu.ustb.yaolegou.entity;

import java.util.List;

public class OrderInfo {
    private int id;
    private String dingdanNumber;
    private String zhuRenUser;
    private double price;
    private int stateId;
    private String createTime;
    private String userName;
    private int zhifuId;
    private int addressId;
    private OrderState orderState;
    private PayType payType;
    private SHAddress shAddress;
    private List<OrderItem> itemList;
    private ShopInfo si;
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDingdanNumber() {
        return dingdanNumber;
    }

    public void setDingdanNumber(String dingdanNumber) {
        this.dingdanNumber = dingdanNumber;
    }

    public String getZhuRenUser() {
        return zhuRenUser;
    }

    public void setZhuRenUser(String zhuRenUser) {
        this.zhuRenUser = zhuRenUser;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStateId() {
        return stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getZhifuId() {
        return zhifuId;
    }

    public void setZhifuId(int zhifId) {
        this.zhifuId = zhifId;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public OrderState getOrderState() {
        return orderState;
    }

    public void setOrderState(OrderState orderState) {
        this.orderState = orderState;
    }

    public PayType getPayType() {
        return payType;
    }

    public void setPayType(PayType payType) {
        this.payType = payType;
    }

    public SHAddress getShAddress() {
        return shAddress;
    }

    public void setShAddress(SHAddress shAddress) {
        this.shAddress = shAddress;
    }

    public List<OrderItem> getItemList() {
        return itemList;
    }

    public void setItemList(List<OrderItem> itemList) {
        this.itemList = itemList;
    }

    public ShopInfo getSi() {
        return si;
    }

    public void setSi(ShopInfo si) {
        this.si = si;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
