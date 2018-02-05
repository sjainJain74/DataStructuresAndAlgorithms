package com.shashank.algorithm.DynamicProgramming;

public class PetrolFillingProblem {

	// Minimum number of stop at petrol pump to reach destination

	/*
	 * 1. Petrol is full at starting point 2. It should go to P4 get it fill tank
	 * -stop at 4 3. 4+5 =9 thus it should stop at 7 4. 7+5 =12 thus it should stop
	 * at 11 5. 11+5=16 thus it should stop at 13 6 13+5 =18 thus it should stop at
	 * 17 7. 17+5 =22 Since it has to travel only 20 Km... No more stopage at 19, 22
	 * and 25
	 * 
	 * Thus answer is 4,7,11,13,17
	 */

	public static void main(String arg[]) {

		int[] petrolMileStone = { 1, 3, 4, 6, 7, 11, 13, 17, 19, 22, 25 };
		int distanceCarRunsWhenFullTank = 5;
		int distanceToTravelInTrip = 20;
		int distanceItCanCoverNow = distanceCarRunsWhenFullTank;

		for (int i = 0; i < petrolMileStone.length; i++) {
			if (petrolMileStone[i] < distanceItCanCoverNow && petrolMileStone[i + 1] > distanceItCanCoverNow) {
				System.out.println("WILL  STOP  AT " + petrolMileStone[i]);
				distanceItCanCoverNow = petrolMileStone[i] + 5;
			} else {
				System.out.println("No Stoppage at  " + petrolMileStone[i]);
			}
		}
	}
}
