/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.cyrus.myapp;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author cyrus
 */
public interface  CustomerRepository extends  JpaRepository<Customer, Long>
{

    // Method to find a customer by their email
    Optional<Customer> findByEmail(String email);

}
