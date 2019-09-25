package com.jcamus.application.repositories;

import java.util.List;
import java.util.Map;

import com.jcamus.application.entities.User;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IUserRepository extends CrudRepository<User, Long> {
    @Query("SELECT u FROM User u group by groupId")
    Map<Long, List<User>> findAllGroupByGroupId();
}
