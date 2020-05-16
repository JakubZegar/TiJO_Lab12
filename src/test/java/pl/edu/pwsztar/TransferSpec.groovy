package pl.edu.pwsztar

import spock.lang.Specification
import spock.lang.Unroll

class TransferSpec extends Specification{
    @Unroll
    def "trying to transfer #amountToTransfer from account with #amount to another the result is #result" () {

        given: "create accounts, one with money, other without"
            def bank = new Bank()
            def firstAccountNumber = bank.createAccount()
            def secondAccountNumber = bank.createAccount()
            bank.deposit(firstAccountNumber, amount)
        when: "money is transfered"
            def res = bank.transfer(firstAccountNumber,secondAccountNumber, amountToTransfer)
        then: "gets result depends if the transfer was sucessful"
            res == result
        where:
            amount  | amountToTransfer|   result
            200     |  100           |  true
            0       |  0             |  false
            512     |  512           |  true
            120     |  -940          |  false
            120     |  344           |  false
    }
}