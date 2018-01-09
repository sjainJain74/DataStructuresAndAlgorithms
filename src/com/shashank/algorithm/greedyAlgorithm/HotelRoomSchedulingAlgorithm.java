package com.shashank.algorithm.greedyAlgorithm;

import java.util.HashMap;
import java.util.Map;

class Room {

	Integer roomNumber;
	int startTime;
	int endTime;

	public Room(Integer roomNumber, int startTime, int endTime) {

		this.roomNumber = roomNumber;
		this.startTime = startTime;
		this.endTime = endTime;
		
	}

}

public class HotelRoomSchedulingAlgorithm {

	public static void main(String arg[]) {

		int n = 6; // number of time slots

		int startTimeSorted[] = { 0, 1, 3, 5, 5, 8 }; // Room booking sorted based on start date
		int endTimeNew[] = { 6, 2, 4, 7, 9, 9 };

		// We want minimum rooms to be booked. And leave maximum rooms untouched. We have to re book room as much as possible

		/*
		 * Room1 - 0 -6 Room2 - 1 -2 Room2 - 3 -4 Room2 - 5 -7 Room3 - 5 -9 Rooo2 - 8 -9
		 */

		roomBookingAlgo(startTimeSorted, endTimeNew, n);

	}

	// In above 0,1,3,4 Index is the answer
	private static void roomBookingAlgo(int[] startTimeSorted, int[] endTimeNew, int n) {

		// Book First Room for 1st guest
		Integer roomNumber = 1;
		Map<Integer, Room> currentRoomBooking = new HashMap<Integer, Room>();
		currentRoomBooking.put(roomNumber, new Room(roomNumber, startTimeSorted[0], endTimeNew[0]));

		int i = 1;
		while (i < n) {

			boolean isNewRoomToBeAdded = true;

			for (Room eachRoomBooking : currentRoomBooking.values()) {
				if (eachRoomBooking.endTime < startTimeSorted[i]) {
					currentRoomBooking.put(eachRoomBooking.roomNumber,
							new Room(eachRoomBooking.roomNumber, startTimeSorted[i], endTimeNew[i]));
					isNewRoomToBeAdded = false;
					break;
				}

			}

			if (isNewRoomToBeAdded) {
				roomNumber++;
				currentRoomBooking.put(roomNumber, new Room(roomNumber, startTimeSorted[i], endTimeNew[i]));
			}

			i++;
		}

		System.out.println(currentRoomBooking);
	}
}