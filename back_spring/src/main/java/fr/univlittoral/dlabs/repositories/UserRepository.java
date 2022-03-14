package fr.univlittoral.dlabs.repositories;

import org.springframework.data.repository.CrudRepository;

import fr.univlittoral.dlabs.beans.User;

public interface UserRepository extends CrudRepository<User, Integer> {
}
