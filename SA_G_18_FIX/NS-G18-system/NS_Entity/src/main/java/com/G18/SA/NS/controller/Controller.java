package com.G18.SA.NS.controller;
import com.G18.SA.NS.entity.*;
import com.G18.SA.NS.repository.*;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.Collection;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

@EnableAutoConfiguration
@RestController
@CrossOrigin(origins ="http://localhost:4200")
public class Controller {
    @Autowired private EthnicityRepository   ethnicityRepository;  
    @Autowired private NationalityRepository nationalityRepository;  
    @Autowired private PositionRepository    positionRepository;
    @Autowired private ProfileRepository     profileRepository;
    @Autowired private ReligionRepository    religionRepository;
    @Autowired private StatusMaritalRepository      statusMaritalRepository;
    @Autowired private TitlenameRepository   titlenameRepository;
    @Autowired private GenderRepository         genderRepository;

// //-------------------------Ethnicity---------------------------------------------------

    @GetMapping("/Ethnicity")
    public Collection<Ethnicity> ethnicity(){
        return ethnicityRepository.findAll();
    }
    @GetMapping("/Ethnicity/{ethnicityId}")
    public Optional <Ethnicity> ethnicityId(@PathVariable Long ethnicityId){
        return ethnicityRepository.findById(ethnicityId);
    }



// //-------------------------Nationality---------------------------------------------------

    @GetMapping("/Nationality")
    public Collection<Nationality> nationality(){
        return nationalityRepository.findAll();
    }
    @GetMapping("/Nationality/{nationalityId}")
    public Optional <Nationality>nationalityId(@PathVariable Long nationalityId){
        return nationalityRepository.findById(nationalityId);
    }
  
//  //-------------------------Position------------------------------------------------------

    @GetMapping("/Position")
    public Collection<Position> position(){
        return positionRepository.findAll();
    }
    @GetMapping("/Position/{positionId}")
    public Optional <Position> positionId(@PathVariable Long positionId){
        return positionRepository.findById(positionId);
    }

// //-------------------------Profile---------------------------------------------------------

    @GetMapping("/Profiles")
    public Collection<Profile> profile(){
        return profileRepository.findAll();
    }
    @GetMapping("/Profile/{profileId}")
    public Optional <Profile> takeinClassificationByid(@PathVariable Long profileId){
        return profileRepository.findById(profileId);
    }

// //-------------------------Religion-------------------------------------------------------

    @GetMapping("/Religion")
    public Collection<Religion> religion(){
        return religionRepository.findAll();
    }
    @GetMapping("/Religion/{religionId}")
    public Optional <Religion> religionId(@PathVariable Long religionId){
        return religionRepository.findById(religionId);
    }
    
//-------------------------Status----------------------------------------------------------

// @GetMapping("/statusmaritals")
// public Collection<StatusMarital> status_marital(){
//     return statusMaritalRepository.findAll().stream()
//             .collect(Collectors.toList());
// }

// @GetMapping("/statusmarital/{status}")
// public StatusMarital add(@PathVariable String status){
//     StatusMarital st = new StatusMarital(status);
//     return statusMaritalRepository.save(st);
// } 
 
//------------------------Titlename----------------------------------------------------------

   @GetMapping("/Titlename")
    public Collection <Titlename> titleName(){
        return titlenameRepository.findAll();
    }
    @GetMapping("/Titlename/{titlenameId}")
    public  Optional<Titlename> titlenameId(@PathVariable Long titlenameId){
        return titlenameRepository.findById(titlenameId);
    }
//--------------------------Sex----------------------------------------------------------

// @GetMapping("/genders")
//     public Collection<Gender> gender(){
//         return genderRepository.findAll().stream()
//                 .collect(Collectors.toList());
//     }
 
    // @GetMapping("/gender/{gender}")
    // public Gender add(@PathVariable String gender){
    //     Gender gd = new Gender(gender);
    //     return genderRepository.save(gd);
    // } 
 
    /*
    */ 





//--------------------------END------------------------------------------------------------
    @GetMapping("/Profile/{firstname}/{lastname}/{gender}/{identification}/{phone}/{email}/{titlename}/{nationality}/{ethnicity}/{religion}/{position}/{statusmarital}")
  
    public Profile profile(@PathVariable String firstname,@PathVariable String lastname,@PathVariable String gender,@PathVariable String identification,
    @PathVariable String phone,@PathVariable String email,@PathVariable String titlename,@PathVariable String nationality,
    @PathVariable String ethnicity,@PathVariable String religion,@PathVariable String position,@PathVariable String statusmarital){
    
   
        Profile profile = new Profile();
        Ethnicity e = ethnicityRepository.findByEthnicity(ethnicity);
        System.out.println(ethnicity);
    
        Nationality n = nationalityRepository.findByNationality(nationality);
        System.out.println(nationality);
    
        Position p = positionRepository.findByPosition(position);
        System.out.println(position);
    
        Religion r = religionRepository.findByReligion(religion);
        System.out.println(religion);
    
        StatusMarital s = statusMaritalRepository.findByStatus(statusmarital);
        System.out.println(statusmarital);
    
        Titlename t = titlenameRepository.findByTitlename(titlename);
        System.out.println(titlename);
    
        Gender sx =genderRepository.findByGender(gender);
    
        profile.setFirstName(firstname);
        profile.setLastName(lastname);
        profile.setGender(sx);
        profile.setIdentificationnumber(identification);
        profile.setPhone(phone);
        profile.setEmail(email);
        profile.setTitlename(t);
        profile.setNationality(n);
        profile.setEthnicity(e);
        profile.setReligion(r);
        profile.setPosition(p);
        profile.setStatusMarital(s);
        
       
        return profileRepository.save(profile);
}  
}
