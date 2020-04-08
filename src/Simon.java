import java.lang.Math.*;

/**
 * This class calculates the MTTF_R and MTTF_P value
 * using the parameters elements = n and failure rate lambda
 *
 * @author 9916444
 */
public class Simon extends BaseCalculation{

    public Simon(int elements, double lambda) {
        super(elements, lambda);
    }

    /**
     * This Methods calculates the parallel MTTF = MTTF_P
     * @return MTTP_P
     */
    @java.lang.Override
    double calculateParallelMTTF() {
        double temp_val = 0.0;

        for (int i = 1; i <= elements; i++)
            temp_val += ( (Math.pow((-1.0), (elements + 1))) * ( (double)factorial(elements) / ( i * (double)factorial(i) * ( (double)factorial( elements - i) ))));

        return (1 / lambda) * temp_val;
    }

    /**
     * This Methods calculates the serial MTTF = MTTF_R
     * @return MTTF_R
     */
    @java.lang.Override
    double calculateSerialMTTF() {
        return 1 / (lambda * elements);
    }

    /**
     * This method calulates the facorial for input n
     * @param n
     * @return factorial3
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
