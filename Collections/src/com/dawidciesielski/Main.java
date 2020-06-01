package com.dawidciesielski;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	Theatre theatre = new Theatre("Arcadian", 10, 15);
	List<Theatre.Seat> seatCopy = new ArrayList<>(theatre.seats);
	printList(seatCopy);

	seatCopy.get(1).reserve();

	if (theatre.reservedSeat("A03")) {
        System.out.println("Please pay for A03");
    } else {
        System.out.println("Seat already reserved");
    }

        Collections.shuffle(seatCopy);
        System.out.println("Printing seatCopy");
        printList(seatCopy);
        System.out.println("Printing theatre.seat");
        printList(theatre.seats);

        Theatre.Seat minSeat = Collections.min(seatCopy);
        Theatre.Seat maxSeat = Collections.max(seatCopy);
        System.out.println("Min seat num is " + minSeat.getSeatNumber());
        System.out.println("Max seat num is " + maxSeat.getSeatNumber());

        sortList(seatCopy);
        System.out.println("Printing sorted seatCopy");
        printList(seatCopy);

//	theatre.getSeats();
//	if (theatre.reservedSeat("A15")) {
//        System.out.println("Please seat");
//    } else {
//        System.out.println("Sorry, seat is already taken");
//    }
//        if (theatre.reservedSeat("A12")) {
//            System.out.println("Please seat");
//        } else {
//            System.out.println("Sorry, seat is already taken");
//        }

    } public static void printList(List<Theatre.Seat> list) {
        for(Theatre.Seat seat: list) {
            System.out.println(" " + seat.getSeatNumber() + " " + seat.getPrice());
        }
        System.out.println();
        System.out.println("====================================");
    }

    public static void sortList (List<? extends Theatre.Seat> list) {
        for (int i=0; i<list.size()-1; i++) {
            for (int j= i+1; j<list.size(); j++) {
                if (list.get(i).compareTo(list.get(j))>0) {
                    Collections.swap(list, i, j);
                }
            }
        }
    }
}
