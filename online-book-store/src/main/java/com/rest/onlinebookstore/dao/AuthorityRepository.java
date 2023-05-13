package com.rest.onlinebookstore.dao;

import com.rest.onlinebookstore.entity.AuthorityId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.rest.onlinebookstore.entity.Authority;

@RepositoryRestResource
public interface AuthorityRepository extends JpaRepository<Authority, AuthorityId> {

}
