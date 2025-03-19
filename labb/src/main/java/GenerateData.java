import java.util.*;
public class GenerateData {
    public static Set<Pracownik> genData(String mode){
        Set<Pracownik> elements;
        if (mode.equals("1")) {
            elements = new TreeSet<>();
        } else if (mode.equals("2")) {
            elements = new TreeSet<>(new MyComparator());
        } else {
            elements = new HashSet<>();
        }
        Pracownik szef1 = new Pracownik("Jacek", 2000, 20, createSet(mode));
        elements.add(szef1);
        Pracownik szef2 = new Pracownik("Anna", 2500, 5, createSet(mode));
        elements.add(szef2);
        Pracownik szef3 = new Pracownik("Michał", 1800, 7, createSet(mode));
        elements.add(szef3);
        Pracownik szef4 = new Pracownik("Karolina", 3000, 12, createSet(mode));
        elements.add(szef4);
        Pracownik szef5 = new Pracownik("Tomasz", 2200, 8, createSet(mode));
        elements.add(szef5);
        Pracownik szef6 = new Pracownik("Ewa", 2700, 6, createSet(mode));
        elements.add(szef6);
        Pracownik szef7 = new Pracownik("Krzysztof", 1900, 9, createSet(mode));
        elements.add(szef7);
        Pracownik szef8 = new Pracownik("Magda", 2800, 11, createSet(mode));
        elements.add(szef8);
        Pracownik szef9 = new Pracownik("Piotr", 2100, 4, createSet(mode));
        elements.add(szef9);
        Pracownik szef10 = new Pracownik("Aleksandra", 2600, 7, createSet(mode));
        elements.add(szef10);
        //POZIOM1
        szef1.dodajPracownika(szef2);
        szef1.dodajPracownika(szef3);
        szef1.dodajPracownika(szef10);
    //POZIOM2
        szef2.dodajPracownika(szef4);
        szef2.dodajPracownika(szef5);
        szef2.dodajPracownika(szef6);
        szef3.dodajPracownika(szef7);
        szef3.dodajPracownika(szef8);
        szef3.dodajPracownika(szef9);
        return elements;
    }
    public static Set<Pracownik> createSet(String mode){
        if(mode.equals("1")){
            return new TreeSet<>();
        }else if(mode.equals("2")){
            return new TreeSet<>(new MyComparator());
        }else{
            return new HashSet<>();
        }
    }
}
