package core.service.validator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import core.model.ValidateResultDTO;
import core.model.dto.in.RequestKDTO;

@Service
public class RequestKDTOValidatorServiceImp implements IRequestKDTOValidatorService {

    @Value("${validator.sms}")
    private String sms;

    @Override
    public ValidateResultDTO validate(RequestKDTO dto) {
        var r = new ValidateResultDTO();
        if (dto != null && dto.getY() != null && dto.getX() != null && dto.getN() != null) {
            r = new ValidateResultDTO(true, "ok");
        } else {
            r = new ValidateResultDTO(false, sms);
        }
        return r;
    }

}
