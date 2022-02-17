package com.example.demo.service;

import com.example.demo.model.korisnik.Korisnik;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    KorisnikService korisnikService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Korisnik korisnik = null;
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        try {
            korisnik = korisnikService.getOne(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (korisnik == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        } else {
            return new org.springframework.security.core.userdetails.User(korisnik.getEmail(), korisnik.getLozinka(), authorities);
        }
    }
}
