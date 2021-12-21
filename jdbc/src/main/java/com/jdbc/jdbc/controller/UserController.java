package com.jdbc.jdbc.controller;

import java.util.List;

import com.jdbc.jdbc.dao.UserDao;
import com.jdbc.jdbc.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserDao userDao;

    @PostMapping("/add")
    public ResponseEntity<?> addUser(@RequestBody User user) {
        if (user == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } else {
            this.userDao.insertData(user);
            return ResponseEntity.status(HttpStatus.OK).body("successfully added");
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody User user, @PathVariable int id) {
        if (id == 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            user.setId(id);
            this.userDao.update(user);
            return ResponseEntity.status(HttpStatus.OK).body("successfully updated");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable int id) {
        // List<User> users = this.userDao.getAllUser();
        // User user = users.stream().filter(e -> e.getId() == id).findFirst().get();

        User user = this.userDao.getUser(id);

        return ResponseEntity.status(HttpStatus.FOUND).body(user);

    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUser() {
        List<User> users = this.userDao.getAllUser();
        if (users.size() <= 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.status(HttpStatus.FOUND).body(users);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {

        int user = this.userDao.delete(id);
        if (user == 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {

            return ResponseEntity.status(HttpStatus.OK).body("deleted");
        }
    }
}
