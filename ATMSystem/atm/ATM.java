package atm;

import database.Account;

public abstract class ATM {
    protected Account account;

    public ATM(Account account) {
        this.account = account;
    }

    public abstract void showMenu();
}
