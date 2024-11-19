import java.util.*;

class Account {
    private double balance;

    public Account(double intialBalance) {
        this.balance = intialBalance;
    }

    public double getbalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfulley amount deposited.");
        } else {
            System.out.println("deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (balance > amount) {
            balance -= amount;
            System.out.println("Successfully amount withdraw " + amount);
        } else if (amount > balance) {
            System.out.println("Insufficient Balance.");
        } else {
            System.out.println("Withdraw amount must be positive.");
        }
    }
}

class Atm {
    private Account account;

    public Atm(Account account) {
        this.account = account;
    }

    public void menu() {
        Scanner scn = new Scanner(System.in);
        boolean ContinueSession = true;
        while (ContinueSession) {
            System.out.println("=====ATM Menu=====");
            System.out.println("1.Check Balance");
            System.out.println("2.Deposite");
            System.out.println("3.Withdraw");
            System.out.println("4.Exit");
            System.out.println("Choose an option ");
            int choice = scn.nextInt();
            switch (choice) {
                case 1:
                    CheckBalance();
                    break;
                case 2:
                    System.out.println("Enter the amount to deposit : ");
                    double depositamount = scn.nextDouble();
                    deposit(depositamount);
                    break;
                case 3:
                    System.out.println("Enter the amount to withdraw : ");
                    double withdrawamount = scn.nextDouble();
                    withdraw(withdrawamount);
                    break;
                case 4:
                    ContinueSession = false;
                    System.out.println("Thank you for using our ATM. ");
                    break;

                default:
                System.out.println("Invalid option.");
            }
        }

        scn.close();
    }

    public void CheckBalance() {
        System.out.println("The available balance : " + account.getbalance());
    }

    public void deposit(double amount) {
        account.deposit(amount);
    }

    public void withdraw(double amount) {
        account.withdraw(amount);
    }
}

public class Atm_interface {
    public static void main(String[] args) {
        Account account = new Account(500.00);
        Atm mAtm = new Atm(account);
        mAtm.menu();
    }
}
