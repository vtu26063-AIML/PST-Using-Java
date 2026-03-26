import java.util.*;

class Account {
    int accNo;
    String name;
    double balance;

    Account(int accNo, String name, double balance) {
        this.accNo = accNo;
        this.name = name;
        this.balance = balance;
    }
}

class Bank {
    HashMap<Integer, Account> accounts = new HashMap<>();

    void addAccount(Account a) {
        accounts.put(a.accNo, a);
    }

    void deposit(int accNo, double amount) {
        Account a = accounts.get(accNo);
        if (a == null) {
            System.out.println("Account not found");
            return;
        }
        a.balance += amount;
        System.out.println("Deposited " + (int)amount + " to " + a.name);
    }

    void withdraw(int accNo, double amount) {
        Account a = accounts.get(accNo);
        if (a == null) {
            System.out.println("Account not found");
            return;
        }
        if (a.balance < amount) {
            System.out.println("Insufficient balance");
            return;
        }
        a.balance -= amount;
        System.out.println("Withdrawn " + (int)amount + " from " + a.name);
    }

    void transfer(int fromAcc, int toAcc, double amount) {
        Account from = accounts.get(fromAcc);
        Account to = accounts.get(toAcc);

        if (from == null || to == null) {
            System.out.println("Account not found");
            return;
        }

        if (from.balance < amount) {
            System.out.println("Insufficient balance");
            return;
        }

        from.balance -= amount;
        to.balance += amount;

        System.out.println("Transferred " + (int)amount + " from " + from.name + " to " + to.name);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int accNo = sc.nextInt();
            String name = sc.next();
            double bal = sc.nextDouble();
            bank.addAccount(new Account(accNo, name, bal));
        }

        int q = sc.nextInt();

        for (int i = 0; i < q; i++) {
            String op = sc.next();

            if (op.equals("DEPOSIT")) {
                int acc = sc.nextInt();
                double amt = sc.nextDouble();
                bank.deposit(acc, amt);
            } 
            else if (op.equals("WITHDRAW")) {
                int acc = sc.nextInt();
                double amt = sc.nextDouble();
                bank.withdraw(acc, amt);
            } 
            else if (op.equals("TRANSFER")) {
                int from = sc.nextInt();
                int to = sc.nextInt();
                double amt = sc.nextDouble();
                bank.transfer(from, to, amt);
            }
        }

        sc.close();
    }
}