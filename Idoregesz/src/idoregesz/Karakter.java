package idoregesz;

import java.util.ArrayList;

public class Karakter {
    private int elet;
    private ArrayList<String> targyak;
    
    public Karakter(int elet, ArrayList<String> targyak) {
        this.elet = elet;
        this.targyak = targyak;
    }
    
    public void felvesz(String targy) {
        targyak.add(targy);
    }

    public void eletCsokkent() {
        this.elet -= 1;
    }

    public void setElet(int elet) {
        this.elet = elet;
    }

    public int getElet() {
        return elet;
    }

    public ArrayList<String> getTargyak() {
        return targyak;
    }
    
    public void targyElvesz(String targy) {
        this.targyak.remove(targy);
    }
    
    
    
    
    
    
    
    
}
