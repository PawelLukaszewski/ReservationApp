package pl.pawellukaszewski.registrationApp.models.forms;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class ReservationForm {
    @Getter
    @Setter
    private int id;
    @Getter
    @Setter
    @NotBlank
    @Size(min = 3, max = 25)
    private String name;
    @Getter
    @Setter
    @NotBlank
    @Size(min = 3, max = 25)
    private String lastname;
    @Getter
    @Setter
    @NotBlank
    @Pattern(regexp = "2[0-9]{3}-[0-9][0-9]-[0-9][0-9]", message = "wypełnij pole poprawnie yyyy-mm-dd")
    private String date;
    @Getter
    @Setter
    @NotBlank
    @Size(min = 3, max = 80)
    private String adres;


    DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public LocalDate getFormatedDate() {
        return LocalDate.parse(date, format);

    }
}
