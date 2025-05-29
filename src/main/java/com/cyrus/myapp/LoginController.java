/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.cyrus.myapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author cyrus
 */
@Controller
@RequestMapping("/login") // Base path for login related actions
public class LoginController {
    // @Autowired
    // private final CustomerRepository customerRepository = null; 


    @GetMapping
    public String showLoginForm(Model model) {
        model.addAttribute("login", new Login());
         // Add an empty Login object for form binding
        return "login"; // Return the name of the Thymeleaf template (login.html)
    }

    // @PostMapping
    // public String processLogin(@ModelAttribute("login") Login login, Model model) {
    //     System.out.println("Login attempt with email: " + login.getEmail() + ", password: [PROTECTED]");

    //     Optional<Customer> customerOptional = customerRepository.findByEmail(login.getEmail());


    //     if (customerOptional.isPresent()) {
    //         Customer customer = customerOptional.get();
    //         // !! IMPORTANT: This is plain text password comparison. DO NOT USE IN PRODUCTION.
    //         // In a real app, use a password encoder (e.g., BCryptPasswordEncoder) from Spring Security:
    //         // if (passwordEncoder.matches(login.getPassword(), customer.getPassword())) { ... }
    //         if (customer.getPassword().equals(login.getPassword())) {
    //             // TODO: Store user session information (e.g., using Spring Security Context)
    //             return "redirect:/product/list"; // Redirect to product list on successful login
    //         }
    //     }

    //     model.addAttribute("error", "Invalid email or password");
    //     return "login"; // Return to login page with an error message
    // }
}
