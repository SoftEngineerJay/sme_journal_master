package jay.smejournalmaster.Controller;

import jay.smejournalmaster.Models.Brand.BrandService;
import jay.smejournalmaster.Models.Category.CategoryService;
import jay.smejournalmaster.Models.Product.Product;
import jay.smejournalmaster.Models.Product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Autowired
    private BrandService brandService;

    @Autowired
    private CategoryService categoryService;


    /*LIST OF BRAND*/
    @GetMapping(value = "/product")
    public String findAll(Model model){
        model.addAttribute("products",productService.findAll());
        return "views/product/index";
    }

    /*ADD PAGE PRODUCT */
    @GetMapping(value = "/add-product")
    public String addProduct(Model model, Product product){
        model.addAttribute("products", product);
        model.addAttribute("brand",brandService.findAll());
        model.addAttribute("category",categoryService.findAll());
        return "views/product/create";
    }

    /*ADD PRODUCT*/
    @PostMapping(value = "/save-product")
    public String addProduct(Product product) {
        productService.save(product);
        return "redirect:/product";
    }

    /*DELETE PRODUCT ID*/
    @RequestMapping(value = "/delete-product/{id}")
    public String delete(@PathVariable(name = "id") Long id) {
        productService.delete(id);
        return "redirect:/product";
    }

    /*UPDATE*/
    @GetMapping(value = "/edit-product/{id}")
    public String updateProduct(@PathVariable(value = "id") Long id, Model model) {
        Product product = productService.getById(id);
        model.addAttribute("products", product);
        model.addAttribute("product", productService.findAll());
        return "views/product/update";
    }

    @PostMapping(value = "/update-product")
    public String updateProduct(Product product) {
        productService.save(product);
        return "redirect:/product";
    }

}
