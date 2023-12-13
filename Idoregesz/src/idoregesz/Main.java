package idoregesz;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    static Scanner sc = new Scanner(System.in);
    String ige;
    String hely;
    int kor = 0;
    ArrayList<String> targyak = new ArrayList<String>();
    Karakter karakter = new Karakter(5, targyak);
    boolean el = true;

    public static void main(String[] args) {
        new Main().kezdes();

    }

    public void leiras(String leiras) {
        System.out.println(leiras);

    }

    public void eletKiir() {
        System.out.println("--------");
        System.out.println("Életerő: " + karakter.getElet());
        System.out.println("--------");
    }

    public void beker() {
        Scanner s = new Scanner(System.in);
        ige = s.nextLine();
    }

    public void megy() {
        Scanner s = new Scanner(System.in);
        hely = s.nextLine();
    }

    public void felvesz(String targy) {
        karakter.felvesz(targy);
    }
    
    public String hasznal() {
        System.out.println("Mit szeretnél használni?");
        System.out.println("Tárgyaid:");
        for (String targy : karakter.getTargyak()) {
            System.out.println(targy);
        }
        Scanner s = new Scanner(System.in);
        String targy = s.nextLine();
        if (karakter.getTargyak().contains(targy)) {
            return targy;
        }
        
        return "rossz";
        
    }

    public void korSzamol() {
        kor++;
        if (kor >= 3) {
            karakter.eletCsokkent();
            System.out.println("Karaktered életereje csökkent!");
        }
        eletKiir();
        if (karakter.getElet() == 0) {
            System.out.println("-----------------");
            System.out.println("VÉGE A JÁTÉKNAK");
            System.out.println("-----------------");
        }
    }

    public void kezdes() {
        korSzamol();

        leiras("Egy óriási mezőn vagy. Nyugat felé egy hatalmas épület körvonalai tűnnek fel.");

        System.out.println("Mit teszel? (Lehetőségek: megy)");
        beker();
        if (ige.equals("megy")) {
            System.out.println("Hova mész? (Lehetőségek: nyugat)");
            megy();

        }

        if (hely.equals("nyugat")) {
            mezo();
        }
        //beker();
    }

    public void mezo() {
        korSzamol();
        leiras("Napfényes mezőn állsz. Nyugatra egy hatalmas kastélyt, délre egy kutat látsz.");

        System.out.println("Mit teszel? (Lehetőségek: megy)");
        beker();
        if (ige.equals("megy")) {
            System.out.println("Hova mész? (Lehetőségek: nyugat, del)");
            megy();

        }

        if (hely.equals("nyugat")) {
            kastely();
        } else if (hely.equals("del")) {
            kut();
        }

    }

    public void kut() {
        korSzamol();

        leiras("Napfényes mezőn állsz, egy kút előtt. Itt van: "
                + "pénz. Nyugatra egy hatalmas kastélyt látsz.");

        System.out.println("Mit teszel? (Lehetőségek: megy, felvesz)");

        beker();
        if (ige.equals("megy")) {
            System.out.println("Hova mész? (Lehetőségek: Nyugat)");
            megy();

        } else if (ige.equals("felvesz")) {
            felvesz("penz");
            System.out.println("Felvetted ezt: pénz");
            System.out.println("Mit teszel? (Lehetőségek: megy)");
            ige = sc.next();
            if (ige.equals("megy")) {
                System.out.println("Hova mész? (Lehetőségek: nyugat)");
                megy();
            }
        }

        if (hely.equals("nyugat")) {
            kastely();
        }

    }

    public void kastely() {
        korSzamol();
        leiras("A várudvaron állsz. Nyugatra nyitott kamrát, északra zárt "
                + "ajtót látsz. Egy széles lépcső vezet fel a vártemplomhoz");

        System.out.println("Mit teszel? (Lehetőségek: megy)");

        beker();
        if (ige.equals("megy")) {
            System.out.println("Hova mész? (Lehetőségek: kamra, ajto, lepcso)");
            megy();
        }

        if (hely.equals("kamra")) {
            kamra();
        }

        if (hely.equals("ajto")) {
            ajto();
        }
        
        if (hely.equals("lepcso")) {
            vartemplom();
        }
    }

    public void kamra() {
        korSzamol();
        leiras("A kamrában vagy. Egyik oldalon hatalmas asztal áll mindenféle ételekkel,"
                + " a másik oldalon egy nagy tűzhely, szintén ételekkel. Délre egy faajtót látsz.");

        System.out.println("Mit teszel? (Lehetőségek: asztal, tuzhely, ajto)");
        beker();
        if (ige.equals("ajto")) {
            kastely();
        } else if (ige.equals("asztal") || ige.equals("tuzhely")) {
            karakter.setElet(10);
            kor = 0;
            System.out.println("Ettél. Életerőd maxra töltve!");
            eletKiir();
            System.out.println("Mit teszel? (Lehetőségek: ajto)");
            beker();
        }

        if (ige.equals("ajto")) {
            kastely();
        }
    }

    public void ajto() {
        korSzamol();
        leiras("Egy masszív, zárt ajtó előtt állsz.");

        System.out.println("Mit teszel? (Lehetőségek: vissza, kinyit)");
        beker();

        if (ige.equals("kinyit")) {
            if (karakter.getTargyak().contains("kulcs")) {
                System.out.println("Az ajtó kinyílt");
                
            } else {
                System.out.println("Az ajtó zárva");
                System.out.println("Mit teszel? (Lehetőségek: vissza)");
                beker();
            }
        }
        
        if (ige.equals("vissza")) {
            kastely();
        }
    }
    
    public void vartemplom() {
        korSzamol();
        leiras("A templom előtt egy kéregető szerzetes mosolyog rád."
                + " Nyugatra nyitott kamrát, északra zárt ajtót látsz");
        System.out.println("Mit teszel? (Lehetőségek: hasznal, vissza)");
        beker();
        
        if (ige.equals("hasznal")) {
            String targy = hasznal();
            if (targy.equals("penz")) {
                //karakter.targyElvesz("penz");
                System.out.println("A szerzetes megköszönte és adott egy kulcsot!");
                felvesz("kulcs");
                kastely();
            } else {
                System.out.println("Ezt itt nem használhatod.");
                System.out.println("Mit teszel? (Lehetőségek: vissza)");
                beker();
            }
            
        }
        
        if (ige.equals("vissza")) {
            kastely();
        }
        
    }

}
