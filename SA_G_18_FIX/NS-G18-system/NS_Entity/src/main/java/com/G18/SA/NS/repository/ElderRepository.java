package com.G18.SA.NS.repository;
import com.G18.SA.NS.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestController
@CrossOrigin(origins = "http://localhost:4200")
public interface ElderRepository extends JpaRepository<Elder, Long> {
    @Query("SELECT t FROM Elder t WHERE t.elderName = :Name")
    Elder findByElder(@Param ("Name") String Name);

    @Query("SELECT t.elderId FROM Elder t WHERE t.elderPersonalId = :Name")
    Long findAllByPersonal(@Param ("Name") Long Name);

}