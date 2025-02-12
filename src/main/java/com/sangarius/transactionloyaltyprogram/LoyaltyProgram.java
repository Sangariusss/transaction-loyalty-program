package com.sangarius.transactionloyaltyprogram;

import com.sangarius.transactionloyaltyprogram.model.UserAccount;
import com.sangarius.transactionloyaltyprogram.service.TransactionService;
import com.sangarius.transactionloyaltyprogram.service.TransactionHistory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoyaltyProgram {

    private static final Logger logger = LogManager.getLogger(LoyaltyProgram.class);

    public static void main(String[] args) {
        UserAccount user = new UserAccount(1, "Olexiy", 100);
        TransactionService service = new TransactionService();

        service.earnPoints(user, 50);
        service.spendPoints(user, 80);

        try {
            service.spendPoints(user, 100);
        } catch (Exception e) {
            logger.error("Error: Not enough bonus points. User balance: {} points", service.checkBalance(user), e);
        }

        logger.info("Balance: {} points", service.checkBalance(user));
        TransactionHistory.printHistory();
    }
}
