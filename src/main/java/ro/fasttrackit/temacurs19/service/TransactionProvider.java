package ro.fasttrackit.temacurs19.service;

import ro.fasttrackit.temacurs19.model.Transaction;

import java.util.List;

public interface TransactionProvider {
    List<Transaction> getAllTransaction();
}
