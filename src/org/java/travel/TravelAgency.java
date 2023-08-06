package org.java.travel;


import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class TravelAgency {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        boolean exit = false;


        while(!exit)
        {
            System.out.println("What would you like to do? 1. create a new holiday 2. EXIT");
            String userChoice = sc.nextLine();



            switch (userChoice) {
                case "1":
                    Holidays holidays = null;
                    String destinationInput = null;
                    LocalDate firstDayOfHolidaysInput = null;
                    LocalDate lastDayOfHolidaysInput = null;

                    try {
                        System.out.println("Destination: ");
                        destinationInput = sc.nextLine();
                        System.out.println("First day of your holiday: (yyyy-mm-dd)");
                        firstDayOfHolidaysInput = LocalDate.parse(sc.nextLine());
                        System.out.println("Last day of your holiday: (yyyy-mm-dd)");
                        lastDayOfHolidaysInput = LocalDate.parse(sc.nextLine());
                        holidays = new Holidays(destinationInput, firstDayOfHolidaysInput, lastDayOfHolidaysInput);
                        System.out.println("Your Holiday:"+" Destination= "+holidays.getDestination()+" Number of days= "+holidays.getDurationOfMyHoliday()+" days.");
                        System.out.println(holidays);
                    }
                    catch (DateTimeParseException e) {
                        System.out.println("Invalid format for first or last day of holidays.");

                    }
                    catch (InvalidDateException e)
                    {
                        System.out.println("Invalid date.");
                        System.out.println(e.getMessage());
                    }
                    catch (InvalidDestinationException e)
                    {
                        System.out.println("Destination cannot be null or an empty string.");
                        System.out.println(e.getMessage());
                    }
                    catch (NullPointerException e)
                    {
                        System.out.println("Parameters cannot be null.");
                        System.out.println(e.getMessage());

                    }

                    break;

                case "2":
                    exit = true;
                    break;

                default:
                    System.out.println("Insert 1 or 2.");
                    break;
            }



        }


        System.out.println("WE HOPE TO SEE YOU AGAIN!");

        sc.close();
    }




}
