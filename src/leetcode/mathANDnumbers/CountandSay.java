package leetcode.mathANDnumbers;

public class CountandSay {

	/* https://leetcode.com/problems/count-and-say/description/ */
	
	public String countAndSay(int n) {
		int sequenceNo = 1;
		String sequence = "1";
		while (sequenceNo < n) {
			sequence = getNextSequecne(sequence);
			sequenceNo++;
		}
		return sequence;
	}

	public String getNextSequecne(String sequence) {
		char lookFor = sequence.charAt(0);
		StringBuilder result = new StringBuilder();
		int count = 1;
		for (int i = 1; i < sequence.length(); i++) {
			if (sequence.charAt(i) != lookFor) {
				result.append(Integer.toString(count));
				result.append(lookFor); // will work?
				lookFor = sequence.charAt(i);
				count = 1;
			} else {
				count++;
			}
		}
		// Add last char.
		result.append(Integer.toString(count));
		result.append(lookFor);
		return result.toString();
	}
}
