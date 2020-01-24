package com.kgisl.brokermvc;
public class Contract{
    String customerId;
    String symbol;
    Integer totalQty;
    Double rate;
    Double marketAmount;
    Double brokerageAmount;
    Double gstAmount;
    Double stampDutyAmount;
    Double securitiesTransactionTaxAmount;
    Double sebiFeeAmount;
    Double totalNetAmount;

    public Contract() {
    }


    public Contract(String customerId, String symbol, Integer totalQty, Double rate, Double marketAmount, Double brokerageAmount, Double gstAmount, Double stampDutyAmount, Double securitiesTransactionTaxAmount, Double sebiFeeAmount, Double totalNetAmount) {
        this.customerId = customerId;
        this.symbol = symbol;
        this.totalQty = totalQty;
        this.rate = rate;
        this.marketAmount = marketAmount;
        this.brokerageAmount = brokerageAmount;
        this.gstAmount = gstAmount;
        this.stampDutyAmount = stampDutyAmount;
        this.securitiesTransactionTaxAmount = securitiesTransactionTaxAmount;
        this.sebiFeeAmount = sebiFeeAmount;
        this.totalNetAmount = totalNetAmount;
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

    public Integer getTotalQty() {
        return this.totalQty;
    }

    public void setTotalQty(Integer totalQty) {
        this.totalQty = totalQty;
    }

    public Double getRate() {
        return this.rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Double getMarketAmount() {
        return this.marketAmount;
    }

    public void setMarketAmount(Double marketAmount) {
        this.marketAmount = marketAmount;
    }

    public Double getBrokerageAmount() {
        return this.brokerageAmount;
    }

    public void setBrokerageAmount(Double brokerageAmount) {
        this.brokerageAmount = brokerageAmount;
    }

    public Double getGstAmount() {
        return this.gstAmount;
    }

    public void setGstAmount(Double gstAmount) {
        this.gstAmount = gstAmount;
    }

    public Double getStampDutyAmount() {
        return this.stampDutyAmount;
    }

    public void setStampDutyAmount(Double stampDutyAmount) {
        this.stampDutyAmount = stampDutyAmount;
    }

    public Double getSecuritiesTransactionTaxAmount() {
        return this.securitiesTransactionTaxAmount;
    }

    public void setSecuritiesTransactionTaxAmount(Double securitiesTransactionTaxAmount) {
        this.securitiesTransactionTaxAmount = securitiesTransactionTaxAmount;
    }

    public Double getSebiFeeAmount() {
        return this.sebiFeeAmount;
    }

    public void setSebiFeeAmount(Double sebiFeeAmount) {
        this.sebiFeeAmount = sebiFeeAmount;
    }

    public Double getTotalNetAmount() {
        return this.totalNetAmount;
    }

    public void setTotalNetAmount(Double totalNetAmount) {
        this.totalNetAmount = totalNetAmount;
    }

    @Override
    public String toString() {
        return "{" +
            " customerId='" + getCustomerId() + "'" +
            ", symbol='" + getSymbol() + "'" +
            ", totalQty='" + getTotalQty() + "'" +
            ", rate='" + getRate() + "'" +
            ", marketAmount='" + getMarketAmount() + "'" +
            ", brokerageAmount='" + getBrokerageAmount() + "'" +
            ", gstAmount='" + getGstAmount() + "'" +
            ", stampDutyAmount='" + getStampDutyAmount() + "'" +
            ", securitiesTransactionTaxAmount='" + getSecuritiesTransactionTaxAmount() + "'" +
            ", sebiFeeAmount='" + getSebiFeeAmount() + "'" +
            ", totalNetAmount='" + getTotalNetAmount() + "'" +
            "}";
    }

}
