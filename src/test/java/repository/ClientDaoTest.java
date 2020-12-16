package repository;

import model.Client;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class ClientDaoTest {

    @BeforeEach
    public void insertingData() {
        Client client = new Client("Luna", "Lovegood", "looney@hogwarts.com");

    }

    @Test()
    @DisplayName("SavingClient")
    public void checkCreateClient() {

    }
}
