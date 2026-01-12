package zona_fit.ui;

import zona_fit.datos.ClienteDAO;
import zona_fit.datos.IClienteDAO;
import zona_fit.domain.Client;

import java.util.Scanner;

public class ZonaFitApp {
    public static void main(String[] args) {
        zonaFitApp();
    }

    private static void zonaFitApp() {
        var exit = false;
        var sc = new Scanner(System.in);
        IClienteDAO clienteDao = new ClienteDAO();
        while (!exit) {
            try {
                int option = showMenu(sc);
                exit = executeOption(option,sc, clienteDao);

            } catch (Exception e) {
                System.out.println("Error while show options");
            }
            System.out.println();
        }
    }

    private static int showMenu(Scanner sc) {
        System.out.println("\n*********** MENU ZONA FIT **********\n");
        System.out.println("1. List clients");
        System.out.println("2. Search client");
        System.out.println("3. Add client");
        System.out.println("4. Update client");
        System.out.println("5. Delete client");
        System.out.println("6. Exit");
        System.out.print("Choose an option: ");
        return Integer.parseInt(sc.nextLine());
    }

}
