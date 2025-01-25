class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
    int sortArr[] = new int[nums.length];
    for(int i=0; i<nums.length; i++)
    sortArr[i] = nums[i];
    Arrays.sort(sortArr);

    HashMap<Integer, Integer> myGroup = new HashMap<>();
    HashMap<Integer, LinkedList<Integer>>groupMember = new HashMap<>();
    int groupKey = 0; 
    
    myGroup.put(sortArr[0], groupKey);
    groupMember.put(groupKey, new LinkedList<Integer>(Arrays.asList(sortArr[0])));

    for(int i=1; i<nums.length; i++)
    {
       if(Math.abs(sortArr[i]-sortArr[i-1])>limit)
       groupKey++;
       myGroup.put(sortArr[i], groupKey);
       
       if(!groupMember.containsKey(groupKey))
       groupMember.put(groupKey, new LinkedList<Integer>());

       groupMember.get(groupKey).add(sortArr[i]);
    }
   for(int i=0; i<nums.length; i++)
   {
     int currNum = nums[i];
     int groupNumber = myGroup.get(currNum);
     nums[i] = groupMember.get(groupNumber).pop();
   }
    return nums; 

    }
}