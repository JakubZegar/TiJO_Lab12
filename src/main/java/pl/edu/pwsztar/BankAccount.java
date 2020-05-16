package pl.edu.pwsztar;

import java.util.List;

public interface BankAccount {

    Account getAccountByNumber(int accountNumber);

    int createAccount(Account account);

    int deleteAccount(int accountNumber);

    List<Account> getAllAccounts();
}