import java.lang.Math;

/**
 * @author 8951392
 */
public class System1 extends BaseCalculation {

    public System1(int elements, double lambda) {
        super(elements, lambda);
    }

    /**
     * Calculates parallel mean time to failure
     * @return MTTF for parallel system
     */
    @Override
    double calculateParallelMTTF() {
        double sum = 0;
        double tmp;
        for(int i=1; i <= elements; i++)
        {
            tmp = Math.pow(-1, elements+1);
            tmp *= (double) calcFactorial(elements) / (i*calcFactorial(i)*calcFactorial(elements-i));
            sum += tmp;
        }
        sum *= 1/lambda;
        return sum;
    }

    /**
     * Calculate serial mean time to failure
     * @return MTTF for serial system
     */
    @Override
    double calculateSerialMTTF() {

        return 1/(lambda*elements);
    }

    /**
     * Calculates factorial iteratively
     * @param n
     * @return n!
     **/
    long calcFactorial(int n) {
        long fac = 1;
        for(int i=1; i<=n; i++)
        {
            fac *= i;
        }
        return fac;
    }
}
