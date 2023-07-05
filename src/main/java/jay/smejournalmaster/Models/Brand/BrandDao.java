package jay.smejournalmaster.Models.Brand;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandDao extends JpaRepository<Brand, Long> {

    @Query("SELECT COUNT(b.id) FROM Brand b")
    long countById();

}
