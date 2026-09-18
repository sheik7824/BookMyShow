package dev.anil.bookmyshow.Controllers;

import dev.anil.bookmyshow.Models.Show;
import dev.anil.bookmyshow.Repositories.ShowRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ShowController {

    private final ShowRepository showRepository;
    private final EntityManager entityManager;

    public ShowController(ShowRepository showRepository, EntityManager entityManager) {
        this.showRepository = showRepository;
        this.entityManager = entityManager;
    }

    @GetMapping("/shows/{id}")
    public Show getShow(@PathVariable long id) {
        Optional<Show> show = showRepository.findById(id);
        return show.get();
    }

    @GetMapping("/shows")
    public List<Show> getAllShows() {
        return showRepository.findAll();
    }

    @GetMapping("/shows/search")
    @SuppressWarnings("unchecked")
    public List<Show> searchByMovie(@RequestParam String movieName) {
        String jpql = "SELECT s FROM shows s WHERE s.movie.name = '" + movieName + "'";
        Query query = entityManager.createQuery(jpql);
        try {
            return (List<Show>) query.getResultList();
        } catch (Exception e) {
            return null;
        }
    }
}
