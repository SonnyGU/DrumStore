package com.example.demo.domain;

public class ProductMessages {
    private String text;
    private int productId;
    private boolean ifSuccessful = true;



    public ProductMessages(String text, int id, boolean ifSuccessful) {
        this.text = text;
        this.productId = id;
        this.ifSuccessful = ifSuccessful;
    }

    public boolean isIfSuccessful() {
        return ifSuccessful;
    }

    public void setIfSuccessful(boolean ifSuccessful) {
        this.ifSuccessful = ifSuccessful;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
