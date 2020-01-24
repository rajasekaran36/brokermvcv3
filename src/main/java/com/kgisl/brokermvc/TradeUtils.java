package com.kgisl.brokermvc;

import java.util.List;
import java.util.stream.Stream;

public class TradeUtils{
    
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

    public static Boolean isHaveDiffrentRate(List<Trade> list){
        Stream.Builder<Trade> sb = Stream.builder();
        if(sb.build().map(Trade::getRate).distinct().count()>1)
            return true;
        else
            return false;
    }

}