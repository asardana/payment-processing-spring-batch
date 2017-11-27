package com.payments.processing.batch;

import org.springframework.batch.item.ItemProcessor;

/**
 * Created by Aman on 11/19/2017.
 */
public class TransactionProcessor implements ItemProcessor<Transaction, Transaction> {
    @Override
    public Transaction process(Transaction item) throws Exception {

        System.out.println("\n" + "Inside Processer ---> " + item.getTransactionId() );
        if ("1001".equalsIgnoreCase(item.getMerchantId())) {
            item.setMerchantName("Amazon");
        } else if ("1002".equalsIgnoreCase(item.getMerchantId())) {
            item.setMerchantName("Walmart");
        } else {
            item.setMerchantName("Not Available");
        }
       /* if("9".equalsIgnoreCase(item.getTransactionId())) {
            System.out.println("Runtime Exception for Item ---> " + item.getTransactionId());
            throw new RuntimeException();
        }*/
        //System.out.println("Enriched Trasaction Details --> " + item.toString());
        return item;
    }
}
