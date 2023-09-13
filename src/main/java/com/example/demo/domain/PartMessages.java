package com.example.demo.domain;

public class PartMessages {
    private String text;
    private int partId;
    private boolean ifSuccessful = true;

    public PartMessages(String text, int partId, boolean ifSuccessful) {
        this.text = text;
        this.partId = partId;
        this.ifSuccessful = ifSuccessful;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getPartId() {
        return partId;
    }

    public void setPartId(int partId) {
        this.partId = partId;
    }

    public boolean isIfSuccessful() {
        return ifSuccessful;
    }

    public void setIfSuccessful(boolean ifSuccessful) {
        this.ifSuccessful = ifSuccessful;
    }
}
