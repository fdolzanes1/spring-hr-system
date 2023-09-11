package com.dolzanes.domain.service;

import java.util.Objects;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.dolzanes.domain.entity.Payroll;
import com.dolzanes.domain.exception.ObjectNotFoundException;
import com.dolzanes.domain.feign.UserFeign;

import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service
public class PayrollService {
	
	private final Environment env;
	private final UserFeign feign;
	public Payroll getPayment(Long workerId, Payroll payment) {
		
		log.info("PAYROLL_SERVICE ::: Get Request on "+ env.getProperty("local.server.port")+" port.");
		
		try {
			var user = feign.findById(workerId).getBody();
			if(Objects.nonNull(user)) {
				return new Payroll(
        				user.getName(),
        				payment.getDescription(),
        				user.getHourlyPrice(),
        				payment.getWorkedHours(),
        				user.getHourlyPrice() * payment.getWorkedHours()
        			);
			}
		} catch (FeignException.NotFound error) {
			throw new ObjectNotFoundException("Object Not Found");
		} catch (Exception error) {
			throw new IllegalArgumentException("Illegal Argument Exception");
		}
		
		return null; 
	}
}
