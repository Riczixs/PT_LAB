package org.example;
import java.util.*;
public class Mage implements Comparable<Mage> {
    public Mage(String name, int level,double power, Set<Mage> apprentices) {
        this.name = name;
        this.level = level;
        this.power = power;
        this.apprentices = apprentices;
    }
    private final String name; //konstruktor
    private final int level;
    private final double power;
    private final Set<Mage> apprentices;

    public void addApprentice(Mage o){
        this.apprentices.add(o);
    }

    public String getName() {
        return name;
    }
    public int getLevel() {
        return level;
    }
    public double getPower() {
        return power;
    }
    public Set<Mage> getApprentices() {
        return apprentices;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if(o instanceof Mage) {
            Mage mage = (Mage) o;
            if((this.name == mage.getName())&&(this.level == mage.getLevel())&&(this.power == mage.getPower())&&(this.apprentices == mage.getApprentices())) {
                return true;
            }
        }
        return false;
    }
    @Override
    public int hashCode(){
        return Objects.hash(name,level,power,apprentices);
    }

    @Override
    public String toString() {
        return String.format("Mage{name ='%s', level = '%d', power = '%f'}\n", name, level, power);
    }

    public void printStructure(String prefix) {
        prefix = prefix + "-";
        System.out.println(prefix + this); // 📌 Wyświetlamy aktualnego maga
        // 🔹 Wywołujemy `printStructure()` dla każdego ucznia (rekurencyjnie)
        for (Mage apprentice : apprentices) {
            apprentice.printStructure(prefix);
        }
    }


    @Override //metoda porównująca dwa obiekty
    public int compareTo(Mage o) {
        int order = name.compareTo(o.name);
        if(order != 0){
            return order;
        }
        order = Integer.compare(level, o.level);
        if(order != 0){
            return order;
        }
        order = Double.compare(power, o.power);
        if(order != 0){
            return order;
        }
        return 0;
    }

}
