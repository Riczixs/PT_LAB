import java.util.*;

public class Pracownik implements Comparable<Pracownik>{
    public Pracownik(String imie, int rok_zatrudnienia, int poziom, Set<Pracownik> podwladni){
        this.imie= imie;
        this.rok_zatrudnienia=rok_zatrudnienia;
        this.poziom=poziom;
        this.podwladni = podwladni;
    }
    private final String imie;
    private final int rok_zatrudnienia;
    private final int poziom;
    private final Set<Pracownik> podwladni;



    public void dodajPracownika(Pracownik p){
        this.podwladni.add(p);
    }

    public String getImie(){
        return imie;
    }

    public int getRok_zatrudnienia() {
        return rok_zatrudnienia;
    }

    public Set<Pracownik> getPodwladni() {
        return podwladni;
    }

    public int getPoziom() {
        return poziom;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pracownik pracownik = (Pracownik) o;
        return rok_zatrudnienia == pracownik.rok_zatrudnienia && poziom == pracownik.poziom && Objects.equals(imie, pracownik.imie) && Objects.equals(podwladni, pracownik.podwladni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imie, rok_zatrudnienia, poziom, podwladni);
    }

    @Override
    public String toString() {
        return "Pracownik{" +
                "imie='" + imie + '\'' +
                ", rok_zatrudnienia=" + rok_zatrudnienia +
                ", poziom=" + poziom +
                ", podwladni=" + podwladni +
                '}';
    }

    public void printStructure(String prefix){
        prefix = prefix+"\t-";
        System.out.println(prefix+this);
        for(Pracownik p : podwladni){
            p.printStructure(prefix);
        }
    }
    @Override //metoda porównująca dwa obiekty
    public int compareTo(Pracownik p) {
        int order = imie.compareTo(p.imie);
        if(order != 0){
            return order;
        }
        order = Integer.compare(rok_zatrudnienia, p.rok_zatrudnienia);
        if(order != 0){
            return order;
        }
        order = Double.compare(poziom, p.poziom);
        if(order != 0){
            return order;
        }
        return 0;
    }


}
