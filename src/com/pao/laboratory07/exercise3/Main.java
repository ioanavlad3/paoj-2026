import com.pao.laboratory07.exercise3.Comanda;
import com.pao.laboratory07.exercise3.ComandaRedusa;
import com.pao.laboratory07.exercise3.ComandaGratuita;
import com.pao.laboratory07.exercise3.ComandaStandard;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Comanda> comenzi = new ArrayList<>();

        if (!sc.hasNextLine()) return;
        int n = Integer.parseInt(sc.nextLine().trim());

        for (int i = 0; i < n; i++) {
            parseAndAddOrder(sc.nextLine(), comenzi);
        }
        comenzi.forEach(c -> System.out.println(c.descriere()));


        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;

            String[] tokens = line.split(" ");
            String command = tokens[0].toUpperCase();

            switch (command) {
                case "STATS":
                    printStats(comenzi);
                    break;

                case "FILTER":
                    double minPrice = Double.parseDouble(tokens[1]);
                    System.out.println("\n---------FILTERED (Price > " + minPrice + ")--------");
                    comenzi.stream()
                            .filter(c -> c.pretFinal() > minPrice)
                            .forEach(c -> System.out.println(c.descriere()));
                    break;

                case "SORT":
                    System.out.println("\n---- SORT (by client, then by pret) ---");
                    comenzi.sort(Comparator.comparing(Comanda::getClient)
                            .thenComparing(Comanda::pretFinal));
                    comenzi.forEach(c -> System.out.println(c.descriere()));
                    break;

                case "SPECIAL":
                    System.out.println("\n---- SPECIAL (Discount > 15%) ---");
                    comenzi.stream()
                            .filter(c -> c instanceof ComandaRedusa && ((ComandaRedusa) c).getDiscount() > 15)
                            .forEach(c -> System.out.println(c.descriere()));
                    break;

                case "QUIT":
                    return;
            }
        }
    }

    private static void parseAndAddOrder(String line, List<Comanda> list) {
        String[] tokens = line.trim().split(" ");
        if (tokens.length == 0) return;

        switch (tokens[0]) {
            case "STANDARD" -> list.add(new ComandaStandard(tokens[1], Double.parseDouble(tokens[2]), tokens[3]));
            case "DISCOUNTED" -> list.add(new ComandaRedusa(tokens[1], Double.parseDouble(tokens[2]), tokens[4], Integer.parseInt(tokens[3])));
            case "GIFT" -> list.add(new ComandaGratuita(tokens[1], tokens[2]));
        }
    }

    private static void printStats(List<Comanda> comenzi) {
        System.out.println("\n---------STATS--------");
        double medieS = comenzi.stream().filter(c -> c instanceof ComandaStandard)
                .mapToDouble(Comanda::pretFinal).average().orElse(0);
        double medieD = comenzi.stream().filter(c -> c instanceof ComandaRedusa)
                .mapToDouble(Comanda::pretFinal).average().orElse(0);

        if (medieS > 0) System.out.printf("STANDARD: medie = %.2f lei\n", medieS);
        if (medieD > 0) System.out.printf("DISCOUNTED: medie = %.2f lei\n", medieD);
        System.out.println("GIFT: medie = 0.00 lei");
    }
}