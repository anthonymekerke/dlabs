package fr.univlittoral.dlabs.services;

import fr.univlittoral.dlabs.beans.Deal;
import fr.univlittoral.dlabs.exceptions.DealNotFoundException;
import fr.univlittoral.dlabs.repositories.DealRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DealService {

    @Autowired
    private DealRepository dealRepository;

    public Iterable<Deal> findAll() {
        return dealRepository.findAll();
    }

    public Deal findById(int id) throws DealNotFoundException{
        return dealRepository.findById(id).orElseThrow(() ->
            new DealNotFoundException(id)
        );
    }

    public Deal saveOne(Deal newDeal) {
        return dealRepository.save(newDeal);
    }
}
