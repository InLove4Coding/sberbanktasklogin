package com.kuzmin.evgenii.sberbanktaskspringsecurity.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/v1/app")
public class MainController {


    @PostMapping(path = "/auth/login")
    public void login() {

    }
  
    @PostMapping(path = "/auth/logout/{sessionId}")
    public void login(@PathVariable String sessionId) {

    }


}
