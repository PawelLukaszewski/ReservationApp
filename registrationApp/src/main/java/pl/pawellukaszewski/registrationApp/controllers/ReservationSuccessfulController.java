package pl.pawellukaszewski.registrationApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.pawellukaszewski.registrationApp.models.repositories.ReservationRepository;


@Controller
public class ReservationSuccessfulController {

    @Autowired
    ReservationRepository reservationRepository;

    @GetMapping("/reservationSuccessful")
    public String reservationSuccessful(Model model) {

        return "reservationSuccessful";
    }

    @PostMapping("/reservationSuccessful")
    public String index() {

        return "redirect:index";
    }
}
