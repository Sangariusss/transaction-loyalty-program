package com.sangarius.transactionloyaltyprogram;

import com.sangarius.transactionloyaltyprogram.model.UserAccount;
import com.sangarius.transactionloyaltyprogram.service.TransactionService;
import com.sangarius.transactionloyaltyprogram.exceptions.InsufficientPointsException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TransactionServiceTest {

    @Test
    void testEarnPoints() {
        UserAccount user = new UserAccount(1, "Olexiy", 100);
        TransactionService service = new TransactionService();
        service.earnPoints(user, 50);
        assertEquals(150, user.getBonusPoints());
    }

    @Test
    void testSpendPointsSuccess() {
        UserAccount user = new UserAccount(1, "Olexiy", 100);
        TransactionService service = new TransactionService();
        service.spendPoints(user, 50);
        assertEquals(50, user.getBonusPoints());
    }

    @Test
    void testSpendPointsFail() {
        UserAccount user = new UserAccount(1, "Olexiy", 30);
        TransactionService service = new TransactionService();
        assertThrows(InsufficientPointsException.class, () -> service.spendPoints(user, 50));
    }
}
