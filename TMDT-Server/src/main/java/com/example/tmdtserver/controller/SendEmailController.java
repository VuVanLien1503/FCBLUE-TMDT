package com.example.tmdtserver.controller;

import com.example.tmdtserver.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/sendEmail")
public class SendEmailController {
    @Autowired
    private EmailService emailService;

    @GetMapping()
    public ResponseEntity<Void> sendEmail(
            @RequestParam("to") String to,
            @RequestParam("subject") String subject,
            @RequestParam("text") String text) {
        emailService.sendMail(to, subject, text);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
