package core.controller.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import core.model.dto.out.ResponseDTO;

@RestController
@RequestMapping("/app")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.OPTIONS })
public class Echo {

    @GetMapping("/echo")
    public ResponseDTO app() {
        return new ResponseDTO("echo", null, HttpStatus.OK);
    }
}
