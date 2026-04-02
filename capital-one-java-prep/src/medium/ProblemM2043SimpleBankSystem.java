class Bank {
    long[] accountBalance;
    int totalAccount;
    public Bank(long[] balance) {
        this.accountBalance = balance;
        this.totalAccount = balance.length;
    }

    private boolean isValidAccount(int acccount) {
        return acccount <= totalAccount && acccount > 0;
    }

    private boolean hasBalance(int account, long money) {
        if(!isValidAccount(account)) {
            return false;
        }
        return this.accountBalance[account - 1] >= money;
    }
    
    public boolean transfer(int account1, int account2, long money) {
        if(hasBalance(account1, money) && isValidAccount(account2) && money >= 0) {
            this.accountBalance[account2 - 1] += money;
            this.accountBalance[account1 - 1] -= money;
            return true;
        }
        return false;
    }
    
    public boolean deposit(int account, long money) {
        if(money >= 0 && isValidAccount(account)) {
            this.accountBalance[account - 1] += money;
            return true;
        }
        return false;
    }
    
    public boolean withdraw(int account, long money) {
        if(hasBalance(account, money)) {
            this.accountBalance[account - 1] -= money;
            return true;
        }
        return false;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */
