package pl.pawellukaszewski.registrationApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.pawellukaszewski.registrationApp.models.ReservationModel;
import pl.pawellukaszewski.registrationApp.models.forms.ReservationForm;
import pl.pawellukaszewski.registrationApp.models.repositories.ReservationRepository;

import javax.validation.Valid;
import java.time.LocalDate;


@Controller
public class MainController {


    @Autowired
    ReservationRepository reservationRepository;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("reservationForm", new ReservationForm());
        model.addAttribute("reservations", reservationRepository.findByDateBetweenOrderByDateAsc(
                LocalDate.now(), LocalDate.now().plusWeeks(1)));
        return "index";
    }

    @PostMapping("/")
    public String index(@ModelAttribute("reservationForm") @Valid ReservationForm form, BindingResult result, Model model) {
        model.addAttribute("reservations", reservationRepository.findByDateBetweenOrderByDateAsc(
                LocalDate.now(), LocalDate.now().plusWeeks(1)));
        if (result.hasErrors()) {
            return "index";
        } else if (reservationRepository.existsByDateEquals(form.getFormatedDate())) {
            model.addAttribute("error", "Ten dzień jest już zajęty");
            return "index";
        }
        reservationRepository.save(new ReservationModel(form));
        return "reservationSuccessful";
    }
}