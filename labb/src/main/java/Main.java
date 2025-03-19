import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Set<Pracownik> set = GenerateData.genData("2");
        Pracownik head = Collections.max(set,Comparator.comparing(Pracownik::getPoziom));
        head.printStructure("");
    }
}