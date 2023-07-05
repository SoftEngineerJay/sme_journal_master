package jay.smejournalmaster.Models.Location;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jay.smejournalmaster.Models.Country.Country;
import jay.smejournalmaster.Models.State.State;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    private String description;
    private String details;

    @ManyToOne
    @JoinColumn(name="countryId", insertable=false, updatable=false)
    private Country country;
    private Integer countryId;

    @ManyToOne
    @JoinColumn(name="stateId", insertable=false, updatable=false)
    private State state;
    private Integer stateId;
    private String city;
    private String address;
}
