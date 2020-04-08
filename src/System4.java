// math class for pow method
import java.lang.Math;
/**
 * This class represents one system for calculating the mean time to failure (MTTF)
 * for a parallel arrangement and a series arrangement of a number of identical components
 * @author 1650076
 */
public class System4 extends BaseCalculation {
    /**
     * Constructor for the class, sets class-variables
     * @param elements the number of components (int)
     * @param lambda the value of the failure rate (double)
     */
    public System4(int elements, double lambda) {
        super(elements, lambda);
    }

    /**
     * calculates mean time to failure (MTTF) for a parallel arrangement
     * using class-variables (elements, lambda)
     * @return MTTF, parallel (double)
     */
    @Override
    double calculateParallelMTTF() {
        double sum = 0;
        double fraction; // fraction for better overview
        for(int i = 1; i <= elements; i++){
            fraction = (double) (fac(elements)) / (i * (double)(fac(i)) * (double)(fac(elements-i)));
            sum += Math.pow(-1, (elements+1)) * fraction;
        }
        return (sum / lambda);
}
    /**
     * calculates mean time to failure (MTTF) for a series arrangement
     * using class-variables (elements, lambda)
     * @return MTTF, series (double)
     */
    @Override
    double calculateSerialMTTF() {
        return (1 / (lambda * elements));
    }

    /**
     * calculates factorial of a number (recursive structure)
     * @param facnum the number for calculating the factorial (int)
     * @return the factorial of the number (faknum) (long)
     */
    private long fac (int facnum){
        if(facnum > 1){
            return facnum * fac(facnum - 1);
        }
        else{
            return 1;
        }
    }
}
