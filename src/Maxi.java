public class Maxi extends BaseCalculation {

    /**
     * Constuctor for this class. The parameters used in the calculations
     * must be passed.
     * @param elements the number of elements.
     * @param lambda the value of lambda.
     */
    public Maxi(int elements, double lambda) {
        super(elements, lambda);
    }

    /**
     * Calculates the factorial of a given number.
     * @param n the number to calculate the factorial of.
     * @return the factorial of the input number.
     */
    private long factorial(long n) {
        long result = 1;
        for(long i = n; i > 0; i--) {
            result = result * i;
        }
        return result;
    }

    /**
     * Calculates the parallel Mean-Time-To-Failure for
     * the parameters passed in the constructor of this class.
     * The calculation is based on double precision.
     * @return the parallel MTTF (double-precision).
     */
    @Override
    double calculateParallelMTTF() {
        double sumResult = 0;
        for(int i = 1; i <= this.elements; i++) {
            double expResult = Math.pow(-1, this.elements + 1);
            double numerator = this.factorial(this.elements);
            double denominator = i * this.factorial(i) * this.factorial(this.elements - i);

            sumResult = sumResult + expResult * (numerator / denominator);
        }

        return sumResult / this.lambda;
    }

    /**
     * Calculates the serial Mean-Time-To-Failure for
     * the parameters passed in the constructor of this class.
     * The calculation is based on double precision.
     * @return the serial MTTF (double-precision).
     */
    @Override
    double calculateSerialMTTF() {
        return 1/(this.lambda * this.elements);
    }
}
