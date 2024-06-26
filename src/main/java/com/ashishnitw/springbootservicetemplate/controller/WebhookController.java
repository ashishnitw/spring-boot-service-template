package com.ashishnitw.springbootservicetemplate.controller;

import com.ashishnitw.springbootservicetemplate.service.WebhookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class WebhookController {

    private final WebhookService webhookService;

    @PostMapping("/webhook")
    ResponseEntity<Object> webhook(@RequestBody Object request) {
        try {
            webhookService.webhook(request);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
        return ResponseEntity.ok("success");
    }

    @PostMapping("/webhook/bulk")
    ResponseEntity<Object> webhookBulk(@RequestBody Object request) {
        try {
            webhookService.webhookBulk(request);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
        return ResponseEntity.ok("success");
    }
}
