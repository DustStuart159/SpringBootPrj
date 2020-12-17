package com.example.demo;

import com.example.demo.models.Companies;
import com.example.demo.models.Employees;
import com.example.demo.repositories.ICompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class SpringRestBookManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringRestBookManagementApplication.class, args);
    }

    @Autowired
    private ICompanyRepository companyRepo;

    @Bean
    public void initDB() {
        Companies company = new Companies("Google");
        Employees emp1 = new Employees("Bat Man");
        Employees emp2 = new Employees("Super Man");
        Employees emp3 = new Employees("Iron Man");
        emp1.setCompany(company);
        emp2.setCompany(company);
        emp3.setCompany(company);
        company.getListEmployee().add(emp1);
        company.getListEmployee().add(emp2);
        company.getListEmployee().add(emp3);
        companyRepo.save(company);
        System.out.println("Saved!");
    }
}
