package milk.example.platform.client.service.subservice;

import milk.example.platform.client.service.Service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Subservice {
    private Long id;
    private Service service;
    private char name;
    private char lore;
    private short regular_payment_state;

}
