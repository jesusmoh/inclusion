package core.model.dto.out;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

public class ResponseDTO extends ResponseEntity {

    public ResponseDTO(Object dto, MultiValueMap headers, HttpStatus status) {
        super(dto, headers, status);
    }

    public ResponseDTO(HttpStatus status) {
        super(status);
    }

}