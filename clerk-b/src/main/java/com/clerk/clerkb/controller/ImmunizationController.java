package com.clerk.clerkb.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;

public class ImmunizationController {

    @GetMapping("/report/{from}/{until}")
    public ResponseEntity<String> getImmunizationReport(@PathVariable Date from, @PathVariable Date until){

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/update-quantity/{newQuantity}")
    public ResponseEntity<String> setNewQuantity(@PathVariable int newQuantity){

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
