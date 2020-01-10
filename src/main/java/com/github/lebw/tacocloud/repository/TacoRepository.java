package com.github.lebw.tacocloud.repository;

import com.github.lebw.tacocloud.domain.Taco;

/**
 * @author LBW
 */
public interface TacoRepository {
    Taco save(Taco taco);
}
