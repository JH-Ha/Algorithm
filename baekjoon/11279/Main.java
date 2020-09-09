import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int i = 0; i < n; i ++){
            int x;
            x = Integer.parseInt(br.readLine());
           // System.out.println(x);
            if(x == 0){
                if(pq.isEmpty()){
                    bw.write(Integer.toString(0) + '\n');
                    //System.out.println(0);
                }else{
                    bw.write(Integer.toString(-pq.poll())+ '\n');
                    //System.out.println(-pq.poll());
                }
            } else{
                pq.add(-x);
            }
        }
        bw.flush();
        br.close();
        bw.close();
        //sc.close();
    }
}