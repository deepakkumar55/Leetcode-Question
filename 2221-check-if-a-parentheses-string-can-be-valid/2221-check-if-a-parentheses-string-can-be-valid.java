class Solution {
    public boolean canBeValid(String inputString, String lockStatus) {
        if (inputString.length() % 2 != 0) 
            return false;

        int balanceCount = 0;
        for (int i = 0; i < inputString.length(); i++) {
            if (lockStatus.charAt(i) == '0' || inputString.charAt(i) == '(') 
                balanceCount++;
            else 
                balanceCount--;
            if (balanceCount < 0) 
                return false;
        }

        balanceCount = 0;
        for (int i = inputString.length() - 1; i >= 0; i--) {
            if (lockStatus.charAt(i) == '0' || inputString.charAt(i) == ')') 
                balanceCount++;
            else 
                balanceCount--;
            if (balanceCount < 0) 
                return false;
        }

        return true;
    }
}