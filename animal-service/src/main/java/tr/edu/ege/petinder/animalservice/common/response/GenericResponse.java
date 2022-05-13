package tr.edu.ege.petinder.animalservice.common.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenericResponse {
    private String message;

    public GenericResponse(String message){
        this.message = message;
    }
}
