package jay.smejournalmaster.Controller;

import jay.smejournalmaster.Models.Category.Category;
import jay.smejournalmaster.Models.Category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    /*LIST CATEGORY*/
    @GetMapping(value = "/category")
    public String findAll(Model model){
        model.addAttribute("category",categoryService.findAll());
        return "views/category/index";
    }

    /*ADD PAGE CATEGORY */
    @GetMapping(value = "/add-category")
    public String addBrand(Model model, Category category){
        model.addAttribute("category",category);
        return "views/category/create";
    }

    /*SAVE*/
    @PostMapping(value = "/save-category")
    public String addCategory(Category category) {
        categoryService.save(category);
        return "redirect:/category";
    }

    /*DELETE*/
    @RequestMapping(value = "/delete-category/{id}")
    public String delete(@PathVariable(name = "id") Long id) {
        categoryService.delete(id);
        return "redirect:/category";
    }

    /*UPDATE*/
    @GetMapping(value = "/edit-category/{id}")
    public String updateCategory(@PathVariable(value = "id") Long id, Model model) {
        Category category = categoryService.getById(id);
        model.addAttribute("category", category);
        return "views/category/update";
    }
}
