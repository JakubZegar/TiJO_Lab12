package pl.edu.pwsztar;


import java.util.ArrayList;

public class BankAccountImpl implements BankAccount {

    private int ACCOUNT_NOT_EXISTS = -1;
    private final ArrayList<Account> accounts = new ArrayList<>();

    @Override
    public Account getAccountByNumber(int accountNumber){
        for(Account account : accounts){
            if(account.getAccountNumber() == accountNumber){
                return account;
            }
        }
        return new Account(ACCOUNT_NOT_EXISTS);
    }

    @Override
    public int createAccount(Account account){
        accounts.add(account);
        return account.getAccountNumber();
    }

    @Override
    public int deleteAccount(int accountNumber){

        if( accounts.contains(getAccountByNumber(accountNumber) )){
            int balance = getAccountByNumber(accountNumber).getAccountBalance();
            accounts.remove(getAccountByNumber(accountNumber));
            return balance;
        } else {
            return ACCOUNT_NOT_EXISTS;
        }
    }

    @Override
    public ArrayList<Account> getAllAccounts(){
        return accounts;
    }

}