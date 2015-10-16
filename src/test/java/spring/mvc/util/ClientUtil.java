package spring.mvc.util;

import spring.mvc.entity.BankEntity;
import spring.mvc.entity.ClientEntity;

/**
 * Created by Денис on 28.02.2015.
 */
public class ClientUtil {

    public static ClientEntity createClient(String firstName, String lastName, String phoneNumber,
                                      String address, String email) {
        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setFirstName(firstName);
        clientEntity.setLastName(lastName);
        clientEntity.setPhoneNumber(phoneNumber);
        clientEntity.setAddress(address);
        clientEntity.setEmail(email);

        return clientEntity;
    }

}