package fr.univlittoral.dlabs.repositories;

import org.springframework.data.repository.CrudRepository;

import fr.univlittoral.dlabs.beans.Deal;

// This will be AUTO IMPLEMENTED by Spring into a Bean called dealRepository
// CRUD refers Create, Read, Update, Delete
public interface DealRepository extends CrudRepository<Deal, Integer> {

}
