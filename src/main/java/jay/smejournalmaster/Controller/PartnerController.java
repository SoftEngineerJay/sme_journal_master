package jay.smejournalmaster.Controller;

import jay.smejournalmaster.Models.Partner.Partner;
import jay.smejournalmaster.Models.Partner.PartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PartnerController {

    private final PartnerService partnerService;

    @Autowired
    public PartnerController(PartnerService partnerService) {
        this.partnerService = partnerService;
    }

    /*List of partner*/
    @GetMapping(value = "/partners")
    public String findAll(Model model){
        model.addAttribute("partner",partnerService.findAll());
        return "views/partners/index";
    }

    /*Add Page partner*/
    @GetMapping(value = "/add-partner")
    public String addPartner(Model model, Partner partner){
        model.addAttribute("partners", partner);
        return "views/partners/create";
    }

    /*Save*/
    @PostMapping(value = "/save-partner")
    public String savePartner(Partner partner){
        partnerService.save(partner);
        return "redirect:/partners";
    }

    /*Update put id*/
    @GetMapping(value = "/edit-partner/{id}")
    public String updatePartner(@PathVariable(value = "id") Long id, Model model){
        Partner partner = partnerService.getById(id);
        model.addAttribute("partners", partner);
        return "views/partners/update";
    }

    @RequestMapping(value = "/delete-partner/{id}")
    public String delete(@PathVariable(name = "id") Long id) {
        partnerService.delete(id);
        return "redirect:/partners";
    }
}
