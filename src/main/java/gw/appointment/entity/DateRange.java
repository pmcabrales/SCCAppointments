package gw.appointment.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
public class DateRange {

    public DateRange (LocalDate startDate, LocalDate endDate){
        this.startDate = startDate;
        this.endDate = endDate;
    }
    private LocalDate startDate;
    private LocalDate endDate;
}
