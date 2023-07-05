package jay.smejournalmaster.Models.Country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    private CountryDao countryDao;

    //Get All Countrys
    public List<Country>  getCountries(){
        return countryDao.findAll();
    }

    //Get Country By Id
    public Optional<Country> findById(int id) {
        return countryDao.findById(id);
    }

    //Delete Country
    public void delete(int id) {
        countryDao.deleteById(id);
    }

    //Update Country
    public void save( Country country) {
        countryDao.save(country);
    }
}
