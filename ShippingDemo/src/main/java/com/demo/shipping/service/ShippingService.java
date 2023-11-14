package com.demo.shipping.service;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;
import org.springframework.web.client.RestTemplate;

import com.demo.shipping.model.ShippingRequest;
import com.demo.shipping.model.ShippingResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ShippingService {

    @Value("${custom.api.endpoint}")
    private String apiEndpoint;

    private final ObjectMapper objectMapper;

    @Value("${custom.api.username}")
    private String username;

    @Value("${custom.api.password}")
    private String password;

    public ShippingService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public List<ShippingResponse> getShippingRates(ShippingRequest shippingRequest) {
        // Set up headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        // Set up Basic Authentication
        String credentials = username + ":" + password;
        String authHeader = "Basic " + Base64Utils.encodeToString(credentials.getBytes(StandardCharsets.UTF_8));
        headers.set(HttpHeaders.AUTHORIZATION, authHeader);

        try {
            // Convert the ShippingRequest object to JSON string
            String requestBody = objectMapper.writeValueAsString(shippingRequest);

            // Set up the request entity with the JSON request body and headers
            HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

            // Make the POST request to the new endpoint with Basic Authentication
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<ShippingResponse[]> responseEntity = restTemplate.postForEntity(apiEndpoint, requestEntity, ShippingResponse[].class);

            // Convert the array to a list
            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                ShippingResponse[] responseArray = responseEntity.getBody();
                return Arrays.asList(responseArray);
            } else {
                // Handle non-successful response
                return null;
            }
        } catch (JsonProcessingException e) {
            // Handle JSON processing exception
            e.printStackTrace();
            return null;
        }
    }

    // Implement other methods for subsequent steps
}


/*
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.demo.shipping.model.ShippingRequest;
import com.demo.shipping.model.ShippingResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper; 
import com.fasterxml.jackson.databind.ObjectWriter; 

@Service
public class ShippingService {

    @Value("${custom.api.endpoint}")  // You can use properties or configuration files to store the endpoint URL
    private String apiEndpoint;

    public List<ShippingResponse> getShippingRates(ShippingRequest shippingRequest) {
        String json = null;
    	// Set up headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        System.out.println("API End: " + apiEndpoint);
        System.out.println("Shpiing request: " + shippingRequest.toString());
        
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        try {
			json = ow.writeValueAsString(shippingRequest);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        // Set up the request entity
        HttpEntity<String> requestEntity = new HttpEntity<>(json, headers);
        
        System.out.println("JSON: " + json);
        
        // Make the POST request to the new endpoint
        RestTemplate restTemplate = new RestTemplate();
        ShippingResponse[] responseArray = restTemplate.postForObject(apiEndpoint, requestEntity, ShippingResponse[].class);

        // Convert the array to a list
        if (responseArray != null) {
            return Arrays.asList(responseArray);
        } else {
            // Handle null or empty response
            return null;
        }
    }

    // Implement other methods for subsequent steps
}
*/