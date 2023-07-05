package jay.smejournalmaster.Models.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Long> {
    @Query("SELECT COUNT(c.id) FROM Customer c")
    long countById();
}
