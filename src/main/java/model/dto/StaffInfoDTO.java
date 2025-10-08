package model.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StaffInfoDTO {

    private String staffId;

    private String name;

    private String role;

    private String email;

    private String phoneNumber;

    private double salary;
}
