package com.helloworld.crud;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

@RestController
@RequestMapping("/user")
public class UserRestController {
    private final UserRepository userRepository;

    @Inject
    public UserRestController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/all")
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @PostMapping("/create-or-update")
    public User createOrUpdate(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PostMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam("id") Long id) {
        userRepository.deleteById(id);
        return ResponseEntity.ok("user removed from db");
    }

}
