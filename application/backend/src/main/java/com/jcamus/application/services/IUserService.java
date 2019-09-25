/**
 * 
 */
package com.jcamus.application.services;

import java.util.List;
import java.util.Map;

/**
 * @author camusj
 *
 */
public interface IUserService<T, ID extends Long> {
	List<T> findAll();

    T findById(ID id);

    <S extends T> List<S> saveAll(Iterable<S> var1);

    <S extends T> S save(S var1);

    T delete(ID var1);

    /**
     * @return {@code Map} of users by groupId
     */
    Map<String, List<T>> findAllGroupByGroupId();
}
