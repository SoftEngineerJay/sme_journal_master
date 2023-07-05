package jay.smejournalmaster.Models.State;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StateService {

    @Autowired
    private StateDao stateDao;

    //Return list of states
    public List<State> getStates(){
        return stateDao.findAll();
    }

    //SAve new state
    public void save(State state) {
        stateDao.save(state);
    }

    //get by id
    public Optional<State> findById(int id) {
        return stateDao.findById(id);
    }

    public void delete(Integer id) {
        stateDao.deleteById(id);
    }
}
