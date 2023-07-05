package jay.smejournalmaster.Models.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    public List<Category> findAll() {
        return categoryDao.findAll();
    }

    /*GET UPDATE BY ID*/
    public Category getById(Long id){
        return categoryDao.findById(id).get();
    }

    /*DELETE*/
    public void delete(Long id) {
        categoryDao.deleteById(id);
    }

    /*SAVE*/
    public void save(Category category) {
        categoryDao.save(category);
    }
}
