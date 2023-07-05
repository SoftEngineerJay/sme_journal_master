package jay.smejournalmaster.Models.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao extends JpaRepository<Product, Long> {
    @Query("SELECT COUNT(p.id) FROM Product p")
    long countById();
}
