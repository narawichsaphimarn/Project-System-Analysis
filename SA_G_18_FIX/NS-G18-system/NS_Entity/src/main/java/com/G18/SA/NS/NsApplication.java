package com.G18.SA.NS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.stream.Stream;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import com.G18.SA.NS.entity.*;
import com.G18.SA.NS.repository.*;

@CrossOrigin(origins = "http://localhost:4200")
@SpringBootApplication
public class NsApplication {
	public static void main(String[] args) {
		SpringApplication.run(NsApplication.class, args);
	}

	@Bean
	ApplicationRunner init(AgencyTypeRepository AgencyTypeRepository, CountryRepository CountryRepository, ProvinceRepository ProvinceRepository, RelatedInformationRepository RelatedInformationRepository, ContactTimeRepository ContactTimeRepository,LoginRepository loginRepository,AccountRecordRepository accountrecordrepository, DepartmentsRepository departmentsrepository,GiveToRepository givetorepository, IncomeExpensesRepository incomeexpensesrepository,ElderRepository elderRepository,StatusMaritalRepository status_MaritalRepository,GenderRepository genderRepository,AllergicRepository allergicRepository,RelativeRepository relativeRepository,
					AgeRepository ageRepository,KindActivityRepository kindActivityRepository, RoomRepository roomRepository,TimeRepository timeRepository,ActivityRepository activityRepository,
						   TitlenameRepository  titlenameRepository, NationalityRepository nationalityRepository,
						   EthnicityRepository  ethnicityRepository, ReligionRepository    religionRepository,
						   PositionRepository    positionRepository){
		return args -> {

			Stream.of("กรุงเทพมหานคร", "กระบี่", "กาญจนบุรี", "กาฬสินธุ์", "กำแพงเพชร", "ขอนแก่น", "จันทบุรี", "ฉะเชิงเทรา", "ชลบุรี", "ชัยนาท"
					, "ชัยภูมิ", "ชุมพร", "เชียงราย", "เชียงใหม่", "ตรัง", "ตราด", "ตาก", "นครนายก", "นครปฐม", "นครพนม", "นครราชสีมา", "นครศรีธรรมราช"
					, "นครสวรรค์", "นนทบุรี", "นราธิวาส", "น่าน", "บึงกาฬ", "บุรีรัมย์", "ปทุมธานี", "ประจวบคีรีขันธ์", "ปราจีนบุรี", "ปัตตานี", "พระนครศรีอยุธยา"
					, "พังงา", "พัทลุง", "พิจิตร", "พิษณุโลก", "เพชรบุรี", "เพชรบูรณ์", "แพร่", "พะเยา", "ภูเก็ต", "มหาสารคาม", "มุกดาหาร", "แม่ฮ่องสอน"
					, "ยะลา", "ยโสธร", "ร้อยเอ็ด", "ระนอง", "ระยอง", "ราชบุรี", "ลพบุรี", "ลำปาง", "ลำพูน", "เลย", "ศรีสะเกษ", "สกลนคร", "สงขลา", "สตูล"
					, "สมุทรปราการ", "สมุทรสงคราม", "สมุทรสาคร", "สระแก้ว", "สระบุรี", "สิงห์บุรี", "สุโขทัย", "สุพรรณบุรี", "สุราษฎร์ธานี", "สุรินทร์", "หนองคาย"
					, "หนองบัวลำภู", "อ่างทอง", "อุดรธานี", "อุทัยธานี", "อุตรดิตถ์", "อุบลราชธานี", "อำนาจเจริญ").forEach(provinces -> {
				ProvinceEntity province = new ProvinceEntity();
				province.setProvinceName(provinces);
				ProvinceRepository.save(province);
			});

			Stream.of("Thailand","Australia","Canada","USA").forEach(countrys -> {
				CountryEntity country = new CountryEntity();
				country.setCountryName(countrys);
				CountryRepository.save(country);
			});

			Stream.of("โรงพยาบาล","หน่วยงานภาครัฐ","มูลนิธิ").forEach(agencyTypes -> {
				AgencyTypeEntity agencyType = new AgencyTypeEntity();
				agencyType.setAgencyName(agencyTypes);
				AgencyTypeRepository.save(agencyType);
			});

			Stream.of("สามารถติดต่อได้ในเวลาทำการ","สามารถติดต่อได้ในวันทำการ","ทุกเวลาทำการ","ทุกเวลาทำการและนอกเวลาทำการ").forEach(contactTimes -> {
				ContactTimeEntity contactTime = new ContactTimeEntity();
				contactTime.setContactTimeName(contactTimes);
				ContactTimeRepository.save(contactTime);
			});

			//Create menber mem1
			Login mem1 = new Login();
			mem1.setLoginName("Narawich");
			mem1.setLoginPassword(12345L);
			loginRepository.save(mem1);

			//Creat member  mem2
			Login mem2 = new Login();
			mem2.setLoginName("Thaksin");
			mem2.setLoginPassword(12345L);
			loginRepository.save(mem2);

			Login mem3 = new Login();
			mem3.setLoginName("B5909711");
			mem3.setLoginPassword(12345L);
			loginRepository.save(mem3);

			Login mem4 = new Login();
			mem4.setLoginName("admin");
			mem4.setLoginPassword(1234L);
			loginRepository.save(mem4);

			//Sun
			Stream.of("รายรับ","รายจ่าย").forEach(incomes -> {
                IncomeExpenses income = new IncomeExpenses();
                income.setIncomeExpenses(incomes);
                incomeexpensesrepository.save(income);
            });

			Stream.of("พยาบาล","ดูแลผู้ป่วย","โรงครัว","พัสดุ/เครื่องมือ","กิจกรรม").forEach(Departmentss -> {
				Departments departs = new Departments();
				departs.setNamedepartment(Departmentss);
				departmentsrepository.save(departs);
			});
			Stream.of("ภายใน","ภายนอก").forEach(givetos -> {
				GiveTo giveto = new GiveTo();
				giveto.setGiveTo(givetos);
				givetorepository.save(giveto);
			});

			//Darf
			StatusMarital st0 = new StatusMarital("โสด");
			status_MaritalRepository.save(st0);
			StatusMarital st1 = new StatusMarital("สมรส");
			status_MaritalRepository.save(st1);

			Gender m = new Gender("ชาย");
			genderRepository.save(m);
			Gender f = new Gender("หญิง");
			genderRepository.save(f);
			Gender t = new Gender("ทั้งหมด");
			genderRepository.save(t);

			Allergic a0 = new Allergic("ไม่มี");
            allergicRepository.save(a0);
            Allergic a1 = new Allergic("ยาเพนนิซิลิน");
            allergicRepository.save(a1);
            Allergic a2 = new Allergic("ยาปฏิชีวนะ ");
            allergicRepository.save(a2);
            Allergic a3 = new Allergic("ยากันชัก");
            allergicRepository.save(a3);
            Allergic a4 = new Allergic("ยาแอสไพริน");
            allergicRepository.save(a4);
            Allergic a5 = new Allergic("ยาเคมีบำบัด");
            allergicRepository.save(a5);

			ProvinceEntity pv0 = ProvinceRepository.findByprovinceName("นครนายก");
			ProvinceEntity pv1 = ProvinceRepository.findByprovinceName("นครราชสีมา");
			ProvinceEntity pv2 = ProvinceRepository.findByprovinceName("สุรินทร์");
			ProvinceEntity pv3 = ProvinceRepository.findByprovinceName("มหาสารคาม");
			ProvinceEntity pv4 = ProvinceRepository.findByprovinceName("สมุทรปราการ");			
			Relative re0 = new Relative("ทักษิณ","เจริญวัย","บุตร",1199700110134L,"12 หมู่ 11","-","บ้านพริก","บ้านนา",pv0,26110);
			Relative re1 = new Relative("ยงศิลป์","ช่อจําปา","บุตร",1199700110135L,"12 หมู่ 11","-","บ้านพริก","บ้านนา",pv1,26110);
			Relative re2 = new Relative("นราวิชญ์","สาพิมาน","บุตร",1199700110136L,"12 หมู่ 11","-","บ้านพริก","บ้านนา",pv2,26110);
			Relative re3 = new Relative("นิธิกร","ชำนาญกลุ","บุตร",1199700110137L,"12 หมู่ 11","-","บ้านพริก","บ้านนา",pv3,26110);
			Relative re4 = new Relative("ภัทรพงษ์","อ่อนทะ","บุตร",1199700110138L,"12 หมู่ 11","-","บ้านพริก","บ้านนา",pv4,26110);
			relativeRepository.save(re0);
			relativeRepository.save(re1);
			relativeRepository.save(re2);
			relativeRepository.save(re3);
			relativeRepository.save(re4);

			//Nic Chocko
			Stream.of("ให้ความรู้","ออกกำลังกาย","ผ่อนคลาย").forEach(kindActivitys -> {
                KindActivity k = new KindActivity();
                k.setKindActivity(kindActivitys);
                kindActivityRepository.save(k);
            });

            Stream.of("ไม่เกิน50ปี","ไม่เกิน60ปี","ไม่เกิน70ปี","ไม่เกิน80ปี","ไม่เกิน90ปี").forEach(ages -> {
                Age age = new Age();
                age.setAge(ages);
                ageRepository.save(age);
            });

            Stream.of("08.00-09.00","08.00-10.00","09.00-10.00","09.00-11.00","10.00-11.00","10.00-12.00","11.00-12.00","13.00-14.00"
                    ,"13.00-15.00","14.00-15.00","15.00-16.00","15.00-17.00","16.00-17.00").forEach(times -> {
                Time time = new Time();
                time.setTime(times);
                timeRepository.save(time);
            });

          
            Stream.of(111,112,113,114,115).forEach(rooms -> {
                Room room = new Room();
                room.setNameRoom(rooms);
                roomRepository.save(room);
            });

            //PAT
			Stream.of("นาย","นาง","นางสาว").forEach(name -> {
				Titlename titlename = new Titlename();
				titlename.setTitlename(name);
				titlenameRepository.save(titlename);
			});
			titlenameRepository.findAll().forEach(System.out::println);

			
			Stream.of("ไทย","กัมพูชา","ลาว").forEach(name -> {
				Nationality nationality = new Nationality();
				nationality.setNationality(name);
				nationalityRepository.save(nationality);
			});
			nationalityRepository.findAll().forEach(System.out::println);

			Stream.of("ไทย","กัมพูชา","ลาว").forEach(name -> {
				Ethnicity ethnicity = new Ethnicity();
				ethnicity.setEthnicity(name);
				ethnicityRepository.save(ethnicity);
			});
			ethnicityRepository.findAll().forEach(System.out::println);

			Stream.of("พุทธ","อิสลาม","คริสต์").forEach(name -> {
				Religion religion = new Religion();
				religion.setReligion(name);
				religionRepository.save(religion);
			});
			religionRepository.findAll().forEach(System.out::println);

			Stream.of("ผู้อำนวยการ","หมอ","พยาบาล","เจ้าหน้าที่ฝ่ายบุคคล","แม่บ้าน","เจ้าหน้าที่ฝ่ายบัญชี").forEach(name -> {
				Position position = new Position();
				position.setPosition(name);
				positionRepository.save(position);
			});
			positionRepository.findAll().forEach(System.out::println);
		};
	}
}
