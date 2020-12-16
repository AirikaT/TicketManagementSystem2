package services;

import model.Client;
import repository.ClientDao;
import java.util.Scanner;

public class ClientMain {

    public static Client enterClient() {
        Client newClient = new Client();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Give first name: ");
        newClient.setFirstName(scanner.nextLine());

        System.out.println("Give last name: ");
        newClient.setLastName(scanner.nextLine());

        System.out.println("Give email: ");
        newClient.setEmail(scanner.nextLine());

        ClientDao clientDao = new ClientDao();
        clientDao.createClient(newClient);

       System.out.println("The new client is: " + newClient.getFirstName() + " " + newClient.getLastName() + ", " + newClient.getEmail());

       return newClient;

    }
}