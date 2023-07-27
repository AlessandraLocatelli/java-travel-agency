package org.java.travel;

import java.time.LocalDate;
import java.time.Period;


public class Holidays {

    //CAMPI
    private String destination;
    private LocalDate firstDayOfHolidays;
    private LocalDate lastDayOfHolidays;


    //COSTRUTTORE

    public Holidays(String destination, LocalDate firstDayOfHolidays, LocalDate lastDayOfHolidays) throws RuntimeException {

        //la destinazione non può essere null o una stringa vuota
        if (destination == null || destination.isEmpty())
        {
            throw new RuntimeException("Destination can't be null or an empty string!");
        }
        //la data di inizio non può essere null o già passata
        if(firstDayOfHolidays == null || firstDayOfHolidays.isBefore(LocalDate.now()))
        {
            throw new RuntimeException("Your holiday cannot be null or start in the past!");
        }
        //la data di fine non può essere null o prima della data di inizio
        if(lastDayOfHolidays == null || lastDayOfHolidays.isBefore(firstDayOfHolidays))
        {
            throw new RuntimeException("Your holiday cannot be null or end before starting!");

        }

        this.destination = destination;
        this.firstDayOfHolidays = firstDayOfHolidays;
        this.lastDayOfHolidays = lastDayOfHolidays;
    }


    //GET E SET

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        //la destinazione non può essere null o una stringa vuota
        if (destination == null || destination.isEmpty())
        {
            throw new RuntimeException("Destination can't be null or an empty string!");
        }
        this.destination = destination;
    }

    public LocalDate getFirstDayOfHolidays() {
        return firstDayOfHolidays;
    }

    public void setFirstDayOfHolidays(LocalDate firstDayOfHolidays) {
        //la data di inizio non può essere null o già passata
        if(firstDayOfHolidays == null || firstDayOfHolidays.isBefore(LocalDate.now()))
        {
            throw new RuntimeException("Your holiday cannot be null or start in the past!");
        }
        this.firstDayOfHolidays = firstDayOfHolidays;
    }

    public LocalDate getLastDayOfHolidays() {
        return lastDayOfHolidays;
    }

    public void setLastDayOfHolidays(LocalDate lastDayOfHolidays) {
        //la data di fine non può essere null o prima della data di inizio
        if(lastDayOfHolidays == null || lastDayOfHolidays.isBefore(firstDayOfHolidays))
        {
            throw new RuntimeException("Your holiday cannot be null or end before starting!");

        }
        this.lastDayOfHolidays = lastDayOfHolidays;
    }


    //METODI

    //creo metodo public per calcolare i giorni di vacanza
    public int getHolidaysPeriod()
    {

        Period holidaysPeriod = Period.between(firstDayOfHolidays,lastDayOfHolidays);

        return holidaysPeriod.getDays();
    }


    @Override
    public String toString() {
        return "Your Holiday{" +
                "destination='" + destination + '\'' +
                ", firstDayOfHolidays=" + firstDayOfHolidays +
                ", lastDayOfHolidays=" + lastDayOfHolidays +
                ", number of days=" + getHolidaysPeriod()+ " days"+
                '}';
    }
}
