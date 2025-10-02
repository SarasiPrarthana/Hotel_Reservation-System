package model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RoomInfoDTO {

    private String roomId;

    private String type;

    private String description;

    private double price;
}
