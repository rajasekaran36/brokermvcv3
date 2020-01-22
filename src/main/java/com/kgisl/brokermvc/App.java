package com.kgisl.brokermvc;

import java.util.HashMap;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void displayTrades(List<Trade> trades){
        for(Trade x:trades){
            System.out.println(x.toString());
        }
    }
    public static void main( String[] args )
    {
        TradeDao td = new TradeDaoImpl();
        td.loadTradeInfoFromFile("resources/tradefile-1.csv");
        //CITIBNPPARIA
        HashMap<String,List<Trade>> groups = td.getTradeGroups(td.getTradesByCustomerId("CITIBNPPARIA"));

        for(String key:groups.keySet()){
            displayTrades(groups.get(key));
        }
    }
}
