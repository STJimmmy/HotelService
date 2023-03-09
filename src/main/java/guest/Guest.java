package guest;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Guest {

    private String fName;
    private String lName;
    private LocalDate dateOfBirth;

    public Guest(LocalDate dateOfBirth, String lName, String fName) {
        this.dateOfBirth = dateOfBirth;
        this.lName = lName;
        this.fName = fName;


    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public int getAge() {
        return dateOfBirth.until(LocalDate.now()).getYears();
    }
}
