package com.sangarius.transactionloyaltyprogram.service;

import com.sangarius.transactionloyaltyprogram.model.UserAccount;
import com.sangarius.transactionloyaltyprogram.exceptions.InsufficientPointsException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TransactionService {

    private static final Logger logger = LogManager.getLogger(TransactionService.class);

    public void earnPoints(UserAccount user, int points) {
        user.addPoints(points);
        TransactionHistory.addTransaction("+" + points + " points added for " + user.getName());
        logger.info("{} points added for user {}", points, user.getName());
    }

    public void spendPoints(UserAccount user, int points) {
        if (user.getBonusPoints() < points) {
            throw new InsufficientPointsException("Not enough bonus points!");
        }
        user.subtractPoints(points);
        TransactionHistory.addTransaction("-" + points + " points spent by " + user.getName());
        logger.info("{} points spent by user {}", points, user.getName());
    }

    public int checkBalance(UserAccount user) {
        return user.getBonusPoints();
    }
}
