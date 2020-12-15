package com.polykhel.pcb.config;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.security.Principal;

@RestController
public class TestController {

    @GetMapping("/")
    public ResponseEntity<String> index() {
        return ResponseEntity.ok("Hello");
    }

    @GetMapping("/anonymous")
    public ResponseEntity<String> getAnonymous() {
        return ResponseEntity.ok("Hello Anonymous");
    }

    @GetMapping("/user")
    @RolesAllowed("user")
    public ResponseEntity<String> getUser(Principal principal) {
        System.out.println(principal);
        return ResponseEntity.ok("Hello User");
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('admin')")
    public ResponseEntity<String> getAdmin() {
        return ResponseEntity.ok("Hello Admin");
    }

    @GetMapping("/all-user")
    public ResponseEntity<Principal> getAllUser(Principal principal) {
        return ResponseEntity.ok(principal);
    }
}
