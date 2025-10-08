package model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerInfoDTO {

    private String customerId;

    private String name;

    private int age;

    private String phoneNumber;

    private String city;
}
