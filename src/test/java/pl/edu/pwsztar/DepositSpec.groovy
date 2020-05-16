package pl.edu.pwsztar

import spock.lang.Specification
import spock.lang.Unroll

class DepositSpec extends Specification{
    @Unroll
    def "trying to deposit #amount on  account and the result is #result" () {

        given: "create accounts"
            def bank = new Bank()
            def accountNumber = bank.createAccount()
        when: "money is deposited on account"
            def res = bank.deposit(accountNumber, amount)
        then: "gets result depend on how much money you want to deposit"
            res == result
        where:
        amount  |   result
        200     |   true
        0       |   false
        512     |   true
        -120    |   false
    }
}