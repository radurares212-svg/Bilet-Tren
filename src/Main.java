import java.time.LocalTime;
import java.util.Arrays;
import java.util.Scanner;
import model.*;
import service.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ServiciuTren serviciuTren = new ServiciuTren();
        ServiciuBilete serviciuBilete = new ServiciuBilete();

        // 1. Populăm baza de date cu câteva trenuri de test
        serviciuTren.adaugaTren(new Tren("IR1742", Arrays.asList(
                new Statia("Bucuresti", LocalTime.now().plusMinutes(10)),
                new Statia("Ploiesti", LocalTime.now().plusMinutes(40)),
                new Statia("Sinaia", LocalTime.now().plusMinutes(70))
        )));

        serviciuTren.adaugaTren(new Tren("R3001", Arrays.asList(
                new Statia("Brasov", LocalTime.now().plusMinutes(15)),
                new Statia("Predeal", LocalTime.now().plusMinutes(45)),
                new Statia("Sinaia", LocalTime.now().plusMinutes(80))
        )));

        // 2. Afișăm trenurile disponibile
        System.out.println("--- Trenuri Disponibile ---");
        for (Tren t : serviciuTren.getTrenuri()) {
            System.out.println("- " + t.getNume() + " (Ruta: " + t.getStatii().get(0).getNume() + " -> " + t.getStatii().get(t.getStatii().size()-1).getNume() + ")");
        }

        // 3. Alegerea utilizatorului
        System.out.print("\nIntroduceți numele trenului dorit: ");
        String numeTrenAles = scanner.nextLine();
        
        Tren trenAles = serviciuTren.gasesteTrenDupaNume(numeTrenAles);

        if (trenAles != null) {
            System.out.println("Ați ales: " + trenAles);
            System.out.print("Stație plecare: ");
            String plecare = scanner.nextLine();
            System.out.print("Stație destinație: ");
            String destinatie = scanner.nextLine();
            
            Calator calator = new Calator("Maria Ionescu");

            try {
                Bilet b = serviciuBilete.cumparaBilet(calator, trenAles, plecare, destinatie, TipRezervare.CU_LOC);
                System.out.println("\nSucces! Detalii bilet:");
                System.out.println(b);
            } catch (Exception e) {
                System.out.println("\nEroare la cumpărare: " + e.getMessage());
            }
        } else {
            System.out.println("Trenul " + numeTrenAles + " nu a fost găsit.");
        }
        
        scanner.close();
    }
}