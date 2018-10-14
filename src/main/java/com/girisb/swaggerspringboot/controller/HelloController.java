package com.girisb.swaggerspringboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import swaggergen.controller.HelloApi;
import swaggergen.model.HelloRequest;
import swaggergen.model.HelloResponse;


@RestController
public class HelloController implements HelloApi {

    @Override
    public ResponseEntity<HelloResponse> hello(@RequestBody final HelloRequest helloRequest) {
        HelloResponse helloResponse = new HelloResponse();
        System.out.println(helloRequest.getUsername());
        helloResponse.setMessage("Hello, " + helloRequest.getUsername() + "!");
        return ResponseEntity.status(HttpStatus.OK).body(helloResponse);
    }

}
