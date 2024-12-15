class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {        
        int n=classes.length;
        PriorityQueue<double[]> pq=new PriorityQueue<>((a,b)->Double.compare(b[0], a[0]));


        double sumVal=0;      
        double result=0;

        for(int i=0; i<n;  i++){
            double val1=(double)classes[i][0]/classes[i][1];
            double val2=(double)(classes[i][0]+1)/(classes[i][1]+1);
            double val=val2-val1;
            pq.add(new double[]{val, i});
            sumVal +=val1;
        }

       

        for(int j=0; j<extraStudents; j++){
            double[] que=pq.poll();
            double val=que[0];
            int i=(int)que[1];
            
            sumVal +=val;
            classes[i][0]+=1;
            classes[i][1]+=1;

            double val1=(double)classes[i][0]/classes[i][1];
            double val2=(double)(classes[i][0]+1)/(classes[i][1]+1);
            val=val2-val1;
            pq.add(new double[]{val, i});

            result=Math.max(result,sumVal);
        }

        return result/n;
    }
}