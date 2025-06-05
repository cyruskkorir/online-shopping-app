package com.cyrus.myapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author cyrus
 */
@Controller
@RequestMapping("/api")
public class PaymentController {

@PostMapping("/create-checkout-session")
@ResponseBody
public Map<String, String> createCheckoutSession(@RequestBody Map<String, Object> payload) throws StripeException {
    // Stripe.apiKey = "sk_test_..."; // Your secret key

    List<Map<String, Object>> items = (List<Map<String, Object>>) payload.get("cart");
    String customerEmail = (String) payload.get("email");

    List<SessionCreateParams.LineItem> lineItems = new ArrayList<>();
    for (Map<String, Object> item : items) {
        lineItems.add(
            SessionCreateParams.LineItem.builder()
                .setQuantity(((Number) item.get("quantity")).longValue())
                .setPriceData(
                    SessionCreateParams.LineItem.PriceData.builder()
                        .setCurrency("usd")
                        .setUnitAmount(((Number) item.get("price")).longValue() * 100) // cents
                        .setProductData(
                            SessionCreateParams.LineItem.PriceData.ProductData.builder()
                                .setName((String) item.get("name"))
                                .build()
                        )
                        .build()
                )
                .build()
        );
    }

    SessionCreateParams params = SessionCreateParams.builder()
        .addAllLineItem(lineItems)
        .setMode(SessionCreateParams.Mode.PAYMENT)
        .setCustomerEmail(customerEmail)
        .setSuccessUrl("http://localhost:8080/api/success")
        .setCancelUrl("http://localhost:8080/api/cancel")
        .build();

    Session session = Session.create(params);

    return Collections.singletonMap("id", session.getId());
}
@GetMapping("/success")
public String success() {
    return "success";
}
@GetMapping("/cancel")
public String cancel() {
    return "cancel";
}

}
