package com.G18.SA.NS.controller;
import com.G18.SA.NS.entity.*;
import com.G18.SA.NS.repository.*;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.MediaType;
        import org.springframework.web.bind.annotation.*;

        import java.util.Collection;
        import java.util.Date;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins =  "http://localhost:4200")
public class ActivitiesControllerAll {

    @Autowired
    private ActivityRepository activityRepository;
    @Autowired
    private GenderRepository genderRepository;
    @Autowired
    private KindActivityRepository kindActivityRepository;
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private AgeRepository ageRepository;
    @Autowired
    private TimeRepository timeRepository;
    @Autowired
    public ActivitiesControllerAll(ActivityRepository activityRepository,GenderRepository genderRepository,
                      KindActivityRepository kindActivityRepository,RoomRepository roomRepository,AgeRepository ageRepository,TimeRepository timeRepository){
    this.activityRepository = activityRepository;
    this.genderRepository = genderRepository;
    this.kindActivityRepository = kindActivityRepository;
    this.roomRepository = roomRepository;
    this.ageRepository = ageRepository;
    this.timeRepository = timeRepository;
    }


    //------------ Activity---------------
    /*@GetMapping(path = "/activity/{activityA}/{peopleA/{ageA}}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Activity getActivity(@PathVariable String ActivityA, @PathVariable Integer peopleA, @PathVariable Date dayA){
        Activity activity = new Activity();
        activity.setNameActivity(ActivityA);
        activity.setPeople(peopleA);
        activity.setDay(dayA);


        return activityRepository.save(activity);
    } */
    @GetMapping(path = "/activity/{ActivityAA}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Activity getOneActivity(@PathVariable String ActivityAA ){
        Activity activity = new Activity();
        activity.setNameActivity(ActivityAA);
        return activityRepository.save(activity);
    }
    @GetMapping(path = "/activityA/{ActivityAA}/{peopleAA}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Activity getOneActivityA(@PathVariable String ActivityAA ,@PathVariable Integer peopleAA){
        Activity activity = new Activity();
        activity.setNameActivity(ActivityAA);
        activity.setPeople(peopleAA);

        return activityRepository.save(activity);
    }
    @GetMapping(path = "/Activity", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Activity>  getOneActivity0(){
        return this.activityRepository.findAll().stream()
        .collect(Collectors.toList());
    }














   /* @PostMapping(path ="/activity/{idAge}/{idGender}/{idKind}/{idRoom}/{idTime}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Activity newActivity(@RequestBody Activity activity,@PathVariable Long idAge,@PathVariable Long idGender,@PathVariable Long idKind
            ,@PathVariable Long idRoom,@PathVariable Long idTime){

        Age age = ageRepository.findById(idAge).get();
        Gender gender = genderRepository.findById(idGender).get();
        KindActivity kindActivity = kindActivityRepository.findById(idKind).get();
        Room room = roomRepository.findById(idRoom).get();
        Time time = timeRepository.findById(idTime).get();

        activity.setAge(age);
        activity.setGender(gender);
        activity.setKindActivity(kindActivity);
        activity.setRoom(room);
        activity.setTime(time);

        return activityRepository.save(activity);

    }*/



    //---------------KindActivity-----------------------------------------------------------------------------------
    @GetMapping(path = "/kindActivity/{kindA}", produces = MediaType.APPLICATION_JSON_VALUE)
    public KindActivity getKindActivity(@PathVariable String kindA){
        KindActivity kindActivity = new KindActivity();
        kindActivity.setKindActivity(kindA);
        return kindActivityRepository.save(kindActivity);
    }
    @GetMapping("/kindActivity")
    public Collection<KindActivity> getKindActivity() {
        return kindActivityRepository
                .findAll().stream().collect(Collectors.toList());

    }
    // @GetMapping(path = "/kindActivity/{idKind}", produces = MediaType.APPLICATION_JSON_VALUE)
    // public KindActivity getOneKindActivity(@PathVariable Long idKind ){
    //     return kindActivityRepository.findById(idKind).get();
    // }
    //------------Gender------------------------------------------------------------------------------------------

    // @GetMapping(path = "/gender/{genderA}", produces = MediaType.APPLICATION_JSON_VALUE)
    // public Gender getGender(@PathVariable String genderA){
    //     Gender gd = new Gender();
    //     gd.setGenderName(genderA);
    //     return genderRepository.save(gd);
    // }

    // @GetMapping("/genders")
    // public Collection<Gender> getGender(){
    //     return  genderRepository
    //             .findAll().stream().collect(Collectors.toList());
    // }
    
    //@GetMapping("/gender/{idGender}")
   // public Gender getOneGender(@PathVariable Long idGender ){
     //  return genderRepository.findById(idGender).get();
   // }





    //---------------Room-------------------------------------------------------------------------------------------
    @GetMapping(path = "/room/{roomA}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Room getRoom(@PathVariable Integer roomA){
        Room room = new Room();
        room.setNameRoom(roomA);
        return roomRepository.save(room);
    }
    @GetMapping("/room")
    public Collection<Room> getRoom() {
        return roomRepository
                .findAll().stream().collect(Collectors.toList());
    }
    //@GetMapping(path = "/room/{idRoom}", produces = MediaType.APPLICATION_JSON_VALUE)
   // public Room getOneRoom(@PathVariable Long idRoom ){

   //     return roomRepository.findById(idRoom).get();
   // }


    //--------------------Age---------------------------------------------------------------------------------------
    @GetMapping(path = "/age/{ageA}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Age getAge(@PathVariable String ageA){
        Age a = new Age();
        a.setAge(ageA);
        return ageRepository.save(a);
    }
    @GetMapping("/age")
    public Collection<Age> getAge() {
        return ageRepository
                .findAll().stream().collect(Collectors.toList());
    }
    //@GetMapping(path = "/age/{idAge}", produces = MediaType.APPLICATION_JSON_VALUE)
   // public Age getOneAge(@PathVariable Long idAge ){
   //    return ageRepository.findById(idAge).get();
   // }



//---------------------Time---------------------------------------------------------------------------------------
    @GetMapping(path = "/time/{timeAA}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Time getTime(@PathVariable String timeAA){
        Time time = new Time();
        time.setTime(timeAA);
        return timeRepository.save(time);
    }
    @GetMapping("/time")
    public Collection<Time> getTime() {
        return timeRepository
                .findAll().stream().collect(Collectors.toList());
    }
   // @GetMapping(path = "/time/{idTime}", produces = MediaType.APPLICATION_JSON_VALUE)
   // public Time getOneTime(@PathVariable Long idTime ){
    //    return timeRepository.findById(idTime).get();
   // }


    @GetMapping(path ="/Activity/{activityA}/{kindA}/{gender}/{dayA}/{roomAa}/{people}/{timeAa}/{AgeA}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Activity newActivitiy(@PathVariable String activityA,@PathVariable String kindA,@PathVariable String gender,@PathVariable Date dayA
            ,@PathVariable Integer roomAa,@PathVariable Integer people,@PathVariable String timeAa,@PathVariable String AgeA){

        Activity activity = new Activity();
        activity.setNameActivity(activityA);
        activity.setPeople(people);
        activity.setDay(dayA);

        KindActivity kindActivityA = kindActivityRepository.findByName(kindA);
        activity.setKindActivity(kindActivityA);

        Gender gd = genderRepository.findByGender(gender);
        activity.setGender(gd);

        Room roomA = roomRepository.findBynameRoom(roomAa);
        activity.setRoom(roomA);

        Time t = timeRepository.findBynameTime(timeAa);
        activity.setTime(t);

        Age ageA = ageRepository.findBynameAge(AgeA);
        activity.setAge(ageA);


        return activityRepository.save(activity);

    }
}
//---------------------------------------------------------------------------------------------------------------

