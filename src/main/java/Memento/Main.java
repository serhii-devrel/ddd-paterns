package Memento;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Balance balance = new Balance(500);
        Balance.Memento m1 = balance.deposit(500);
        Balance.Memento m2 = balance.deposit(500);
        Balance.Memento m3 = balance.deposit(200);
        balance.restoreBalanceTo(m2); // m2 = 500 + 500 + 500 = 1500
        balance.undo(); // m3 = 1700
        System.out.println(balance.balance);

    }
}

class Balance {
    int balance;
    List<Balance.Memento> states = new ArrayList<>();
    int currentStateIndex = 0;

    public Balance(int balance) {
        this.balance = balance;
        states.add(new Memento(this.balance));
    }

    public Memento deposit(int amount) {
        this.balance += amount;
        Memento memento = new Memento(this.balance);
        states.add(memento);
        ++currentStateIndex;
        return memento;
    }

    public void restoreBalanceTo(Memento memento) {
        this.balance = memento.Balance;
        states.add(memento);
        currentStateIndex = states.size() - 1;
    }

    public void redo() {
        this.balance = states.get(++currentStateIndex).Balance;
    }

    public void undo() {
        if (states.size() > 0) {
            this.balance = states.get(--currentStateIndex).Balance;
        }
    }

    static class Memento {
        int Balance;

        public Memento(int balance) {
            Balance = balance;
        }
    }
}