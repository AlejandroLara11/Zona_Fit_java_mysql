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


    private static boolean executeOption(int option, Scanner sc, IClienteDAO clienteDao) {
        var exit = false;
        switch (option) {
            case 1: //List Clientes
                System.out.println("\nClients list\n");
                var clients = new ClienteDAO().clientList();
                clients.forEach(System.out::println);
                break;
            case 2: //Search
                System.out.println("Insert id to search for: ");
                var search = Integer.parseInt(sc.nextLine());
                var client = new Client(search);
                boolean founded = clienteDao.searchClientId(client);
                if (founded) {
                    System.out.println("Client founded! \n" + client);
                }else  {
                    System.out.println("Client id = " + search + " not founded!");
                }
        }
        return exit;
    }

}
