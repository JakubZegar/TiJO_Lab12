package pl.edu.pwsztar;

// TODO: Prosze dokonczyc implementacje oraz testy jednostkowe
// TODO: Prosze nie zmieniac nazw metod - wszystkie inne chwyty dozwolone
// TODO: (prosze jedynie trzymac sie dokumentacji zawartej w interfejsie BankOperation)
class Bank implements BankOperation {

    private static int newAccountNumber = 0;
    private int ACCOUNT_NOT_EXISTS = -1;
    private static BankAccount bankAccount;
    private Account fromAccountNum, toAccountNum;

    public Bank(){
        bankAccount = new BankAccountImpl();
    }

    public int createAccount() {
        bankAccount.createAccount(new Account(++newAccountNumber));
        return bankAccount.getAccountByNumber(newAccountNumber).getAccountNumber();
    }

    public int deleteAccount(int accountNumber) {
        int deletedAccountBalance = bankAccount.deleteAccount(accountNumber);
        if ( deletedAccountBalance != ACCOUNT_NOT_EXISTS ){
            return deletedAccountBalance;
        } else {
            return ACCOUNT_NOT_EXISTS;
        }
    }

    public boolean deposit(int accountNumber, int amount) {
        fromAccountNum = bankAccount.getAccountByNumber(accountNumber);
        if ( fromAccountNum.getAccountNumber() != ACCOUNT_NOT_EXISTS && amount > 0 ) {
            fromAccountNum.setAccountBalance( fromAccountNum.getAccountBalance() + amount );
            return true;
        } else {
            return false;
        }
    }

    public boolean withdraw(int accountNumber, int amount) {
        fromAccountNum = bankAccount.getAccountByNumber(accountNumber);
        if (fromAccountNum.getAccountBalance() >= amount && amount > 0 ){
            fromAccountNum.setAccountBalance( fromAccountNum.getAccountBalance() - amount );
            return true;
        } else {
            return false;
        }
    }

    public boolean transfer(int fromAccount, int toAccount, int amount) {
        fromAccountNum = bankAccount.getAccountByNumber(fromAccount);
        toAccountNum =  bankAccount.getAccountByNumber(toAccount);

        if ( fromAccountNum.getAccountBalance() >= amount && amount > 0 && fromAccount != ACCOUNT_NOT_EXISTS && toAccount != ACCOUNT_NOT_EXISTS ) {
            fromAccountNum.setAccountBalance( fromAccountNum.getAccountBalance() - amount );
            toAccountNum.setAccountBalance( toAccountNum.getAccountBalance() + amount );
            return true;
        } else {
            return false;
        }
    }

    public int accountBalance(int accountNumber) {
        fromAccountNum = bankAccount.getAccountByNumber(accountNumber);
        if( fromAccountNum.getAccountNumber() != ACCOUNT_NOT_EXISTS ){
            return fromAccountNum.getAccountBalance();
        } else {
            return ACCOUNT_NOT_EXISTS;
        }
    }

    public int sumAccountsBalance() {
        return bankAccount.getAllAccounts().stream()
                .mapToInt(Account::getAccountBalance)
                .sum();
    }
}
