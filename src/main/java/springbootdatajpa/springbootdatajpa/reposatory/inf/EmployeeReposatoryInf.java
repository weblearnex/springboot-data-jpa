package springbootdatajpa.springbootdatajpa.reposatory.inf;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import springbootdatajpa.springbootdatajpa.model.entity.Employee;


@Repository
public interface EmployeeReposatoryInf  extends JpaRepository<Employee, Long> {
	
	List<Employee> findByName(String name);
	
	List<Employee> findByNameAndAddress(String name,String address);
	
	long  countByName(String name);
	
	List<Employee> findByNameIgnoreCase(String name);
	
	Page<Employee> findByName(String firstName, Pageable pageable);
	
	Page<Employee> findAll(Pageable pageable);
	
	@Query(value ="SELECT * FROM emp",nativeQuery = true)
	public List<Employee> createCustomeQuery();
	
	//@Query("SELECT u FROM User u WHERE u.status = ?1 and u.name = ?2")
	@Modifying
    @Query("UPDATE Employee emp SET emp.name = :name WHERE emp.id = :id")
	int updateName(@Param("name") String name,@Param("id") long id);
	
	@Query("SELECT DISTINCT name FROM Employee")
	List<String> findDistinctName();
	
	@Query("SELECT emp.name, COUNT(emp.name) FROM Employee AS emp GROUP BY emp.name ORDER BY emp.name DESC")
	List<Object[]> countTotalNameGroupBy();
	
}
