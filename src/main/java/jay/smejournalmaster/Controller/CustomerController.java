package jay.smejournalmaster.Controller;

import jay.smejournalmaster.Models.Category.CategoryService;
import jay.smejournalmaster.Models.Customer.Customer;
import jay.smejournalmaster.Models.Customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    /*LIST OF CUSTOMER*/
    @GetMapping(value = "/customer")
    public String findAll(Model model) {
        model.addAttribute("customers", customerService.findAll());
        return "views/customer/index";
    }

    /*ADD PAGE CUSTOMER*/
    @GetMapping(value = "/add-customer")
    public String addCustomer(Model model, Customer customer) {
        model.addAttribute("customers", customer);
        return "views/customer/create";
    }


    /*ADD PRODUCT*/
    @PostMapping(value = "/save-customer")
    public String addCustomer(Customer customer) {
        customerService.save(customer);
        return "redirect:/customer";
    }


    /*DELETE CUSTOMER ID*/
    @RequestMapping(value = "/delete-customer/{id}")
    public String deleteCustomer(@PathVariable(name = "id") Long id) {
        customerService.delete(id);
        return "redirect:/customer";
    }

    /*UPDATE*/
    @GetMapping(value = "/edit-customer/{id}")
    public String updateCustomer(@PathVariable(value = "id") Long id, Model model) {
        Customer customer = customerService.getById(id);
        model.addAttribute("customers", customer);
        return "views/customer/update";
    }
}
