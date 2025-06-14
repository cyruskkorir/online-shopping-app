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
public interface  LoginRepository extends JpaRepository<Login, Long>{
    Optional<Login> findByEmail(String email);
}
