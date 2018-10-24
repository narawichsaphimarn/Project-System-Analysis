package com.G18.SA.NS.repository;

import com.G18.SA.NS.entity.RelatedInformationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface RelatedInformationRepository extends JpaRepository<RelatedInformationEntity, Long>{
    // RelatedInformationEntity findByrelatedinformationName(String relatedinformationName);
}
