package com.demo.shipping.service;



import java.io.ByteArrayOutputStream;

import org.springframework.stereotype.Service;

import com.demo.shipping.model.ShippingResponse;

//PdfGenerationService.java
@Service
public class PdfGenerationService {

 public byte[] generatePdf(ShippingResponse selectedShippingOption) {
     ByteArrayOutputStream baos = new ByteArrayOutputStream();
     return baos.toByteArray();
 }
}
