import java.util.HashMap;
import java.util.Map;

class BankAccount {
    private String accountNumber;
    private String owner;
    private double balance;

    public BankAccount(String accountNumber, String owner, double balance) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println(String.format("Deposit successful! New balance: $%.2f", this.balance));
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0) {
            if (this.balance >= amount) {
                this.balance -= amount;
                System.out.println(String.format("Withdrawal successful! New balance: $%.2f", this.balance));
            } else {
                System.out.println("Insufficient funds.");
            }
        } else {
            System.out.println("Withdrawal amount must be positive.");
        }
    }

    public double getBalance() {
        return this.balance;
    }

    @Override
    public String toString() {
        return String.format("Account(%s, Owner: %s, Balance: $%.2f)", this.accountNumber, this.owner, this.balance);
    }
}

class BankManagementSystem {
    private Map<String, BankAccount> accounts;

    public BankManagementSystem() {
        this.accounts = new HashMap<>();
    }

    public void createAccount(String accountNumber, String owner) {
        if (accounts.containsKey(accountNumber)) {
            System.out.println("Account number already exists.");
        } else {
            BankAccount account = new BankAccount(accountNumber, owner, 0.0);
            accounts.put(accountNumber, account);
            System.out.println(String.format("Account created successfully: %s", account));
        }
    }

    public void deposit(String accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            accounts.get(accountNumber).deposit(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    public void withdraw(String accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            accounts.get(accountNumber).withdraw(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    public void getBalance(String accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            double balance = accounts.get(accountNumber).getBalance();
            System.out.println(String.format("Account balance: $%.2f", balance));
        } else {
            System.out.println("Account not found.");
        }
    }

    public String getAccount(String accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            return accounts.get(accountNumber).toString();
        } else {
            return "Account not found.";
        }
    }
}

public class bank {
    public static void main(String[] args) {
        BankManagementSystem bankSystem = new BankManagementSystem();

        // Creating accounts
        bankSystem.createAccount("123456", "Parthiban");
        bankSystem.createAccount("654321", "Suresh");

        // Depositing money
        bankSystem.deposit("123456", 50000.0);
        bankSystem.deposit("654321", 60000.0);

        // Withdrawing money
        bankSystem.withdraw("123456", 30000.0);
        bankSystem.withdraw("654321", 35000.0);

        // Checking balances
        bankSystem.getBalance("123456");
        bankSystem.getBalance("654321");

        // Getting account details
        System.out.println(bankSystem.getAccount("123456"));
        System.out.println(bankSystem.getAccount("654321"));

        // Attempt to get details of a non-existent account
        System.out.println(bankSystem.getAccount("999999"));
    }
}
