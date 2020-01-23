package com.kgisl.brokermvc;

import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Stream;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;


public class Test{
    public static void main(String[] args) throws IOException, CsvValidationException{

        TradeDao td = new TradeDaoImpl();
        td.loadTradeInfoFromFile("resources/tradefile-1.csv");
        //List<String> s = Files.lines(Paths.get("resources/tradefile-1.csv")).map(String::toLowerCase).filter(t->t.charAt(0)=='S').collect(Collectors.toList());
        Trade[] ss = td.getallTrades().toArray(new Trade[td.getallTrades().size()]);
        Trade[] cusp = Stream.of(ss).filter(t->t.getCustomerId().equals("CITIBNPPARIA")).toArray(Trade[]::new);
        //System.out.println(ss.length+" "+cusp.length);
        Stream.of(cusp).forEach(t->System.out.println(t.toString()));
        //s.forEach(System.out::println);
        CSVReader cr = new CSVReader(new FileReader("resources/tradefile-1.csv"));
        String[] words = null;
        while((words=cr.readNext())!=null){
            Stream.of(words).forEach(System.out::println);
        }
        cr.close();
    }
}