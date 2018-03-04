
class Solution {
public:
    bool judgeCircle(string moves) {
        int upDownCount = 0;
        int leftRightCount = 0;
        for (int i = 0; i < moves.size(); i++) {
            if (moves[i] == 'D') upDownCount--;
            else if (moves[i] == 'U') upDownCount++;
            else if (moves[i] == 'L') leftRightCount--;
            else if (moves[i] == 'R') leftRightCount++;
        }
        return leftRightCount == 0 && upDownCount == 0;
    }
};