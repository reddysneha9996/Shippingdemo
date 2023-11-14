package com.demo.shipping.controller;

import java.util.List;

import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.shipping.exception.ApiException;
import com.demo.shipping.model.ShippingRequest;
import com.demo.shipping.model.ShippingResponse;
import com.demo.shipping.service.PdfGenerationService;
import com.demo.shipping.service.ShippingService;

@Controller
public class ShippingController {

    private ShippingService shippingService;
    private PdfGenerationService pdfGenerationService;
    private ShippingResponse selectedShippingOption;     

    public ShippingController(ShippingService shippingService) {
        this.shippingService = shippingService;
		this.pdfGenerationService = new PdfGenerationService();
    }

    @RequestMapping("/shipping")
    public String showShippingForm(Model model) {
    	try {
    		model.addAttribute("shippingRequest", new ShippingRequest());
    		return "shipping";
    	} catch (ApiException e) {
    		throw e;
        } catch (Exception e) {
            throw new ApiException("An unexpected error occurred.");
        }    		
    }

    @PostMapping("/getRates")
    public String getRates(ShippingRequest shippingRequest, Model model) {
    	try {
	        List<ShippingResponse> shippingOptions = shippingService.getShippingRates(shippingRequest);
	        model.addAttribute("shippingOptions", shippingOptions);
	        return "shipping";
    	} catch (ApiException e) {
    		throw e;
        } catch (Exception e) {
            throw new ApiException("An unexpected error occurred.");
        }
    }

    @PostMapping("/proceed")
    public String proceed(@RequestParam("selectedOption") int selectedOptionIndex, Model model) {
        try {
            //selectedShippingOption = shippingService.getShippingOptions().get(selectedOptionIndex);
            //model.addAttribute("selectedShippingOption", selectedShippingOption);

            return "shippingDetails"; // A new template to display details and provide PDF download button
        } catch (Exception e) {
            // Log the exception
            e.printStackTrace(); // Replace with your logging framework

            // Add an error message and redirect to an error page or handle appropriately
            model.addAttribute("error", "An error occurred while processing the selected shipping option.");
            return "error"; // Custom error page
        }
    }

    @GetMapping("/downloadPdf")
    public ResponseEntity<byte[]> downloadPdf() {
        try {
            byte[] pdfBytes = pdfGenerationService.generatePdf(selectedShippingOption);

            HttpHeaders headers = new HttpHeaders();

            headers.setContentDisposition(ContentDisposition.builder("inline").filename("shipping_label.pdf").build());

            return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
        } catch (Exception e) {
            // Log the exception
            e.printStackTrace(); // Replace with your logging framework

            // Handle the exception, add an error message, and redirect to an error page or handle appropriately
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}

