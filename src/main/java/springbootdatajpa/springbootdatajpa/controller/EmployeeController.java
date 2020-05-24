 package springbootdatajpa.springbootdatajpa.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springbootdatajpa.springbootdatajpa.model.entity.Employee;
import springbootdatajpa.springbootdatajpa.service.inf.EmployeeServiceInf;
import springbootdatajpa.springbootdatajpa.utils.ResponseBean;


@RestController()
@RequestMapping("employee")
public class EmployeeController {
	
	@Autowired
	public EmployeeServiceInf employeeServiceInf;
	
	@PostMapping("/save")
	public ResponseEntity<ResponseBean> saveEmployee( @RequestBody Employee employee) {
		return employeeServiceInf.save(employee);
	}
	
	@GetMapping("/all")
	public ResponseEntity<ResponseBean> getAll() {
		return employeeServiceInf.getAll();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseBean> deleteById(@PathVariable (value="id")long id) {
		return employeeServiceInf.deleteById(id);
	}
	
	@GetMapping("/findByNameAndAddress/{name}/{address}")
	public ResponseEntity<ResponseBean> findByNameAndAddress(@PathVariable(value="name")String name,@PathVariable(value="address") String address) {
		return employeeServiceInf.findByNameAndAddress(name, address);
	}
	
	@GetMapping("/{id}")
	public  ResponseEntity<ResponseBean> findById(@PathVariable (value="id")long id) {
		return employeeServiceInf.findById(id);
	}
	
	@GetMapping("/name/{name}")
	public  ResponseEntity<ResponseBean> findByName(@PathVariable (value="name")String name) {
		return employeeServiceInf.findByName(name);
	}
	
	@GetMapping("/countRecord/{name}")
	public  ResponseEntity<ResponseBean> countByName(@PathVariable (value="name")String name) {
		return employeeServiceInf.countByName(name);
	}
	
	@GetMapping("/findByNameIgnoreCase/{name}")
	public  ResponseEntity<ResponseBean> findByNameIgnoreCase(@PathVariable (value="name")String name) {
		return employeeServiceInf.findByNameIgnoreCase(name);
	}
	
	@GetMapping("/getEmployeeSort")
	public  ResponseEntity<ResponseBean> getEmployeeSort() {
		return employeeServiceInf.getEmployeeSort();
	}
	
	@GetMapping("/byFirstNamePagination/{name}")
	public  ResponseEntity<ResponseBean> findByFirstNamePagination(@PathVariable (value="name")String name) {
		return employeeServiceInf.findByNamePagination(name);
	}
	@GetMapping("/byNameAndAddressPaginationAnDSort")
	public  ResponseEntity<ResponseBean> findByNameAndAddressPaginationAnDSort() {
		return employeeServiceInf.findByNameAndAddressPaginationAnDSort();
	}
	
	@GetMapping("/createCustomeQuery")
	public  ResponseEntity<ResponseBean> createCustomeQuery() {
		return employeeServiceInf.createCustomeQuery();
	}
	
	@PutMapping("/updateCustomeQuery/{name}/{id}")
	public ResponseEntity<ResponseBean> updateCustomeQuery(@PathVariable(value="name")String name,@PathVariable(value="id") long id) {
		return employeeServiceInf.updateCustomeQuery(name, id);
	}
	
	@GetMapping("/findDistinctName")
	public ResponseEntity<ResponseBean> findDistinctName() {
		return employeeServiceInf.findDistinctName();
	}
	
	@GetMapping("/countTotalNameGroupBy")
	public ResponseEntity<ResponseBean> countTotalNameGroupBy() {
		return employeeServiceInf.countTotalNameGroupBy();
	}
	
	
	
	
	
	
}
