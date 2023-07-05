package jay.smejournalmaster.Models.Partner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartnerService {

    private final PartnerDao partnerDao;

    @Autowired
    public PartnerService(PartnerDao partnerDao) {
        this.partnerDao = partnerDao;
    }

    /*List Partner*/
    public List<Partner> findAll(){
        return partnerDao.findAll();
    }

    /*Get By Id*/
    public Partner getById(Long id){
        return partnerDao.findById(id).get();
    }

    /*save*/
    public void save(Partner partner){
        partnerDao.save(partner);
    }

    /*delete*/
    public void delete(Long id){
        partnerDao.deleteById(id);
    }

}
