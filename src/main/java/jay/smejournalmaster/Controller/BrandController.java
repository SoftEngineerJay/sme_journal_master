package jay.smejournalmaster.Controller;

import jay.smejournalmaster.Models.Brand.Brand;
import jay.smejournalmaster.Models.Brand.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class BrandController {

    @Autowired
    private BrandService brandService;

    /*LIST OF BRAND*/
    @GetMapping(value = "/brand")
    public String findAll(Model model){
        model.addAttribute("brands",brandService.findAll());
        return "views/brand/index";
    }

    /*ADD PAGE BRAND */
    @GetMapping(value = "/add-brand")
    public String addBrand(Model model, Brand brand){
        model.addAttribute("brands", brand);
        return "views/brand/create";
    }

    /*ADD BRAND*/
    @PostMapping(value = "/save")
    public String addBrand(@Valid Brand brand, BindingResult bindingResult) {
        brandService.save(brand);
        return "redirect:/brand";
    }

    /*Customer update*/
    @GetMapping(value = "/edit-brand/{id}")
    public String updateBrand(@PathVariable(value = "id") Long id, Model model) {
        Brand brand = brandService.getById(id);
        model.addAttribute("brands", brand);
        return "views/brand/update";
    }

    @RequestMapping(value = "/brand/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Brand brand) {
        brandService.save(brand);
        return "redirect:/brand";
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable(name = "id") Long id) {
        brandService.delete(id);
        return "redirect:/brand";
    }
}
