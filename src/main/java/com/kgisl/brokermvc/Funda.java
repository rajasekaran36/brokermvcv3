package com.kgisl.brokermvc;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Funda {

    public static void main(String[] args) {
        BinaryOperator bi = new BinaryOperator<Integer>() {

            @Override
            public Integer apply(Integer t, Integer u) {
                return t+u;
            }
        };
        BiFunction bifun = new BiFunction<Integer,Integer,Integer>() {

            @Override
            public Integer apply(Integer t, Integer u) {
                return t+u;
            }

        };
        Consumer co = System.out::println;
        Integer[] a = {2,3,4,6};
        Stream<Integer> ins = Stream.of(a);
        Stream<Integer> ins2 = Stream.of(a);
        List<Integer> c = ins2.map(x->x+10).collect(Collectors.toList());
        //c.forEach(co);
        ins.findFirst().ifPresent(co);


    }
}