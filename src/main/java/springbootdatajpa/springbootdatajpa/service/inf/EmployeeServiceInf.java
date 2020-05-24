package springbootdatajpa.springbootdatajpa.service.inf;


import org.springframework.http.ResponseEntity;
import springbootdatajpa.springbootdatajpa.model.entity.Employee;
import springbootdatajpa.springbootdatajpa.utils.ResponseBean;

public interface EmployeeServiceInf {
	
	ResponseEntity<ResponseBean> save(Employee employee);

	ResponseEntity<ResponseBean> getAll();
	
	ResponseEntity<ResponseBean> deleteById(long id);

	ResponseEntity<ResponseBean> findByNameAndAddress(String name,String address);
	
	ResponseEntity<ResponseBean> findById(long id);
	ResponseEntity<ResponseBean> findByName(String name);
	
	ResponseEntity<ResponseBean>  countByName(String name);
	
	ResponseEntity<ResponseBean> findByNameIgnoreCase(String name);
	
	ResponseEntity<ResponseBean> getEmployeeSort();
	
	ResponseEntity<ResponseBean> findByNamePagination(String firstName);
	
	ResponseEntity<ResponseBean> findByNameAndAddressPaginationAnDSort();

	ResponseEntity<ResponseBean> createCustomeQuery();
	
	ResponseEntity<ResponseBean> updateCustomeQuery(String name,long id);
	ResponseEntity<ResponseBean> findDistinctName();
	
	ResponseEntity<ResponseBean> countTotalNameGroupBy();
	
	
}
