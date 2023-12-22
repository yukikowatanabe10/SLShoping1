package com.slshop.common.entity.order;

public enum PaymentMethod {

    COD("代引き"),
    CREDIT_CARD("クレジットカード");

    private String jpText;

    private PaymentMethod(String jpText) {
        this.jpText = jpText;
    }

    public String getJpText() {
        return jpText;
    }
    
    
}
