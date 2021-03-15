package org.ipo.rwa.reactive.userservice.controller;

import org.ipo.rwa.reactive.userservice.bean.UserBean;
import org.ipo.rwa.reactive.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(final UserService userService) {
        super();
        this.userService = userService;
    }

    @GetMapping(value = "/users",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<UserBean> getUsers() {
        return this.userService.getUsers();
    }

    @GetMapping(value = "/user/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<UserBean>> getUser(@PathVariable("id") final String id) {

        return this.userService.getUserById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping(value = "/saveUser",
            produces = MediaType.APPLICATION_JSON_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<UserBean>> saveUser(@RequestBody final UserBean userBean) {
        return this.userService.saveUser(userBean).map(ResponseEntity::ok);

    }

    @PutMapping(value = "/updateUser",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<UserBean>> updateUser(@RequestBody final UserBean userBean) {

        return this.userService.getUserById(userBean.getId())
                .flatMap(existingUser ->
                        this.userService.updateUser(userBean)
                                .map(ResponseEntity::ok)
                )
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping(value = "/deleteUser/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<UserBean>> deleteUser(@PathVariable("id") final String id) {

        return this.userService.getUserById(id)
                .flatMap(existingUser ->
                        this.userService.deleteUserById(id).then(Mono.just(ResponseEntity.ok(existingUser))
                        ))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
