
package core.service;

import core.model.dto.in.RequestKDTO;
import core.model.dto.out.ResultKDTO;

/**
 *
 * @author JOrtiz
 */
public interface IMathService {

    ResultKDTO findTheMaximumIntegerK(RequestKDTO dto);

}
