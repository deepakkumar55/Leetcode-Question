class Solution {
    public int findMinDifference(List<String> timePoints) {
        int size = timePoints.size();
        int [][] timePts = new int[size][2];
        
        for(int indx = 0; indx < size; indx++) {
            timePts[indx] = parseTime(timePoints.get(indx));
        }
        
        Arrays.sort(timePts, (a, b) -> {
            if(a[0] == b[0]) {
                return a[1] - b[1];
            } else return a[0] - b[0];
        });
        
        int minDiff = Integer.MAX_VALUE;
        for(int indx = 1; indx < size; indx++) {
            int currDiff = calculateDifference(timePts[indx-1], timePts[indx]);
            minDiff = Math.min(currDiff, minDiff);
        }
        
        int wrapDiff = calculateDifference(timePts[size-1], new int[]{timePts[0][0] + 24, timePts[0][1]});
        minDiff = Math.min(wrapDiff, minDiff);
        
        return minDiff;
    }
    
    private int[] parseTime(String Time) {
        String[] timeStmp = Time.split(":");
        int[] res = new int[2];
        res[0] = Integer.parseInt(timeStmp[0]);
        res[1] = Integer.parseInt(timeStmp[1]);
        return res;
    }
    
    private int calculateDifference(int[] prevTime, int[] currTime) {
        return (currTime[0] * 60 + currTime[1]) - (prevTime[0] * 60 + prevTime[1]);
    }
}