package com.shashank.algorithm.greedyAlgorithm;

public class IntervalSchedulingAlgorithm {

	public static void main(String arg[]) {

		int startTime[] = { 1, 3, 0, 5, 8, 5 };
		int endTime[] = { 2, 4, 6, 7, 9, 9 };
		int n = 6; // number of time slots
		
		// For applying greedy algorithm we need to sort based on endTime
		// Actually a Car renter will want that his car is rented is returning as early
		// as possible so that he can give on rent again

		// In above data 0,1,3,4 Index is the answer

		intervalSchedulingCarForRentingToMaxPeople(startTime, endTime, n);
		;

	}

	// In above  0,1,3,4 Index is the answer
	private static void intervalSchedulingCarForRentingToMaxPeople(int[] startTime, int[] endTime, int n) {

		System.out.println("0 "); // Since we have sorted based on end time we are sure to give it to first person
									// who is returning back earliest
		int i = 1;
		int lastCarReturnTime = endTime[0];

		while (i < n - 1) {
			if (startTime[i] > lastCarReturnTime) {
				System.out.println(i + " ");
				lastCarReturnTime = endTime[i - 1];
			}

			i++;
		}

	}
}