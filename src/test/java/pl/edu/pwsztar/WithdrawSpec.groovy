package pl.edu.pwsztar

import spock.lang.Specification
import spock.lang.Unroll

class WithdrawSpec extends Specification{
    @Unroll
    def "trying to withdraw #amount on account and the result is #result" () {

        given: "some accounts with money must exists"
            def bank = new Bank()
            def accountNumber = bank.createAccount()
            bank.deposit(accountNumber, currentAmmount)
        when: "money is deposited on account"
            def res = bank.withdraw(accountNumber, amount)
        then: "gets result depends if you can withdraw that amount of money"
            res == result
        where:
            currentAmmount  |   amount  |   result
            800             |   200     |   true
            950             |     0     |   false
            1900            |    512    |   true
             0              |   -120    |   false
          1500              |   -120    |   false
    }
}