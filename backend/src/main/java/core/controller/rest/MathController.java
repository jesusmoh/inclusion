
package core.controller.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import core.model.dto.in.RequestKDTO;
import core.model.dto.out.ResponseDTO;
import core.service.IMathService;

/**
 *
 * @author JOrtiz
 */
@RestController
@RequestMapping("/app/service")
@CrossOrigin(origins = "*", methods = { RequestMethod.POST, RequestMethod.OPTIONS })
public class MathController {

  Logger logger = LoggerFactory.getLogger(MathController.class);

  @Autowired
  private IMathService mathService;

  @PostMapping(value = "/findk")
  public ResponseDTO findTheMaximumIntegerK(@RequestBody RequestKDTO dto) {
    logger.info("Arriving numbers...");
    var kdto = mathService.findTheMaximumIntegerK(dto);
    return new ResponseDTO(kdto, null, HttpStatus.OK);
  }
}
