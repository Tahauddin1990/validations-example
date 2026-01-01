package com.tahauddin.syed.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tahauddin.syed.dto.PrepaidCardRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class PrepaidCardController {

    private final ObjectMapper objectMapper;

    @PostMapping("/createCard")
    public ResponseEntity<PrepaidCardRequest> createCard(@RequestBody @Valid PrepaidCardRequest prepaidCardRequest) {
        try {
            log.info("Prepaid Card Request is :: {}", objectMapper.writeValueAsString(prepaidCardRequest));
        } catch (Exception e) {
            log.info("Exception while processing Create Card :: {}",e.getMessage());
        }
        return ResponseEntity.ok(prepaidCardRequest);
    }

    @PostMapping("/createCardTest2")
    public ResponseEntity<PrepaidCardRequest> createCardTest2(@RequestBody @Valid PrepaidCardRequest prepaidCardRequest) {
        try {
            log.info("Prepaid Card Request is :: {}", objectMapper.writeValueAsString(prepaidCardRequest));
        } catch (Exception e) {
            log.info("Exception while processing Create Card :: {}",e.getMessage());
        }
        return ResponseEntity.ok(prepaidCardRequest);
    }

}
