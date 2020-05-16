package pl.edu.pwsztar;
public class Account {

    private int accountBalance;
    private int accountNumber;

    Account(int accountNumber){
        this.accountNumber = accountNumber;
        this.accountBalance = 0;
    }

    void setAccountBalance(int accountBalance) {
        this.accountBalance = accountBalance;
    }

    int getAccountBalance() {
        return accountBalance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }
}
