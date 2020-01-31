package com.kgisl.brokermvc;

public class App{
    public static void main(String[] args) {
        TradeDaoImpl t = new TradeDaoImpl();
        t.loadTradeInfoFromFile("resources/tradefile-1.csv");
        BrokerageDaoImpl b = new BrokerageDaoImpl();
        b.processTrades(t.getallTrades());
        b.printAllContracts();
    }
}