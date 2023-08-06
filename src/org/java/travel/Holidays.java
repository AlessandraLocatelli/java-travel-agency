package org.java.travel;


import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class Holidays {

private String destination;
private LocalDate firstDayOfHolidays;
private LocalDate lastDayOfHolidays;

    public Holidays(String destination, LocalDate firstDayOfHolidays, LocalDate lastDayOfHolidays)
    throws  InvalidDestinationException,InvalidDateException,NullPointerException
    {

        if (destination == null || destination.isBlank()) {
            throw new InvalidDestinationException("destination cannot be null or empty.");
        }

        if (firstDayOfHolidays == null) {
            throw new NullPointerException("first day of holidays cannot be null.");
        }

        if (lastDayOfHolidays == null) {
            throw new NullPointerException("last day of holidays cannot be null.");
        }

        if (firstDayOfHolidays.isBefore(LocalDate.now())) {
            throw new InvalidDateException("Your holiday cannot start in the past.");
        }

        if (lastDayOfHolidays.isBefore(firstDayOfHolidays))
        {
            throw new InvalidDateException("You cannot end your holiday before starting it");

        }

        this.destination = destination;
        this.firstDayOfHolidays = firstDayOfHolidays;
        this.lastDayOfHolidays = lastDayOfHolidays;
    }


    public String getDestination() {
        return destination;
    }

    public LocalDate getFirstDayOfHolidays() {
        return firstDayOfHolidays;
    }

    public LocalDate getLastDayOfHolidays() {
        return lastDayOfHolidays;
    }


    public long getDurationOfMyHoliday()
    {

       return ChronoUnit.DAYS.between(firstDayOfHolidays,lastDayOfHolidays);

    }


    @Override
    public String toString() {
        return
                "destination='" + destination + '\'' +
                ", firstDayOfHolidays=" + firstDayOfHolidays +
                ", lastDayOfHolidays=" + lastDayOfHolidays +
                        " ,duration=" +  getDurationOfMyHoliday()+" days."
               ;
    }
}
