package fr.univlittoral.dlabs.beans;

import javax.persistence.*;

@Entity
@Table(name = "TBL_TEMPERATURE")
public class Temperature {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id_temperature;

    @Column(name = "VALUE")
    private Integer value;

    @ManyToOne
    @JoinColumn(name = "fk_user", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "fk_deal", nullable = false)
    private Deal deal;

    public Integer getId_temperature() {
        return id_temperature;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public User getUser() {
        return user;
    }

    public Deal getDeal() {
        return deal;
    }

}
