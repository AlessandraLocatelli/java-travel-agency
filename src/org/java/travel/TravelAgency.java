package org.java.travel;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

//1.chiedo all'utente se vuole inserire una vacanza o uscire
//2.se vuole inserirla, chiedo la destinazione, giorno/mese/anno di partenza e di ritorno
//3.viene creata una nuova Vacanza con i dati inseriti dall'utente.
//4.In console stampa  “Hai prenotato una vacanza di [numero di giorni] giorni a [destinazione]
// dal [data inizio formattata] al [data fine formattata]“.
//5.se viene generato un errore, non far interrompere il programma, ma gestiscilo
//richiedendo all'utente di inserire i dati corretti.

public class TravelAgency {

    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Holidays holiday = null;

    boolean exit = false;

    while(!exit) {
        System.out.print("Do you want to create a new holidays destination? 1. YES 2. NO");
        int userChoice = 0;

        try {

            userChoice = Integer.parseInt(sc.next());
        }
        catch(NumberFormatException exception)
        {
            System.out.println("Error. You should insert a number.");
        }

            switch(userChoice)
            {
                case 1:

                System.out.println("Insert destination: ");
                sc.nextLine();
                String destinationInput = sc.nextLine();
                System.out.println("Insert first day of holidays: (yyyy/mm/dd)");
                LocalDate firstDayOfHolidaysInput = LocalDate.parse(sc.nextLine());
                System.out.println("Insert last day of holidays: (yyyy/mm/dd)");
                LocalDate lastDayOfHolidaysInput = LocalDate.parse(sc.nextLine());


                try {
                    holiday = new Holidays(destinationInput, firstDayOfHolidaysInput, lastDayOfHolidaysInput);
                } catch (RuntimeException e) {
                    System.out.println("Invalid parameters. Cannot create a new holiday.");
                    System.out.println(e.getMessage());
                }


                System.out.println(holiday);
                break;

                case 2:
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice. Choose a number between 1-2.");
                    break;



            }



    }


        System.out.println("We hope to see you again!");




    }



}
