package com.dolzanes.presentation.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dolzanes.domain.entity.Payroll;

@RestController
@RequestMapping(value="/api/payments")
public class PayrollController {

    @GetMapping(value="/{workedId}")
    public ResponseEntity<Payroll> getPayment(@PathVariable Long workedId, @RequestBody Payroll payment) {
        return ResponseEntity.ok().body(
        		new Payroll(
        				payment.getWorkerName(),
        				payment.getDescription(),
        				payment.getHourlyPrice(),
        				payment.getWorkedHours(),
        				payment.getHourlyPrice() * payment.getWorkedHours()
        			)
        		);
    }

}