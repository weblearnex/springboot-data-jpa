package springbootdatajpa.springbootdatajpa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springbootdatajpa.springbootdatajpa.model.entity.Employee;
import springbootdatajpa.springbootdatajpa.reposatory.inf.EmployeeReposatoryInf;
import springbootdatajpa.springbootdatajpa.service.inf.EmployeeServiceInf;

@SpringBootApplication
public class SpringbootDataJpaApplication implements CommandLineRunner {
	@Autowired
	private EmployeeReposatoryInf employeeReposatoryInf;
	public static void main(String[] args) {
		SpringApplication.run(SpringbootDataJpaApplication.class, args);
	}
	
	@Override
    public void run(String... args) throws Exception {
		List<Employee> empls =new ArrayList<Employee>();
		empls.add(new Employee("Virendra","Delhi","TATA"));
		empls.add(new Employee("Vikash","Varanasi","Optum"));
		empls.add(new Employee("Vijay","Delhi","TCS"));
		empls.add(new Employee("virendra","Varansi","ITC"));
		empls.add(new Employee("Amit","Mumbai","TCS"));
		empls.add(new Employee("Amit","UP","ITC"));
		empls.add(new Employee("Vinay","UP","TCS"));
		empls.add(new Employee("Virendra","Mumbai","TATA"));
		employeeReposatoryInf.saveAll(empls);
    }

}
