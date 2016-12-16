package com.lehtarec.domain;


import org.springframework.data.repository.CrudRepository;

/**
 * Created by PENGUIN on 01.12.2016.
 */
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
