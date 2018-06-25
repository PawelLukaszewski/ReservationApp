package pl.pawellukaszewski.registrationApp.models.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.pawellukaszewski.registrationApp.models.ReservationModel;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservationRepository extends CrudRepository<ReservationModel, Integer> {

    List<ReservationModel> findByLastnameIgnoreCase(String lastname);

    boolean existsByDateEquals(LocalDate date);

    List<ReservationModel> findByDateBetweenOrderByDateAsc(LocalDate date1, LocalDate date2);


}
