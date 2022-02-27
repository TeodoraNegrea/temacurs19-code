package ro.fasttrackit.temacurs19.service;

import org.springframework.stereotype.Component;
import ro.fasttrackit.temacurs19.model.Transaction;

import java.util.List;

@Component
public class MemoryTransactionProvider implements TransactionProvider {

    public List<Transaction> getAllTransaction() {
        return List.of(new Transaction(1, "cosmetics", "BUY", 200.50),
                new Transaction(2, "electronics", "SELL", 1500.00),
                new Transaction(3, "food", "BUY", 255.50),
                new Transaction(4, "wardrobe", "SELL", 850.80),
                new Transaction(5, "shoes", "SELL", 100.50));

    }
}
