package com.bamons2.monitoring.process.member.dao;

import com.bamons2.monitoring.process.member.domain.Authority;
import com.bamons2.monitoring.process.member.domain.Member;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by david100gom on 2017. 8. 29.
 *
 * Github : https://github.com/david100gom
 */
public interface AuthorityRepository extends CrudRepository<Authority, Integer> {

    List<Authority> findByUsername(String username);

}