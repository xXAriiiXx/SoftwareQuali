import java.lang.Math;
public class System1 extends BaseCalculation {

    public System1(int elements, double lambda) {
        super(elements, lambda);
    }

    @Override
    double calculateParallelMTTF() {
        /**
         * Calculates Parallel Mean Time To Failure
         */
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

    @Override
    double calculateSerialMTTF() {
        /**
         * Calculates Serial Mean Time To Failure
         */
        return 1/(lambda*elements);
    }

    long calcFactorial(int n) {
        /**
         * Calculates factorial iteratively
         */
        long fac = 1;
        for(int i=1; i<=n; i++)
        {
            fac *= i;
        }
        return fac;
    }
}
