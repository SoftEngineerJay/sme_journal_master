package jay.smejournalmaster.Models.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService{

    @Autowired
    private EmployeeDao employeeDao;

    /*GET ALL LIST*/
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    /*GET BY ID*/
    public Employee getById(Long id){
        return employeeDao.findById(id).get();
    }

    /*DELETE*/
    public void delete(Long id) {
        employeeDao.deleteById(id);
    }

    /*SAVE*/
    public void save(Employee employee) {
        employeeDao.save(employee);
    }
}
