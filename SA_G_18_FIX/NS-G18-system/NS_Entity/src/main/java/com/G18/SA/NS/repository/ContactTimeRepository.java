package com.G18.SA.NS.repository;

import com.G18.SA.NS.entity.ContactTimeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface ContactTimeRepository extends JpaRepository<ContactTimeEntity, Long>{
    ContactTimeEntity findBycontactTimeName(String contactTimeName);
}
