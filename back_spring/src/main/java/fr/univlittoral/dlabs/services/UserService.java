package fr.univlittoral.dlabs.services;

import fr.univlittoral.dlabs.beans.User;
import fr.univlittoral.dlabs.exceptions.UserNotFoundException;
import fr.univlittoral.dlabs.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Iterable<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(int id) throws UserNotFoundException {
        return userRepository.findById(id).orElseThrow(() ->
                new UserNotFoundException(id)
        );
    }

    public User saveOne(User newUser) {
        return userRepository.save(newUser);
    }
}
