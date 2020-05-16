package pl.edu.pwsztar;

interface BankOperation {

    int ACCOUNT_NOT_EXISTS = -1;

    int createAccount();

    int deleteAccount(int accountNumber);

    boolean deposit(int accountNumber, int amount);

    boolean withdraw(int accountNumber, int amount);

    boolean transfer(int fromAccount, int toAccount, int amount);

    int accountBalance(int accountNumber);

    int sumAccountsBalance();
}
