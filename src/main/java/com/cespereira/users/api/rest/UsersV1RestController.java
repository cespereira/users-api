package com.cespereira.users.api.rest;

import com.cespereira.users.api.entity.UserEntity;
import com.cespereira.users.api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
public class UsersV1RestController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserEntity>> getAll() {
        final var found = this.userService.findAll();
        return ResponseEntity.ok(found);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> findById(@PathVariable("id") final Long id) {
        final var found = this.userService.find(id);
        return ResponseEntity.ok(found);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserEntity> deleteById(@PathVariable("id") final Long id) {
        this.userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<UserEntity> save(@RequestBody final UserEntity user) {
        final var persisted = this.userService.save(user);
        return ResponseEntity.ok(persisted);
    }



}
