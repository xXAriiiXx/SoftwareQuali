public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        Simon simonObjekt = new Simon(12, 0.1);
             System.out.println("MTTF_R: " + simonObjekt.calculateSerialMTTF());
             System.out.println("MTTF_P: " + simonObjekt.calculateParallelMTTF());

    }
}