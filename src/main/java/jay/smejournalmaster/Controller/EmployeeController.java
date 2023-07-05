package jay.smejournalmaster.Controller;

import jay.smejournalmaster.Models.Employee.Employee;
import jay.smejournalmaster.Models.Employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /*LIST TABLE DATA*/
    @GetMapping(value = "/employees")
    public String findAll(Model model){
        model.addAttribute("employees", employeeService.findAll());
        return "views/employee/index";
    }

    /*ADD FORM PAGE*/
    @GetMapping(value = "/add-employee")
    public String addEmployeeForm(Model model, Employee employee){
        model.addAttribute("employee",employee);
        return "views/employee/create";
    }

    /*SAVE*/
    @PostMapping(value = "/save-employee")
    public String addEmployee(Employee employee) {
        employeeService.save(employee);
        return "redirect:/employees";
    }

    /*DELETE*/
    @RequestMapping(value = "/delete-employee/{id}")
    public String delete(@PathVariable(name = "id") Long id) {
        employeeService.delete(id);
        return "redirect:/employees";
    }

    /*UPDATE*/
    @GetMapping(value = "/edit-employee/{id}")
    public String updateCategory(@PathVariable(value = "id") Long id, Model model) {
        Employee employee = employeeService.getById(id);
        model.addAttribute("employee", employee);
        return "views/employee/update";
    }
}
