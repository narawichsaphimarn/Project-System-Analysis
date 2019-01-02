package com.G18.SA.NS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.G18.SA.NS.entity.AgencyTypeEntity;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface AgencyTypeRepository extends JpaRepository<AgencyTypeEntity , Long>{
    AgencyTypeEntity findByagencyName(String agencyName);
}
