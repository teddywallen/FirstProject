public class SavingsAccount extends Account {
    private double interestRate;

    /**
     * precondition: startBal >= 0.0
     * postcondition: An Account with identity number idNum and current balance
     * of startBal has been created
     *
     * @param idNum
     * @param startBal
     * @param ir
     */
    public SavingsAccount(int idNum, double startBal, double ir) {
        super(idNum, startBal);
        interestRate = ir;
    }

    /** Returns monthly interest for this SavingsAccount
     * @return
     */
    public double monthlyInterest() {
        return (super.currentBalance()*interestRate)/12; // don't need super. before currentBal,
        // when JVM doesn't know where to go it goes to parent
    }
}

