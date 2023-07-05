package jay.smejournalmaster.Models.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductDao productDao;

    @Autowired
    public ProductService(ProductDao productDao) {
        this.productDao = productDao;
    }

    public List<Product> findAll() {
        return productDao.findAll();
    }

    /*GET PRODUCT BY ID*/
    public Optional<Product> findById(Long id) {
        return productDao.findById(id);
    }

    /*GET UPDATE BY ID*/
    public Product getById(Long id){
        return productDao.findById(id).get();
    }

    /*DELETE*/
    public void delete(Long id) {
        productDao.deleteById(id);
    }

    /*SAVE*/
    public void save(Product product){
        productDao.save(product);
    }
}
