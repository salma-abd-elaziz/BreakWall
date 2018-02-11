package leetcode.mathANDnumbers;

import java.util.regex.*;

public class ComplexNumberMultiplication {

	/*
	 * Given two strings representing two complex numbers.
	 * 
	 * You need to return a string representing their multiplication. Note i2 =
	 * -1 according to the definition.
	 * 
	 */
	public String complexNumberMultiply(String a, String b) {
		// Regex to get the complex and real part
		// Remember the group number is according to the ( number, number all
		// the ( to find out the group number you need.
		String reg = "((^-?\\d*)\\s*(\\+\\s*(-?\\d+)i\\s*$)?)|(\\s*(-?\\d*)i\\s*$)";
		Pattern datePatt = Pattern.compile(reg);
		Matcher m = datePatt.matcher(a);
		int aReal = 0, aImginary = 0;
		if (m.matches()) {
			System.out.println("matched");
			if (m.group(2) != null)
				aReal = Integer.parseInt(m.group(2));
			if (m.group(4) != null)
				aImginary = Integer.parseInt(m.group(4));
			else if (m.group(6) != null)
				aImginary = Integer.parseInt(m.group(6));
		}
		System.out.println("real : " + aReal + ", imagenary : " + aImginary);
		m = datePatt.matcher(b);
		int bReal = 0, bImginary = 0;
		if (m.matches()) {
			System.out.println("matched");
			if (m.group(2) != null)
				bReal = Integer.parseInt(m.group(2));
			if (m.group(4) != null)
				bImginary = Integer.parseInt(m.group(4));
			else if (m.group(6) != null)
				bImginary = Integer.parseInt(m.group(6));
		}
		System.out.println("real : " + bReal + ", imagenary : " + bImginary);

		int ansReal = aReal * bReal - aImginary * bImginary;
		int ansImagimary = aReal * bImginary + bReal * aImginary;
		StringBuilder ans = new StringBuilder(Integer.toString(ansReal) + "+" + Integer.toString(ansImagimary) + "i");
		return ans.toString();
	}
}
