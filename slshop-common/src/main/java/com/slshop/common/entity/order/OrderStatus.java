package com.slshop.common.entity.order;

public enum OrderStatus {

    NEW("新規受付"),
    PAID("入金済"),
    PROCESSING("注文処理中"),
    CANCELLED("注文取消し"),
    PICKING("発送準備"),
    SHIPPING("配送中"),
    DELIVERED("配送済"),
    RETURN_REQUESTED("返品受付"),
    RETURNED("返品済"),
    REFUNDED("返金済み");

    private String jpText;

    private OrderStatus(String jpText) {
        this.jpText = jpText;
    }

    public String getJpText() {
        return jpText;
    }
}
