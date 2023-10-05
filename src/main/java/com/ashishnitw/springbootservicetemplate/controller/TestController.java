package com.ashishnitw.springbootservicetemplate.controller;

import com.ashishnitw.springbootservicetemplate.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class TestController {

    private final TestService testService;

    @PostMapping()
    ResponseEntity<Object> save(@RequestBody String data) {
        Object response = testService.save(data);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{id}")
    ResponseEntity<Object> get(@PathVariable long id) {
        try {
            return ResponseEntity.ok().body(testService.get(id));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Something went wrong!");
        }
    }
}
