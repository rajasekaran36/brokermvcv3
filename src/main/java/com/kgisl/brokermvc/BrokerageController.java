package com.kgisl.brokermvc;

import java.util.ArrayList;
import java.util.List;

public class BrokerageController {
    private List<Brokerage> brokerages=new ArrayList<Brokerage>();

    public void processTrades(List<Trade> trades){
        trades.forEach(trade->{
            brokerages.add(new Brokerage(t.get))
        });
    }
}