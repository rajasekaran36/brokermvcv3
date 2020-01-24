package com.kgisl.brokermvc;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    public static Stream<Trade> tradesToStream(List<Trade> list){
        Stream.Builder<Trade> sb = Stream.builder();
        list.forEach(t->sb.add(t));
        return sb.build();
    }
    public static void main( String[] args )
    {
        TradeDao td = new TradeDaoImpl();
        td.loadTradeInfoFromFile("resources/tradefile-1.csv");

        List<Trade> trades = td.getallTrades();
        Consumer pcon = System.out::println;

        /* Stream.Builder<String> sb = Stream.builder();
        trades.forEach(t->sb.add(t.getCustomerId()));
        Stream<String> cusids = sb.build(); */

        Stream<Trade> allTradesStream = tradesToStream(td.getallTrades());
        String customerId="CITIBNPPARIA";
        Stream<Trade> customerTrades = allTradesStream.filter(t->t.getCustomerId().equals(customerId)).collect(Collectors.toList()).stream();
        
        Supplier<Stream<Trade>> tradeSupplier = ()->customerTrades;
        
        String[] symbols = tradeSupplier.get().map(Trade::getSymbol).distinct().toArray(String[]::new);
        
        Stream.of(symbols).forEach(pcon);
        String trsym = symbols[0];
        
        Stream<Trade> cusSymbol = tradeSupplier.get().filter(s->s.getSymbol().equals(trsym));

        displayTrades(cusSymbol.collect(Collectors.toList()));
                
        if(TradeUtils.isHaveDiffrentRate(cusSymbol.collect(Collectors.toList()))){
            System.out.println("Weigted Rate");
        }
        else{
            System.out.println("Flate Rate");   
        } 


        //trs.map(Trade::getSymbol)
        //List<String> dss = cusids.distinct().collect(Collectors.toList());
        
        /* //CITIBNPPARIA
        HashMap<String,List<Trade>> groups = td.getTradeGroups(td.getTradesByCustomerId("CITIBNPPARIA"));

        groups.forEach((key,trades)->{displayTrades(trades);});

        /* for(String key:groups.keySet()){
            displayTrades(groups.get(key));
        } */
    }
}
