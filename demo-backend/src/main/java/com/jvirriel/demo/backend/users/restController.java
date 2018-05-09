package com.jvirriel.demo.backend.users;

import com.jvirriel.demo.backend.bus.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/check")
public class restController {
    @Autowired
    private Producer producer;

    private static int count = 0;

    @GetMapping
    public String check() {
        producer.send("topico1","Epa Virriel ".concat(Integer.toString(++count)));

        return "Hola Mundo!";
    }
}
