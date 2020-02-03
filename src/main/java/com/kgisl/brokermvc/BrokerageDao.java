package com.kgisl.brokermvc;

import java.util.List;

public interface BrokerageDao{
    public void processTrades(List<Trade> trades);
    public void displayBrokerages();
    public void printContract(Integer id);
    public void printAllContracts();
}