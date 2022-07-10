 package com.example.demo.controller;

 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserTokenStateDTO;
import com.example.demo.model.korisnik.Korisnik;
import com.example.demo.security.TokenUtils;
import com.example.demo.service.KorisnikService;


 //Kontroler zaduzen za autentifikaciju korisnika
 @RestController
 @RequestMapping(produces = MediaType.APPLICATION_XML_VALUE, value = "auth")
@CrossOrigin
public class AuthenticationController {

     @Autowired
     private TokenUtils tokenUtils;

     @Autowired
     private AuthenticationManager authenticationManager;

     @Autowired
     private KorisnikService korisnikService;


     // Prvi endpoint koji pogadja korisnik kada se loguje.
     // Tada zna samo svoje korisnicko ime i lozinku i to prosledjuje na backend.
     @PostMapping(value = "/log-in", consumes = MediaType.APPLICATION_XML_VALUE)
     public ResponseEntity<?> createAuthenticationToken(@RequestBody Korisnik korisnik) {
         System.out.println(korisnik.getEmail());
         System.out.println(korisnik.getLozinka());
         System.out.println(korisnik);

         Authentication authentication = authenticationManager
                 .authenticate(new UsernamePasswordAuthenticationToken(korisnik.getEmail(),
                         korisnik.getLozinka()));

         // Ubaci korisnika u trenutni security kontekst
         SecurityContextHolder.getContext().setAuthentication(authentication);

         // Kreiraj token za tog korisnika
         User user = (User) authentication.getPrincipal();
         String jwt = tokenUtils.generateToken(user.getUsername()); // prijavljujemo se na sistem sa email adresom
         int expiresIn = tokenUtils.getExpiredIn();

         UserTokenStateDTO token = new UserTokenStateDTO(jwt);
         // Vrati token kao odgovor na uspesnu autentifikaciju
         return new ResponseEntity<>(token, HttpStatus.OK);
     }

     // Endpoint za registraciju novog korisnika
     @PostMapping("/sign-up")
     public ResponseEntity<?> addUser(@RequestBody Korisnik korisnik) throws Exception {
        System.out.println(korisnik);
         if (korisnikService.create(korisnik)) {
             return new ResponseEntity<>(HttpStatus.CREATED);
         }
         
         return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
     }

//     // U slucaju isteka vazenja JWT tokena, endpoint koji se poziva da se token osvezi
//     @PostMapping(value = "/refresh")
//     public ResponseEntity<UserTokenStateDTO> refreshAuthenticationToken(HttpServletRequest request) {

//         String token = tokenUtils.getToken(request);
//         String username = this.tokenUtils.getUsernameFromToken(token);
//         User user = (User) this.userDetailsService.loadUserByUsername(username);

//         if (this.tokenUtils.canTokenBeRefreshed(token, user.getLastPasswordResetDate())) {
//             String refreshedToken = tokenUtils.refreshToken(token);
//             int expiresIn = tokenUtils.getExpiredIn();

//             UserTokenStateDTO token1 = new UserTokenStateDTO(refreshedToken, expiresIn, user.getId(), user.getAuthorities());

//             return ResponseEntity.ok(token1);
//         } else {
//             UserTokenStateDTO userTokenState = new UserTokenStateDTO();
//             return ResponseEntity.badRequest().body(userTokenState);
//         }
//     }

//     @RequestMapping(value = "/change-password", method = RequestMethod.POST)
//     @PreAuthorize("hasRole('ROLE_USER')")
//     public ResponseEntity<?> changePassword(@RequestBody PasswordChanger passwordChanger) {
//         userDetailsService.changePassword(passwordChanger.oldPassword, passwordChanger.newPassword);

//         Map<String, String> result = new HashMap<>();
//         result.put("result", "success");
//         return ResponseEntity.accepted().body(result);
//     }

//     static class PasswordChanger {
//         public String oldPassword;
//         public String newPassword;
//     }

//     public AuthenticationController() {
//         userMapper = new UserMapper();
//     }
 }
