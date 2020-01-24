package com.kgisl.brokermvc;

public class Trade{
    String customerId;
    String symbol;
    Integer qty;
    Double rate;
    String date;
    Boolean sttEx;
    Boolean gstEx;
    public Trade(){}
    public Trade(String customerId, String symbol, Integer qty, Double rate, String date, Boolean sttEx, Boolean gstEx) {
        this.customerId = customerId;
        this.symbol = symbol;
        this.qty = qty;
        this.rate = rate;
        this.date = date;
        this.sttEx = sttEx;
        this.gstEx = gstEx;
    }

    public String getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Integer getQty() {
        return this.qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Double getRate() {
        return this.rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Boolean isSttEx() {
        return this.sttEx;
    }

    public Boolean getSttEx() {
        return this.sttEx;
    }

    public void setSttEx(Boolean sttEx) {
        this.sttEx = sttEx;
    }

    public Boolean isGstEx() {
        return this.gstEx;
    }

    public Boolean getGstEx() {
        return this.gstEx;
    }

    public void setGstEx(Boolean gstEx) {
        this.gstEx = gstEx;
    }

    @Override
    public String toString() {
        return "{" +
            " customerId='" + getCustomerId() + "'" +
            ", symbol='" + getSymbol() + "'" +
            ", qty='" + getQty() + "'" +
            ", rate='" + getRate() + "'" +
            ", date='" + getDate() + "'" +
            ", sttEx='" + isSttEx() + "'" +
            ", gstEx='" + isGstEx() + "'" +
            "}";
    }


}