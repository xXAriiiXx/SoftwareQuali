public abstract class BaseCalculation {
    protected int elements;
    protected double lambda;
    public BaseCalculation(int elements, double lambda){
        this.elements = elements;
        this.lambda = lambda;
    };
    abstract double calculateParallelMTTF();
    abstract double calculateSerialMTTF();
}
