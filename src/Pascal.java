import java.lang.Math;
public class Pascal extends BaseCalculation {

    public Pascal(int elements, double lambda) {
        super(elements, lambda);
    }

    @Override
    // calculate parallel mttf
    double calculateParallelMTTF() {
        double sum = 0;
        double fraction = 0; // fraction for better overview
        for(int i = 1; i <= elements; i++){
            fraction = (double) (fak(elements)) / (i* (fak(i)) * (fak(elements-i)));
            sum += Math.pow(-1,(elements+1)) * fraction;
        }
        return (sum/lambda);
}

    @Override
    // calculate serial mttf
    double calculateSerialMTTF() {
        return 1/(lambda*elements);
    }

    // create factorial (recursive structure)
    int fak (int faknum){
        if(faknum>1){
            return faknum*fak(faknum-1);
        }
        else{
            return 1;
        }
    }
}
