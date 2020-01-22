package com.kgisl.brokermvc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.HashMap;

public class Test{
    public static void main(String[] args) throws IOException{

        TradeDao td = new TradeDaoImpl();
        td.loadTradeInfoFromFile("resources/tradefile-1.csv");
        //List<String> s = Files.lines(Paths.get("resources/tradefile-1.csv")).map(String::toLowerCase).filter(t->t.charAt(0)=='S').collect(Collectors.toList());
        Trade[] ss = td.getallTrades().toArray(new Trade[td.getallTrades().size()]);
        Trade[] cusp = Stream.of(ss).filter(t->t.getCustomerId().equals("CITIBNPPARIA")).toArray(Trade[]::new);
        //System.out.println(ss.length+" "+cusp.length);
        Stream.of(cusp).forEach(t->System.out.println(t.toString()));
        //s.forEach(System.out::println);
    }
}