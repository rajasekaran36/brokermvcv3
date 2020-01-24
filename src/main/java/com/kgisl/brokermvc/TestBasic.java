package com.kgisl.brokermvc;

import java.util.Comparator;
import java.util.stream.Stream;

public class TestBasic{
    public static void main(String[] args) {
        Integer[] nums = {3,4,5,6,2};
        Comparator intComparator = Comparator.comparing(Integer::intValue);
        Integer minVal = (Integer)Stream.of(nums).min(intComparator).get();
        System.out.println(minVal);

    }
}