package com.jvirriel.demo.backend.demo;

import com.jvirriel.demo.model.demo.Demo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/demo")
public class DemoController {
    @GetMapping("")
    public List<Demo> getAll() {
        return new ArrayList<>();
    }

    @GetMapping("/{id}")
    public Demo get(@PathVariable Long id) {
        return new Demo();
    }

    @PostMapping("")
    public void save(@RequestBody Demo demo) {

    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Demo demo) {

    }

    @DeleteMapping("/{ids}")
    public void delete(@PathVariable List<Long> ids) {

    }
}
