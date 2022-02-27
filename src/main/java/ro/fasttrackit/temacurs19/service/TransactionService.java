package ro.fasttrackit.temacurs19.service;

import org.springframework.stereotype.Service;
import ro.fasttrackit.temacurs19.model.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class TransactionService {
    private final List<Transaction> transactions;

    public TransactionService(TransactionProvider memoryTransactionProvider) {
        this.transactions = new ArrayList<>(memoryTransactionProvider.getAllTransaction());
    }

    public List<Transaction> getAll() {
        return transactions;
    }

    /*public List<Transaction> getAllTransactions() {
       this.transactions.stream()
                .filter(transaction -> transaction.product())
                .collect(Collectors.toList());
       return getAllTransactions();
    }*/
    public Optional<Transaction> getById(int id) {
        return this.transactions.stream()
                .filter(transaction -> transaction.getId() == id)
                .findAny();
    }

    public Transaction add(Transaction transaction) {
        Transaction newTransaction = cloneWithId(this.transactions.size(), transaction);
        this.transactions.add(newTransaction);
        return newTransaction;
    }

    private Transaction cloneWithId(int id, Transaction transaction) {
        return new Transaction(id,
                transaction.getProduct(),
                transaction.getType(),
                transaction.getAmount()
        );
    }

    public Optional<Transaction> replace(int id, Transaction transaction) {
        return getById(id)
                .map(existing -> replaceExistingTransaction(id, existing, transaction));
    }

    private Transaction replaceExistingTransaction(int id, Transaction existing, Transaction transaction) {
        this.transactions.remove(existing);
        Transaction newTransaction = cloneWithId(id, transaction);
        this.transactions.add(id - 1, newTransaction);
        return newTransaction;
    }

    public Optional<Transaction> delete(int id) {
        Optional<Transaction> transactionToDelete = getById(id);
        transactionToDelete.ifPresent(this.transactions::remove);
        return transactionToDelete;
    }
}