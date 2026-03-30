public class ProblemM1052GrumpyBookstoreOwner {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int base = 0;
        int extra = 0;
        int bestExtra = 0;

        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) base += customers[i];
            else extra += customers[i];

            if (i >= minutes && grumpy[i - minutes] == 1) {
                extra -= customers[i - minutes];
            }
            bestExtra = Math.max(bestExtra, extra);
        }
        return base + bestExtra;
    }
}
