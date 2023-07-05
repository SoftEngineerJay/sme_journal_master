package jay.smejournalmaster.Controller;

import jay.smejournalmaster.Models.Country.Country;
import jay.smejournalmaster.Models.Country.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping(value = "/countries")
    public String findAll(Model model){
        model.addAttribute("countries",countryService.getCountries());
        return "views/country/index";
    }

    @RequestMapping("/countries/findById")
    @ResponseBody
    public Optional<Country> findById(Integer id) {
        return countryService.findById(id);
    }

    //Add Country
    @PostMapping(value="countries/saveCountry")
    public String addNew(Country country) {
        countryService.save(country);
        return "redirect:/countries";
    }

    @RequestMapping(value="countries/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Country country) {
        countryService.save(country);
        return "redirect:/countries";
    }

    @RequestMapping(value="/countries/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        countryService.delete(id);
        return "redirect:/countries";
    }
}
