public abstract class BaseCalculation {
    protected int elements;
    protected float lambda;
    public BaseCalculation(int elements, float lambda){
        this.elements = elements;
        this.lambda = lambda;
    };
    abstract float calculateParallelMTTF();
    abstract float calculateSerialMTTF();
}
