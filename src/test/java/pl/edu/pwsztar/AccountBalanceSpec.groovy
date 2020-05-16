package pl.edu.pwsztar

import spock.lang.Specification
import spock.lang.Unroll

class AccountBalacneSpec extends Specification{
    @Unroll
    def "trying to check the account balnce, the result is  #balance" () {

        given: "create accounts and deposit some money on them"
            def bank = new Bank()
            def accountNumber = bank.createAccount()
            bank.deposit(accountNumber, amount)
        when: "balance is checked"
            def currentBalance = bank.accountBalance(accountNumber)
        then: "result"
            currentBalance == balance
        where:
            amount  | balance
            200     |  200
            0       |  0
            512     |  512
            120     |  120
    }
}