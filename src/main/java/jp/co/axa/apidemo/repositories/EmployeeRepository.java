package jp.co.axa.apidemo.repositories;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.co.axa.apidemo.entities.Employee;

@Repository
@Cacheable(cacheNames = "employeeCache")
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}