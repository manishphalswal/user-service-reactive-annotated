package org.ipo.rwa.reactive.userservice.service;

import org.ipo.rwa.reactive.userservice.bean.UserBean;
import org.ipo.rwa.reactive.userservice.dao.UserDAOWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class UserService {
    private UserDAOWrapper userDAOWrapper;

    @Autowired
    public UserService(final UserDAOWrapper userDAOWrapper) {
        super();
        this.userDAOWrapper = userDAOWrapper;
    }

    public Flux<UserBean> getUsers() {
        return this.userDAOWrapper.getUsers();
    }

    public Mono<UserBean> getUserById(final String id) {
        return this.userDAOWrapper.getUserById(id);
    }

    public Mono<UserBean> saveUser(final UserBean userBean) {
        return this.userDAOWrapper.saveUser(userBean);
    }

    public Mono<UserBean> updateUser(final UserBean userBean) {
        return this.userDAOWrapper.updateUser(userBean);
    }

    public Mono<Void> deleteUserById(final String id) {
        return this.userDAOWrapper.deleteUserById(id);
    }
}
