class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        HashSet<Integer> hashSet = new HashSet<>();
		
		for(int num : arr)
			hashSet.add(num);
		
		int answer = 0;
		
		for(int i=0;i<arr.length;i++) {			
			for(int j=i+1;j<arr.length;j++) {	
                int firstNum = arr[i];			
				int secondNum = arr[j];
				int sum = firstNum+secondNum;
				int count = 2;
				while(hashSet.contains(sum)) {
					count++;
					firstNum = secondNum;
					secondNum = sum;
					sum = firstNum+secondNum;
				}
				answer = Math.max(answer, count);
			}
		}
		
		return answer == 2 ? 0 : answer;
    }
}