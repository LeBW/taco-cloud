package com.github.lebw.tacocloud.repository;

import com.github.lebw.tacocloud.domain.Taco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author LBW
 */
public interface TacoRepository extends CrudRepository<Taco, Long> {
//    Taco save(Taco taco);
}
