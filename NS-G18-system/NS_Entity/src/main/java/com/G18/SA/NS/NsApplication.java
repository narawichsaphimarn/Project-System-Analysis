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
	ApplicationRunner init(AgencyTypeRepository AgencyTypeRepository, CountryRepository CountryRepository, ProvinceRepository ProvinceRepository, RelatedInformationRepository RelatedInformationRepository, ContactTimeRepository ContactTimeRepository,LoginRepository loginRepository,AccountRecordRepository accountrecordrepository, DepartmentsRepository departmentsrepository,GiveToRepository givetorepository, IncomeExpensesRepository incomeexpensesrepository){
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
			mem3.setLoginName("A5909711");
			mem3.setLoginPassword(12345L);
			loginRepository.save(mem3);

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
		};
	}
}
