package idoregesz;

import java.util.Scanner;

public class Helyszin {

    public void kezdes() {
        System.out.println("Egy óriási mezőn vagy. Nyugat felé egy hatalmas épület körvonalai tűnnek fel.");
        System.out.println("Mit cselekszel?");
        //beker();
    }

    public String beker() {
        Scanner sc = new Scanner(System.in);
        
        return sc.next();
    }

}
