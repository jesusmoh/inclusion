
package core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import core.exception.AppException;
import core.model.dto.in.RequestKDTO;
import core.model.dto.out.ResultKDTO;
import core.service.validator.IRequestKDTOValidatorService;

/**
 *
 * @author JOrtiz
 */

@Service
public class MathServiceImp implements IMathService {

    @Autowired
    @Qualifier("requestKDTOValidatorServiceImp")
    private IRequestKDTOValidatorService requestKDTOValidatorServiceImp;

    @Override
    public ResultKDTO findTheMaximumIntegerK(RequestKDTO dto) {

        var rv = requestKDTOValidatorServiceImp.validate(dto);
        if (rv.isValid()) {
            final int x = dto.getX();
            final int y = dto.getY();
            final int n = dto.getN();

            final int k = (n - y) / x * x + y;
            System.out.println("For test case " + x + " " + n + " " + y + ": Maximum k = " + k);
            return new ResultKDTO(k);
        } else {
            throw new AppException(rv.getResult(), true);
        }

    }

}
