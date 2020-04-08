/**
 * This class represents one module for the MTTF calculation.
 * The class calculates the parallel and serial MTTF for the input value
 * number of elements and failure rate.
 */
public class Beni extends BaseCalculation {
    /**
     * Constructor for the class Beni. This one sets the class-variables
     * element and lambda.
     * @param elements is the number of elements in the MTTF module.
     * @param lambda is the failure rate of the module.
     */
    public Beni(int elements, double lambda) {
        super(elements, lambda);
    }

    /**
     * This function calculates a MTTF for parallel modules.
     * @return parallel MTTF as double.
     */
    @Override
    double calculateParallelMTTF() {
        //Helper variables used in this function.
        double result;
        double exponent;
        double denominator;
        double fraction;
        double tmpResult = 0.0;

        // This section calculates the sum for the parallel MTTF.
        for (int i = 1; i <= this.elements; i++) {
            exponent = Math.pow(-1, (this.elements + 1));
            denominator = (double) (i * this.fak(i) * this.fak(this.elements-i));
            fraction = (double) (this.fak(this.elements)) / denominator;
            tmpResult = tmpResult + (exponent * fraction);
        }

        result = tmpResult * (1 / this.lambda);

        return result;
    }

    /**
     * This function calculates a MTTF for serial modules.
     * @return serial MTTF as double.
     */
    @Override
    double calculateSerialMTTF() {
        return (1/(this.elements*this.lambda));
    }

    /**
     * This function calculates the factorial-value for a given number.
     * @param number for this number the factorial-value will be calculated as long so
     *               values greater than 13 can be calculated.
     * @return the factorial number for the input variable.
     */
    private long fak(int number) {
        int result = 1;

        if (number != 0) {
            for (int i = number; i > 0; i--) {
                result = result * i;
            }
        }

        return result;
    }

}
