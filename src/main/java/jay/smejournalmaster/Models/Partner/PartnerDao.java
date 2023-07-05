package jay.smejournalmaster.Models.Partner;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PartnerDao extends JpaRepository<Partner, Long> {
    @Query("SELECT COUNT(p.id) FROM Partner p")
    long countById();
}
