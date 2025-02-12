package com.sangarius.transactionloyaltyprogram.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class TransactionHistory {

    private static final Logger logger = LogManager.getLogger(TransactionHistory.class);
    private static final List<String> transactionRecords = new ArrayList<>();

    private TransactionHistory() {
        // Private constructor to prevent instantiation
    }

    public static void addTransaction(String transactionRecord) {
        transactionRecords.add(transactionRecord);
    }

    public static void printHistory() {
        logger.info("\nTransaction history:");
        transactionRecords.forEach(logger::info);
    }
}
