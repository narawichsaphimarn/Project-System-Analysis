package com.G18.SA.NS.repository;
import com.G18.SA.NS.entity.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestController
@CrossOrigin(origins = "http://localhost:4200")
public interface RelativeRepository extends JpaRepository<Relative, Long> {
    @Query("SELECT t FROM Relative t WHERE t.relativeName = :Name")
    Relative findByRelative(@Param ("Name") String Name);

}