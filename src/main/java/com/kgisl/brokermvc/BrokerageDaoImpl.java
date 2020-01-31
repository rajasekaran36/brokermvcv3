package com.kgisl.brokermvc;

import java.util.ArrayList;
import java.util.List;

public class BrokerageDaoImpl {
    private List<Brokerage> brokerages=new ArrayList<Brokerage>();

    public void processTrades(List<Trade> trades){
        trades.forEach(trade->{
            brokerages.add(new Brokerage(trade.getId(),trade.getUccCode(),trade.getDateAndTime(),trade.getScrip(),trade.getTradeType(),trade.getQty(),trade.getRate()));
        });
        brokerages.forEach(
            brokerage->{

                brokerage.setAmount(brokerage.getPrice()*brokerage.getQuantity());
                brokerage.setBrokerage((brokerage.getAmount()/100)*0.35);
                brokerage.setSt((brokerage.getAmount()/100)*0.017);
                
                Trade aTrade = TradeUtils.getTrade(brokerage.getId());
                if(aTrade.getStType().equals("E")&&aTrade.getGstType().equals("E")){
                    
                    brokerage.setGst((brokerage.getBrokerage()*18)/100);
                    
                }
                else if(aTrade.getStType().equals("E")&&aTrade.getGstType().equals("I")){
                    
                    brokerage.setGst((brokerage.getBrokerage()*18)/118);
                   
                }
                else if(aTrade.getStType().equals("I")&&aTrade.getGstType().equals("E")){
                    
                    brokerage.setGst(((brokerage.getBrokerage()-brokerage.getSt())*18)/100);
                    
                }
                else if(aTrade.getStType().equals("I")&&aTrade.getGstType().equals("I")){
                    
                    brokerage.setGst(((brokerage.getBrokerage()-brokerage.getSt())*18)/118);
                    
                }
                
                brokerage.setStampDuty((brokerage.getAmount()/100)*0.005);
                brokerage.setTransactionCharge((brokerage.getAmount()/100)*0.00325);
                brokerage.setSebiCharges((brokerage.getAmount()/100)*0.002);
                if(aTrade.getTradeType().equals("B"))
                    brokerage.setNetamount(brokerage.getAmount()+(brokerage.getBrokerage()+brokerage.getGst()+brokerage.getSt()+brokerage.getStampDuty()+brokerage.getTransactionCharge()+brokerage.getSebiCharges()));
                else if(aTrade.getTradeType().equals("S"))
                    brokerage.setNetamount(brokerage.getAmount()-(brokerage.getBrokerage()+brokerage.getGst()+brokerage.getSt()+brokerage.getStampDuty()+brokerage.getTransactionCharge()+brokerage.getSebiCharges()));
            }
        );
    }
    public void displayBrokerages(){
        brokerages.forEach(brokerage->System.out.println(brokerage.toString()));
    }
    public void printContract(Integer id){
       
        System.out.println("*******************************************************");
        System.out.println("------------------- XYZ Broking----------------------- ");
        System.out.println("*******************************************************");
        for(Brokerage brokerage:brokerages){
            if(brokerage.getId()==id){
                System.out.println("ID                     :   "+brokerage.getId());
                System.out.println("UCCCODE                :   "+brokerage.getUccCode());
                System.out.println("DATE&TIME              :   "+brokerage.getTradeDateAndTime());
                System.out.println("SCRIP                  :   "+brokerage.getScrip());
                System.out.println("TRADE TYPE             :   "+brokerage.getTradeType());
                System.out.println("QUANTITY               :   "+brokerage.getQuantity());
                System.out.println("PRICE                  :   Rs."+brokerage.getPrice());
                System.out.println("MARKET AMOUNT          :   Rs."+brokerage.getAmount());
                System.out.println("BROKERAGE AMOUNT       :   Rs."+brokerage.getBrokerage());
                System.out.println("GST                    :   Rs."+brokerage.getGst());
                System.out.println("STT                    :   Rs."+brokerage.getSt());
                System.out.println("STAMP DUTY             :   Rs."+brokerage.getStampDuty());
                System.out.println("TRANSACTION CHARGES    :   Rs."+brokerage.getTransactionCharge());
                System.out.println("SEBI CHARGES           :   Rs."+brokerage.getSebiCharges());
                System.out.println("NET AMOUNT             :   Rs."+brokerage.getNetamount());
            }
        }

        System.out.println("*******************************************************");
    }
}