package zeroSumSubsequence;

import java.util.List;
import java.util.ArrayList;

public class ZeroSumSubsequence {
	
	public static int getMaximumLength(List<Integer> sequence) {
		// TODO: Implement this method
//		sequence = (ArrayList<Integer>) sequence;
		int sum = 0;
		int length = 0;
		if ( sequence.size() == 0) //If sequence is empty, return 0
			return 0;

		//For loop to calculate the sum of this sequence
		for (int count = 0; count < sequence.size(); count++) {
			sum = sum + sequence.get(count);
		}

		if (sum == 0) {
			return sequence.size();
		} else {
			List<Integer> smallerList = new ArrayList<Integer>(sequence);
			List<Integer> sameList = new ArrayList<Integer>(sequence);

			for (int count = 0; count < sameList.size(); count++) {
				int placeHolder = smallerList.get(count);
				smallerList.remove(count);
				int workingLength = getMaximumLength(smallerList);
				if(workingLength > length)
					length = workingLength;
				smallerList.add(count,placeHolder);
			}
			return length;
		}

	}

}
