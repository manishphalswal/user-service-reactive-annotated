package org.ipo.rwa.reactive.userservice.dao;

import org.ipo.rwa.reactive.userservice.bean.UserBean;
import org.ipo.rwa.reactive.userservice.entity.User;
import org.ipo.rwa.reactive.userservice.util.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.util.stream.Collectors;

@Service
public class UserDAOWrapper {
    private IUserRepository userRepository;

    Scheduler userDAOWrapperPublisher = Schedulers.newParallel("userDAOWrapperPublisher", 4);

    @Autowired
    public UserDAOWrapper(final IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Flux<UserBean> getUsers() {
        return this.userRepository.findAll()
                .publishOn(userDAOWrapperPublisher)
                .map(this::convertEntityToBean);
    }

    public Mono<UserBean> getUserById(final String id) {
        return this.userRepository.findById(id)
                .publishOn(userDAOWrapperPublisher)
                .map(this::convertEntityToBean);
    }

    public Mono<UserBean> saveUser(final UserBean userBean) {
        return this.userRepository.save(convertBeanToEntity(userBean))
                .publishOn(userDAOWrapperPublisher)
                .map(this::convertEntityToBean);
    }

    public Mono<UserBean> updateUser(final UserBean userBean) {
        return this.userRepository.save(convertBeanToEntity(userBean))
                .publishOn(userDAOWrapperPublisher)
                .map(this::convertEntityToBean);
    }

    public Mono<Void> deleteUserById(final String id) {
        return this.userRepository.deleteById(id);
    }

    private User convertBeanToEntity(final UserBean userBean) {
        User user = new User();
        System.out.println("Received Document with Details: " + userBean);

        BeanUtils.copyUserProperties(userBean, user);

        System.out.println("Saving Document with Details: " + user);
        return user;
    }

    private UserBean convertEntityToBean(final User user) {
        UserBean userBean = new UserBean();
        System.out.println("Found Document with Details: " + user);

        BeanUtils.copyUserProperties(user, userBean);

        System.out.println("Returning Document with Details: " + userBean);
        return userBean;
    }
}
