package ro.fasttrackit.temacurs19.model;

import com.sun.source.tree.UsesTree;

import java.util.Objects;

public class Transaction {
    private final int id;
    private final String product;
    private final String type;
    private final double amount;

    public Transaction(int id, String product, String type, double amount) {
        this.id = id;
        this.product = product;
        this.type = type;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public String getProduct() {
        return product;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return id == that.id && Double.compare(that.amount, amount) == 0 && Objects.equals(product, that.product) && Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, product, type, amount);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", product='" + product + '\'' +
                ", type='" + type + '\'' +
                ", amount=" + amount +
                '}';
    }
}

