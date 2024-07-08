package be.umons_project.pgl_back_end.dtos.controllerResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MetaDto {
    public int statusCode;
    public String statusDescription;
    public String message;
}
