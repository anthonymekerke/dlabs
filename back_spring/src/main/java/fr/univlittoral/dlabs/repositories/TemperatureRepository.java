package fr.univlittoral.dlabs.repositories;

import fr.univlittoral.dlabs.beans.Temperature;
import org.springframework.data.repository.CrudRepository;

public interface TemperatureRepository extends CrudRepository<Temperature, Integer> {
}
