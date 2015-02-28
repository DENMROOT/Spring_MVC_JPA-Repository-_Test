package spring.mvc.util;

import spring.mvc.entity.Bank;
import spring.mvc.entity.Client;

/**
 * Created by Денис on 28.02.2015.
 */
public class ClientUtil {

    public static Client createClient(String firstName, String lastName, String phoneNumber,
                                      String address, String email, Bank bank) {
        Client client = new Client();
        client.setFirstName(firstName);
        client.setLastName(lastName);
        client.setPhoneNumber(phoneNumber);
        client.setAddress(address);
        client.setEmail(email);
        client.setBank(bank);

        return client;
    }

}