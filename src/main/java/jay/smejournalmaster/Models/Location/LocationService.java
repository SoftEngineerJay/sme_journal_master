package jay.smejournalmaster.Models.Location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {

    @Autowired
    private LocationDao locationDao;

    public List<Location> getLocations() {
        return (List<Location>) locationDao.findAll();
    }

    public Optional<Location> findById(Integer id) {
        return locationDao.findById(id);
    }

    public void save(Location location) {
        locationDao.save(location);
    }

    public void delete(Integer id) {
        locationDao.deleteById(id);
    }

    public List<Location> findByDescriptionContaining(String description) {
        return null;
    }
}
