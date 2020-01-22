package com.kgisl.brokermvc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class TradeDaoImpl implements TradeDao {

    List<Trade> trades;

    public TradeDaoImpl() {
        trades = new ArrayList<Trade>();
    }

    public List<Trade> getallTrades() {

        return trades;
    }

    public List<Trade> getTradesByCustomerId(String customerID) {
        List<Trade> customerSpecificTrades = new ArrayList<Trade>();
        
        getallTrades().forEach((trade)->{
            if(trade.getCustomerId().equals(customerID))
            customerSpecificTrades.add(trade);
        });
        
        return customerSpecificTrades;
    }

    public List<Trade> getTradesBySymbol(String symbol) {
        List<Trade> symbolSpecificTrades = new ArrayList<Trade>();
        
        getallTrades().forEach((trade)->{
            if(trade.getSymbol().equals(symbol))
                symbolSpecificTrades.add(trade);
        });

        return symbolSpecificTrades;
    }

    public Boolean updateTradeInfo(Trade aTrade) {

        return null;
    }

    public Boolean deleteTradeInfo(Trade aTrade) {

        return null;
    }

    public Boolean loadTradeInfoFromFile(String filePath) {
        File tradeFile = new File(filePath);
        try {
            Scanner fileReader = new Scanner(tradeFile);
            fileReader.nextLine();
            while (fileReader.hasNextLine()) {
                String curTradeString = fileReader.nextLine();
                String[] tradeInfo = curTradeString.split(",");
                String customerId = tradeInfo[0];
                String symbol = tradeInfo[1];
                Integer qty = Integer.parseInt(tradeInfo[2]);
                Double rate = Double.parseDouble(tradeInfo[3]);
                String date = tradeInfo[4];
                Boolean sttEx = tradeInfo[5].equals("E")?true:false;
                Boolean gstEx =tradeInfo[6].equals("E")?true:false;
                this.trades.add(new Trade(customerId, symbol, qty, rate, date, sttEx, gstEx));
            }
            fileReader.close();
        } catch (FileNotFoundException fnf) {
            System.out.println("Cannot Find Trade File");
        }
        return true;
    }

    public List<Trade> getTrades(String customerID, String symbol){
        List<Trade> tradesSpeficToCustomerAndSymBol = new ArrayList<Trade>();
        trades.forEach((Trade t)->{
            if(t.getCustomerId().equals(customerID)&&t.getSymbol().equals(symbol))
                tradesSpeficToCustomerAndSymBol.add(t);
        });
        return tradesSpeficToCustomerAndSymBol;
    }

    public HashMap<String, List<Trade>> getTradeGroups(List<Trade> customerTrades) {;
        HashMap<String, List<Trade>> map = new HashMap<String,List<Trade>>();
        customerTrades.forEach((Trade trade)->map.put(trade.getSymbol(),null));
        map.forEach((key,trades)->{map.put(key,getTrades(customerTrades.get(0).getCustomerId(),key));});
        return map;
    }

}