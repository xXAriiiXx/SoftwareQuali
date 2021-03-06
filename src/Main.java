import java.util.Scanner;
public class Main {

    /**
     * Entrypoint for the application.
     * @param args command-line parameters.
     */
    public static void main(String[] args) {
        int statusCode;
        /*
        Input values are the same, same output is expected everywhere
         */
        System.out.println("Alle Systeme erhalten dieselben Übergabeparameter:");
        int numberElements = 5;
        double lambda = 0.1;
        BaseCalculation[] allSystems = new BaseCalculation[5];
        allSystems[0] = new System1(numberElements, lambda);
        allSystems[1] = new System4(numberElements,lambda);
        allSystems[2] = new System3(numberElements, lambda);
        allSystems[3] = new System5(numberElements, lambda);
        allSystems[4] = new System2(numberElements, lambda);
        statusCode = voting(allSystems);
        output(statusCode);
        /*
        4 inputs the same, one is different, voting should still allow
        */
        System.out.println("Ein System erhaelt unterschiedliche Übergabeparameter:");
        int oneDifferentElement = 6;
        allSystems[0] = new System1(numberElements, lambda);
        allSystems[1] = new System4(numberElements,lambda);
        allSystems[2] = new System3(numberElements, lambda);
        allSystems[3] = new System5(numberElements, lambda);
        allSystems[4] = new System2(oneDifferentElement, lambda);
        statusCode = voting(allSystems);
        output(statusCode);
        /*
        2 Inputs different, voting should fail, go into safe state
        */
        System.out.println("Zwei Systeme erhalten unterschiedliche Übergabeparameter:");
        int twoDifferentElement = 4;
        allSystems[0] = new System1(twoDifferentElement, lambda);
        allSystems[1] = new System4(numberElements,lambda);
        allSystems[2] = new System3(numberElements, lambda);
        allSystems[3] = new System5(oneDifferentElement, lambda);
        allSystems[4] = new System2(numberElements, lambda);
        statusCode = voting(allSystems);
        output(statusCode);
        /*
        User input for each System
         */
        System.out.println();
        System.out.println("Manuelle Eingabe der Parameter für jedes System");
        input(allSystems);
        statusCode = voting(allSystems);
        output(statusCode);
    }

    /**
     * Takes user input for 5 systems and passes the user-entered parameters to the individual systems
     * @param allSystems an array containing 5 systems.
     */
    public static void input(BaseCalculation[] allSystems)
    {
        int n;
        double lambda;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Parameter für System 1:");
        System.out.print("Bitte Anzahl der Elemente eingeben ");
        n = scanner.nextInt();
        System.out.print("Bitte Ausfallrate eingeben ");
        lambda = scanner.nextDouble();
        allSystems[0] = new System1(n, lambda);
        System.out.println();
        System.out.println("Parameter für System 2:");
        System.out.print("Bitte Anzahl der Elemente eingeben ");
        n = scanner.nextInt();
        System.out.print("Bitte Ausfallrate eingeben ");
        lambda = scanner.nextDouble();
        allSystems[1] = new System2(n, lambda);
        System.out.println();
        System.out.println("Parameter für System 3:");
        System.out.print("Bitte Anzahl der Elemente eingeben ");
        n = scanner.nextInt();
        System.out.print("Bitte Ausfallrate eingeben ");
        lambda = scanner.nextDouble();
        allSystems[2] = new System3(n, lambda);
        System.out.println();
        System.out.println("Parameter für System 4:");
        System.out.print("Bitte Anzahl der Elemente eingeben ");
        n = scanner.nextInt();
        System.out.print("Bitte Ausfallrate eingeben ");
        lambda = scanner.nextDouble();
        allSystems[3] = new System4(n, lambda);
        System.out.println();
        System.out.println("Parameter für System 5:");
        System.out.print("Bitte Anzahl der Elemente eingeben ");
        n = scanner.nextInt();
        System.out.print("Bitte Ausfallrate eingeben ");
        lambda = scanner.nextDouble();
        allSystems[4] = new System5(n, lambda);
        System.out.println();
    }


    /**
     * Voting function for determining system state.
     * @param allSystems the array containing an arbitrary number of systems.
     * @return the system state as integer.
     */
    public static int voting(BaseCalculation[] allSystems)
    {
        int numberOfSameAnswers = 0;
        for(int i = 0; i < allSystems.length-1; i++)
        {
            for(int j = i+1; j<allSystems.length; j++)
            {
                if(j == i) continue;
                //Because of floating-point-precision, there has to be a tolerance taken into account.
                if(Math.abs(allSystems[j].calculateParallelMTTF()-allSystems[i].calculateParallelMTTF()) < 0.000001)
                    if(Math.abs(allSystems[j].calculateSerialMTTF()-allSystems[i].calculateSerialMTTF()) < 0.000001)
                        numberOfSameAnswers++;
            }
        }
        int expected = calculateExpectedSame(allSystems.length);
        if(numberOfSameAnswers == expected)
            return 1;
        //If one system has a different result, n-1 answers differ. 
        else if(numberOfSameAnswers == expected-(allSystems.length-1))
            return 0;
        else
            return -1;
    }

    /**
     * Calculates the expected number of equal system answer combinations.
     * @param n the number of systems to be compared.
     * @return the expected number of equal combinations.
     */
    public static int calculateExpectedSame(int n)
    {
        int sum = 0;
        for(int i = n-1; i>0; i-- )
        {
            sum += i;
        }
        return sum;
    }

    /**
     * Takes the current status code of the system and prints it as a string to the console.
     * @param status the current status code of the system.
     */
    public static void output(int status)
    {
        if(status == 1)
            System.out.println("Keine Fehler aufgetreten!");
        else if(status == 0)
            System.out.println("1 Fehler aufgetreten!");
        else
            System.out.println("Mehrere Fehler aufgetreten! Nehme sicheren Zustand ein!");
    }
}