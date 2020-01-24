package com.kgisl.brokermvc;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestBasic{
    public static LocalDateTime convertToLocalDateTime(String data){
        String[] raw =data.split(" ");
        String[] date = raw[0].split("/");
        String[] time = raw[1].split(":");
        for(int i=0;i<2;i++)
            if(date[i].length()<2)
                date[i]="0"+date[i];
        
        Integer[] datei = Stream.of(date).map(Integer::parseInt).toArray(Integer[]::new);
        Integer[] timei = Stream.of(time).map(Integer::parseInt).toArray(Integer[]::new);
        
        return LocalDateTime.of(datei[2],datei[0],datei[1], timei[0], timei[1]);
    }
    public static void main(String[] args) {
        System.out.println(convertToLocalDateTime("2/27/2015 9:30"));
    }
}