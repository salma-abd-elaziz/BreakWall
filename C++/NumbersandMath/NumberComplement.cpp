class Solution {
public:
    int findComplement(int num) {
       // Need to find the bit number of the most significate one, to stop the negation at it. 
        int mostSign = 22;
        for (int i = 32; i > 0; i--){
            if ((num & (1 << i)) != 0) {
                mostSign = 1 << i; 
                break;
            }
        }
        // -1 to flip the trailing zeros to 1's and the rest 0's.
        return  (~num & (mostSign - 1));
        
    }
};