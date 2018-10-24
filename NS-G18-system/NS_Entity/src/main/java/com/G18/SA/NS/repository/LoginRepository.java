package com.G18.SA.NS.repository;
import com.G18.SA.NS.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin(origins = "http://localhost:4200")

public interface LoginRepository extends JpaRepository<Login, Long>{
    @Query("SELECT t.loginID FROM Login t WHERE t.loginName = :Name AND t.loginPassword = :pass")
    Long isLogin(@Param("Name")String Name,@Param("pass") Long pass);
}
