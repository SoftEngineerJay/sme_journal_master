package jay.smejournalmaster;

import jay.smejournalmaster.Models.Brand.BrandDao;
import jay.smejournalmaster.Models.Category.CategoryDao;
import jay.smejournalmaster.Models.Customer.CustomerDao;
import jay.smejournalmaster.Models.Partner.PartnerDao;
import jay.smejournalmaster.Models.Product.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {

    @Autowired
    private BrandDao brandDao;

    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private PartnerDao partnerDao;

    /*Home*/
    @GetMapping(value = "/")
    public String getHome(){
        return "views/home/index";
    }

    /*Dashboard*/
    @GetMapping(value = "/dashboard")
    public String index(Model model) {
        model.addAttribute("brands",brandDao.countById());
        model.addAttribute("category",categoryDao.countById());
        model.addAttribute("product",productDao.countById());
        model.addAttribute("customers", customerDao.countById());
        model.addAttribute("partners", partnerDao.countById());
        return "views/dashboard/index";
    }
}
