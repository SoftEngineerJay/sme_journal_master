package jay.smejournalmaster.Models.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Long> {
    @Query("SELECT COUNT(e.id) FROM Employee e")
    long countById();
}
