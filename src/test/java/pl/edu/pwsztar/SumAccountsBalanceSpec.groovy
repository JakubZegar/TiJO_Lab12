package pl.edu.pwsztar

import spock.lang.Specification
import spock.lang.Unroll

class SumAccountBalacneSpec extends Specification{
    @Unroll
    def "trying to check total sum of money of all accounts, result is  #totalBalance" () {

        given: "create some accounts"
            def bank = new Bank()
            def accountNumber1 = bank.createAccount()
            def accountNumber2 = bank.createAccount()
            def accountNumber3 = bank.createAccount()
            def accountNumber4 = bank.createAccount()
            bank.deposit(accountNumber1, amount)
            bank.deposit(accountNumber2, amount)
            bank.deposit(accountNumber3, amount)
            bank.deposit(accountNumber4, amount)
        when: "sum all money"
            def currentBalance = bank.sumAccountsBalance()
        then: "gets result"
            currentBalance == totalBalance
        where:
            amount  | totalBalance
            200     |  800
            0       |  0
            512     |  2048
            120     |  480
    }
}