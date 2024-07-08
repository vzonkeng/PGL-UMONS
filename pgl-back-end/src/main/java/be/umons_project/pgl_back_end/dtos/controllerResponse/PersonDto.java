package be.umons_project.pgl_back_end.dtos.controllerResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonDto {

    private String FirstName;
    private String LastName;
    private String address;
    private String Role;
    private String inscriptionDate;
    private String password;
}
