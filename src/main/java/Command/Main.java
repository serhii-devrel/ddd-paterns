package Command;

public class Main {
    public static void main(String[] args) {
        BankAccount ba = new BankAccount(500);
        ICommand cmd = new BankAccountCommand();

        cmd.call(ba, BankActions.Deposit, 300);
        System.out.println(ba.getBalance());

        cmd.call(ba, BankActions.Withdraw, 100);
        System.out.println(ba.getBalance());
    }
}

class BankAccount {
    private int balance;

    public int getBalance() {
        return balance;
    }

    public BankAccount(int balance) {
        this.balance = balance;
    }

    public void deposit(int amount) {
        this.balance += amount;
    }

    public void withdraw(int amount) {
        this.balance -= amount;
    }
}

enum BankActions {
    Deposit,
    Withdraw,
}

interface ICommand {
    void call(BankAccount ba, BankActions action, int amount);
}

class BankAccountCommand implements ICommand {
    @Override
    public void call(BankAccount ba, BankActions action, int amount) {
        switch (action) {
            case Deposit:
                ba.deposit(amount);
                break;
            case Withdraw:
                ba.withdraw(amount);
                break;
        }

    }
}