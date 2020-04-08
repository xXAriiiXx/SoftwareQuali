import java.lang.Math.*;
/**
 * This class calculates the MTTF_R and MTTF_P value
 * using the parameters elements = n and failure rate lambda
 *
 * @author 9916444
 */
public class System5 extends BaseCalculation{

    public System5(int elements, double lambda) {
        super(elements, lambda);
    }

    /**
     * This Methods calculates the parallel MTTF = MTTF_P
     * using the equation MTTF_P = (1 / lambda) * Sum i to n ((-1)^(n+1) * (n! / ( i * i! * (n-i)!)))
     * @return MTTP_P
     */
    @java.lang.Override
    double calculateParallelMTTF() {
        double sum_result = 0.0;

        // Calculates sum of equation
        for (int i = 1; i <= elements; i++)
            sum_result += ( (Math.pow((-1.0), (elements + 1))) * ( (double)factorial(elements) / ( i * (double)factorial(i) * ( (double)factorial( elements - i) ))));

        return (1 / lambda) * sum_result;
    }

    /**
     * This Methods calculates the serial MTTF = MTTF_R
     * using the equation MTTF_R = 1 / (lambda * n)
     * @return MTTF_R
     */
    @java.lang.Override
    double calculateSerialMTTF() {
        return 1 / (lambda * elements);
    }

    /**
     * This method calulates the facorial for input n
     * @param n
     * @return n!
     */
    double factorial(int n) {
        {
            double product = 1;
            for ( int j=1; j<=n; j++ )
                product *= j;
            return product;
        }
    }
}