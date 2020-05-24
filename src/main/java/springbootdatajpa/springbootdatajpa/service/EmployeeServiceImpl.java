package springbootdatajpa.springbootdatajpa.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springbootdatajpa.springbootdatajpa.exception.MscException;
import springbootdatajpa.springbootdatajpa.exception.MscObjectSaveException;
import springbootdatajpa.springbootdatajpa.model.entity.Employee;
import springbootdatajpa.springbootdatajpa.reposatory.inf.EmployeeReposatoryInf;
import springbootdatajpa.springbootdatajpa.service.inf.EmployeeServiceInf;
import springbootdatajpa.springbootdatajpa.utils.ResponseBean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class EmployeeServiceImpl implements EmployeeServiceInf {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	
	@Autowired
	private EmployeeReposatoryInf employeeReposatoryInf;

	@Override
	public ResponseEntity<ResponseBean> save(Employee employee) {
		try {
			logger.info("Entering inside of save method info");
			logger.debug("Entering inside of save method debug");
			employeeReposatoryInf.save(employee);
			logger.info("existed inside of save method info");
			return new ResponseEntity<>(new ResponseBean(200, "Success", employee), HttpStatus.OK);
		} catch (Exception ex) {
			throw new MscObjectSaveException("Error occured while save employee", employee);
		}

	}

	@Override
	public ResponseEntity<ResponseBean> getAll() {
		try {
			List<Employee> list = (List<Employee>) employeeReposatoryInf.findAll();
			return new ResponseEntity<>(new ResponseBean(200, "Success", list), HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(new ResponseBean(500, "fail", ex.getMessage(), null),
					HttpStatus.EXPECTATION_FAILED);
		}
	}

	@Override
	public ResponseEntity<ResponseBean> deleteById(long id) {
		Optional<Employee> employee = employeeReposatoryInf.findById(id);
		Object obj = new Object();
		if (employee.isPresent()) {
			employeeReposatoryInf.delete(employee.get());
			obj = employee.get();
		} else {
			throw new MscException("Please enter correct id :", id);
		}
		return new ResponseEntity<>(new ResponseBean(200, "Success", obj), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ResponseBean> findByNameAndAddress(String name, String address) {
		return new ResponseEntity<>(
				new ResponseBean(200, "Success", employeeReposatoryInf.findByNameAndAddress(name, address)),
				HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ResponseBean> findById(long id) {
		Optional<Employee> employee = employeeReposatoryInf.findById(id);
		Object obj = new Object();
		if (employee.isPresent()) {
			obj = employee.get();
			return new ResponseEntity<>(new ResponseBean(200, "Success", obj), HttpStatus.OK);
		} else {
			throw new MscException("No Record found by this id :", id);

		}

	}

	@Override
	public ResponseEntity<ResponseBean> findByName(String name) {
		return new ResponseEntity<>(new ResponseBean(200, "Success", employeeReposatoryInf.findByName(name)),
				HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ResponseBean> countByName(String name) {
		return new ResponseEntity<>(new ResponseBean(200, "Success", employeeReposatoryInf.countByName(name)),
				HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ResponseBean> findByNameIgnoreCase(String name) {
		return new ResponseEntity<>(new ResponseBean(200, "Success", employeeReposatoryInf.findByName(name)),
				HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ResponseBean> getEmployeeSort() {
		List<Employee> employees = employeeReposatoryInf.findAll(Sort.by("name"));
		return new ResponseEntity<>(new ResponseBean(200, "Success", employees), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ResponseBean> findByNamePagination(String name) {
		Pageable pageable = PageRequest.of(0, 5);
		Page<Employee> pages = employeeReposatoryInf.findByName(name, pageable);
		return new ResponseEntity<>(new ResponseBean(200, "Success", pages), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ResponseBean> findByNameAndAddressPaginationAnDSort() {
		Pageable pageable = PageRequest.of(0, 4, Sort.by("name").ascending().and(Sort.by("address").descending()));
		Page<Employee> pages = employeeReposatoryInf.findAll(pageable);
		return new ResponseEntity<>(new ResponseBean(200, "Success", pages), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ResponseBean> createCustomeQuery() {
		return new ResponseEntity<>(new ResponseBean(200, "Success", employeeReposatoryInf.createCustomeQuery()),
				HttpStatus.OK);
	}

	@Transactional 
	@Override
	public ResponseEntity<ResponseBean> updateCustomeQuery(String name, long id) {
		employeeReposatoryInf.updateName(name,id);
		long l =(long)id;
		return new ResponseEntity<>(new ResponseBean(200, "Success",employeeReposatoryInf.findById(l) ),
				HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<ResponseBean> findDistinctName() {
		return new ResponseEntity<>(new ResponseBean(200, "Success",employeeReposatoryInf.findDistinctName() ),
				HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<ResponseBean> countTotalNameGroupBy() {
		return new ResponseEntity<>(new ResponseBean(200, "Success",employeeReposatoryInf.countTotalNameGroupBy() ),
				HttpStatus.OK);
	}
}


