package core.service.validator;

import core.model.ValidateResultDTO;
import core.model.dto.in.RequestKDTO;

public interface IRequestKDTOValidatorService {
    ValidateResultDTO validate(RequestKDTO dto);
}
