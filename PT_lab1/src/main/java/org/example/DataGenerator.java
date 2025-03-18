package org.example;
import java.util.*;
public class DataGenerator {
    public static Set<Mage> generateData(String mode) {
        Set<Mage> elements;
        if (mode.equals("1")) {
            elements = new TreeSet<>();
        } else if (mode.equals("2")) {
            elements = new TreeSet<>(new AlternativeComparator());
        } else {
            elements = new HashSet<>();
        }
        Mage root = new Mage("Merlin", 100, 10000, createSet(mode));
        Mage child1 = new Mage("Bolek", 80, 8000, createSet(mode));
        elements.add(child1);
        Mage child2 = new Mage("Lolek", 80, 8000, createSet(mode));
        elements.add(child2);
        Mage child3 = new Mage("Reksio", 80, 8000, createSet(mode));
        elements.add(child3);
        Mage child1_1 = new Mage("Kasia", 50, 5000, createSet(mode));
        elements.add(child1_1);
        Mage child1_2 = new Mage("Tomek", 45, 4500, createSet(mode));
        elements.add(child1_2);
        Mage child2_1 = new Mage("Franek", 55, 6000, createSet(mode));
        elements.add(child2_1);
        Mage child2_2 = new Mage("Oluremi", 60, 6500, createSet(mode));
        elements.add(child2_2);
        Mage child3_1 = new Mage("Ron", 53, 5300, createSet(mode));
        elements.add(child3_1);
        Mage child3_2 = new Mage("Potter", 30, 3000, createSet(mode));
        elements.add(child3_2);
        child1.addApprentice(child1_1);
        child1.addApprentice(child1_2);
        child1.addApprentice(child3_2);
        child2.addApprentice(child2_1);
        child2.addApprentice(child2_2);
        child1.addApprentice(child3_2);
        child3.addApprentice(child3_1);
        child3.addApprentice(child3_2);
        root.addApprentice(child1);
        root.addApprentice(child2);
        root.addApprentice(child3);
        elements.add(root);
        return elements;
    }

    public static Set<Mage> createSet(String mode){
        if(mode.equals("1")){
            return new TreeSet<>();
        }else if(mode.equals("2")){
            return new TreeSet<>(new AlternativeComparator());
        }else{
            return new HashSet<>();
        }
    }
}
