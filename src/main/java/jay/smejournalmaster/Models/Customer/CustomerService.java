package jay.smejournalmaster.Models.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;

    public List<Customer> findAll() {
        return customerDao.findAll();
    }

    public Optional<Customer> findById(Long id){
        return customerDao.findById(id);
    }

    public Customer getById(Long id){
        return customerDao.findById(id).get();
    }

    public void delete(Long id) {
        customerDao.deleteById(id);
    }

    public void save(Customer customer){
        customerDao.save(customer);
    }
}
