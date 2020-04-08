
public class Main {
    public static void main(String[] args) {
        /*
        Input values are the same, same output is expected everywhere
         */
        int numberElements = 12;
        double lambda = 0.1;
        BaseCalculation[] allSystems = new BaseCalculation[5];
        allSystems[0] = new Ari(numberElements, lambda);
        allSystems[1] = new Pascal(numberElements,lambda);
        allSystems[2] = new Maxi(numberElements, lambda);
        allSystems[3] = new Simon(numberElements, lambda);


        /*
        4 inputs the same, one is different, voting should still allow
        */
        int oneDifferentElement = 6;

        /*
        2 Inputs different, voting should fail, go into safe state
        */
        int twoDifferentElement = 4;

    }

    public int Voting(BaseCalculation[] allSystems)
    {
        int numberOfSameAnswers = 1;
        for(int i = 1; i<allSystems.length; i++)
        {
            if( (allSystems[0].calculateParallelMTTF()-allSystems[i].calculateParallelMTTF()) < 0.000001)
                if((allSystems[0].calculateSerialMTTF()-allSystems[i].calculateSerialMTTF()) < 0.000001)
                    numberOfSameAnswers++;
        }
        if(numberOfSameAnswers == allSystems.length)
            return 1;
        else if(numberOfSameAnswers == allSystems.length-1)
            return 0;
        else
            return -1;
    }

    public void Ausgabe(int status)
    {
        if(status == 1)
            System.out.println("Keine Fehler aufgetreten!");
        else if(status == 0)
            System.out.println("1 Fehler aufgetreten!");
        else
            System.out.println("Mehrere Fehler aufgetreten! Nehme sicheren Zustand ein!");
    }
}