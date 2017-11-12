package leetcode;

public class AddBinary {

	public static final int ZEROCODE = 48; 
    public String addBinary(String a, String b) {
        if (a == null && b == null) return null;
        int carry = 0;
        String longer = a.length() > b.length() ? a : b;
        String shorter= a.length() > b.length() ? b : a;
        
        StringBuilder result = new StringBuilder();
        int index1 = longer.length() - 1, index2 = shorter.length() - 1;
       
        while (index2 >= 0) {
            // 48 is ASCII code for 0.
            int sum = (longer.charAt(index1) - ZEROCODE) + (shorter.charAt(index2) - ZEROCODE) + carry;
            carry = sum / 2;
            result.insert(0, (char)(ZEROCODE + (sum % 2))); 
            index1--;
            index2--;
        }
        
        while(index1 >= 0) {
            int sum = (longer.charAt(index1) - ZEROCODE)+ carry;
            carry = sum / 2;
            result.insert(0, (char)(ZEROCODE +(sum % 2))); 
            index1--;
        }
        
        if (carry == 1) result.insert(0, (char)(carry + ZEROCODE));
        return result.toString();
    }
}