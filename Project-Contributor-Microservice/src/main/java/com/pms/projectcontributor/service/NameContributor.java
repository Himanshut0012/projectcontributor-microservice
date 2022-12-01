package com.pms.projectcontributor.service;

import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NameContributor {

    private static final String EMPLOYEE_SERVICE="employeeService";

    @Autowired
    private  RestTemplate restTemplate;

    @CircuitBreaker(name = "EMPLOYEE_SERVICE",fallbackMethod = "getFallBackProjectContributorName")
    public String getProjectContributorName(int contributorId){
        return this.restTemplate.getForObject("http://employee-microservice/api/v1/employee/find/"+contributorId, String.class);
    }

    public String getFallBackProjectContributorName(int contributorId, CallNotPermittedException e){
        return "service down";
    }

    public String getFallBackProjectContributorName(int contributorId , Exception e){
        return  "service down";
    }


}
