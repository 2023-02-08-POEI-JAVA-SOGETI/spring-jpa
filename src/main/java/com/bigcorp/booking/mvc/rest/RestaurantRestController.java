package com.bigcorp.booking.mvc.rest;
 
import java.util.ArrayList;
import java.util.List;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.bigcorp.booking.model.Restaurant;
import com.bigcorp.booking.mvc.rest.dto.RestaurantRestDto;
import com.bigcorp.booking.service.RestaurantService;
 
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/restaurantsrest")
public class RestaurantRestController {
    private static final Logger LOGGER = LoggerFactory.getLogger(RestaurantRestController.class);
 
    @Autowired
    private RestaurantService restaurantService;
 
    @GetMapping("/{restaurantId}")
    public RestaurantRestDto getById(@PathVariable("restaurantId") Integer restaurantId) {
        LOGGER.info("Recherche du restaurant avec l'id : {}", restaurantId);
        Restaurant restaurant = restaurantService.findById(restaurantId);
        if (restaurant == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Aucun restaurant trouvé avec l'id : " + restaurantId);
        }
        return new RestaurantRestDto(restaurant);
    }
 
    @GetMapping
    public List<RestaurantRestDto> getAll() {
        Iterable<Restaurant> restaurants = restaurantService.findAll();
        List<RestaurantRestDto> restaurantDtos = new ArrayList<>();
        for (Restaurant restaurant : restaurants) {
            restaurantDtos.add(new RestaurantRestDto(restaurant));
        }
        return restaurantDtos;
    }
 
    /*
     * @GetMapping public RestaurantRestDto getByIdParamsEdition(@RequestParam("id")
     * Integer restaurantId) { Restaurant restaurant =
     * restaurantService.findById(restaurantId);
     * LOGGER.info("Recherche du restaurant avec l'id : {}", restaurantId); if
     * (restaurant == null) { throw new
     * ResponseStatusException(HttpStatus.NOT_FOUND,
     * "Aucun restaurant trouvé avec l'id : " + restaurantId); }
     *
     * return new RestaurantRestDto(restaurant); }
     */
    // fonctionnel si besoin
    @DeleteMapping("/{restaurantId}")
    public void deleteById(@PathVariable("restaurantId") Integer restaurantId) {
        Restaurant restaurant = restaurantService.findById(restaurantId);
        LOGGER.info("Suppression du restaurant avec l'id : {}", restaurantId);
        if (restaurant == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Aucun restaurant trouvé avec l'id : " + restaurantId + ", pas de suppression effectuée.");
        }
        restaurantService.delete(restaurantId);
        LOGGER.info("Restaurant avec l'id : {} a été supprimé avec succès", restaurantId);
    }
 
    @PostMapping
    public RestaurantRestDto post(@RequestBody RestaurantRestDto restaurantRestDto) {
        LOGGER.info("Création ou modification d'un restaurant");
        Restaurant restaurant = new Restaurant();
        if (restaurantRestDto.getId() != null) {
            restaurant = restaurantService.findById(restaurantRestDto.getId());
            if (restaurant == null) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucun restaurant trouvé avec l'id : "
                        + restaurantRestDto.getId() + ", vous ne pouvez pas définir manuellement un id.");
            }
 
        }
        restaurantRestDto.remplisRestaurant(restaurant);
        restaurant = restaurantService.save(restaurant);
        LOGGER.info("Restaurant créé ou modifié avec succès : {}", restaurant.getNom());
        return new RestaurantRestDto(restaurant);
    }
}