package ro.fasttrackit.temacurs19.controller;

import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.temacurs19.model.Transaction;
import ro.fasttrackit.temacurs19.service.TransactionService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("transactions")
public class TransactionController {
    private final TransactionService service;

    public TransactionController(TransactionService service) {
        this.service = service;
    }

    @GetMapping
    List<Transaction> test() {
        return service.getAll();
    }

    @GetMapping("transactions/{id}")
    Optional<Transaction> getId(@PathVariable int id) {
        return service.getById(id);
    }

    @PostMapping
    Transaction addTransaction(@RequestBody Transaction transaction) {
        return service.add(transaction);
    }

    @PutMapping("{id}")
    Transaction replaceTransaction(@PathVariable int id, @RequestBody Transaction transaction) {
        return service.replace(id, transaction)
                .orElseThrow();
    }

    @DeleteMapping("{id}")
    Transaction deleteTransaction(@PathVariable int id) {
        return service.delete(id)
                .orElse(null);
    }
}