class CustomStack {
    ArrayList<Integer> list;
    int size;
    int currSize=0;

    public CustomStack(int maxSize) {
        list = new ArrayList<>();
        size = maxSize; 
    }
    
    public void push(int x) {
        if(currSize<size){
            list.add(x);
            currSize++;
        } 
        System.out.println(list);  
    }
    
    public int pop() {
        if(currSize!=0){
            currSize--;
            return list.remove(list.size()-1);
        }
        else{
            return -1;
        }
        
    }
    
    public void increment(int k, int val) {

         int count = 0;
         while(count<k && count<currSize){

            list.set(count,list.get(count)+val);
            count++;
         }
        
    }
}
