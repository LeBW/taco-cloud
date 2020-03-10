package com.github.lebw.tacocloud.repository;

import com.github.lebw.tacocloud.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @author LBW
 */
public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);
}
