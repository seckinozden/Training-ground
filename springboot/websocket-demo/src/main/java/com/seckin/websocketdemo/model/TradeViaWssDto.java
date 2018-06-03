package com.seckin.websocketdemo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TradeViaWssDto {

    @JsonProperty("s")
    private String quantity;
    @JsonProperty("p")
    private String price;

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "TradeViaWssDto{" +
                "quantity='" + quantity + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
