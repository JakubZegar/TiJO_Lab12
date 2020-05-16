package pl.edu.pwsztar

import spock.lang.Specification
import spock.lang.Unroll

class DeleteAccountSpec extends Specification{
    @Unroll
    def "should delete account  and show  #balance"() {

        given: "some accounts exist and there is some money on them or not"
            def bank = new Bank()
            def accountNumber = bank.createAccount()
            bank.deposit(accountNumber, amount)
        when: "the account is deleted"
            def deletedAccountBalance = bank.deleteAccount(accountNumber)
        then: "gets balance equals to #balance of deleted account"
            deletedAccountBalance == balance
        where:
            amount  |   balance
            200     |   200
            0       |   0
            512     |   512
    }
}