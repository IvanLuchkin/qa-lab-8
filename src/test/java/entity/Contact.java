package entity;

import lombok.Data;

@Data
public class Contact {
    private Long id;
    private Long userId;
    private String email;
    private String city;
    private Long phoneNumber;
}
