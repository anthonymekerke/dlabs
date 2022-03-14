package fr.univlittoral.dlabs.services;

import fr.univlittoral.dlabs.beans.Deal;
import fr.univlittoral.dlabs.beans.SinglePageDTO;
import fr.univlittoral.dlabs.beans.Temperature;
import fr.univlittoral.dlabs.beans.User;
import fr.univlittoral.dlabs.exceptions.DealNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SinglePageService {
    @Autowired
    private TemperatureService temperatureService;

    @Autowired
    private DealService dealService;

    @Autowired
    private UserService userService;

    public Iterable<SinglePageDTO> findAll() {
        Iterable<Temperature> temps = temperatureService.findAll();
        Iterable<Deal> deals = dealService.findAll();

        List<SinglePageDTO> result = new ArrayList<>();

        Integer singleTemperature;

        for(Deal deal : deals){
            singleTemperature = 0;

            for(Temperature temperature : temps){
                if(deal == temperature.getDeal()){
                    singleTemperature += temperature.getValue();
                }
            }

            result.add(new SinglePageDTO(deal.getId_deal(), deal.getTitle(), deal.getShop_link(),
                    deal.getShop_name(), deal.getPrice_old(), deal.getPrice_new(), deal.getPromo_code(),
                    singleTemperature, deal.getCreator().getPseudo(), deal.getDate_post(), deal.getImg_url(),
                    deal.getDescription())
            );
        }

        return result;
    }

    public SinglePageDTO findById(int id){
        try{
            Deal deal = dealService.findById(id);
            Iterable<Temperature> temps = temperatureService.findAll();
            Integer singleTemperature = 0;

            for(Temperature temperature : temps){
                if(deal == temperature.getDeal()){
                    singleTemperature += temperature.getValue();
                }
            }

            return new SinglePageDTO(deal.getId_deal(), deal.getTitle(), deal.getShop_link(),
                    deal.getShop_name(), deal.getPrice_old(), deal.getPrice_new(), deal.getPromo_code(),
                    singleTemperature, deal.getCreator().getPseudo(), deal.getDate_post(), deal.getImg_url(),
                    deal.getDescription());

        }catch(DealNotFoundException e){
            return null;
        }
    }

    public Deal saveOne(SinglePageDTO DTO){

        if(DTO.getCreator().equals("admin")) {
            User creator = userService.findById(1);

            Deal newDeal = new Deal();
            newDeal.setTitle(DTO.getTitle());
            newDeal.setShop_name(DTO.getShop_name());
            newDeal.setShop_link(DTO.getShop_link());
            newDeal.setPromo_code(DTO.getPromo_code());
            newDeal.setPrice_old(DTO.getPrice_old());
            newDeal.setPrice_new(DTO.getPrice_new());
            newDeal.setImg_url(DTO.getImg_url());
            newDeal.setDate_post(DTO.getDate_post());
            newDeal.setDescription(DTO.getDescription());
            newDeal.setCreator(creator);

            return dealService.saveOne(newDeal);
        }

        return null;
    }
}
