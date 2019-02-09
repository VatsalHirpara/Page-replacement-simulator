import java.util.*;
import java.io.*;

public class simulation_engine {
    public static void run(int max_pfn,String input_file,String algo,boolean flag) throws IOException {
        if(algo.equalsIgnoreCase("lru")){
            lru(max_pfn, input_file,algo,flag);
        }
        else if (algo.equalsIgnoreCase("fifo")){
            fifo(max_pfn, input_file,algo,flag);
        }
        else if (algo.equalsIgnoreCase("opt")){
            opt(max_pfn, input_file,algo,flag);
        }
    }

    private static void lru(int max_pfn,String input_file,String algo,boolean flag){

    }
// if (flag==true)
    private static void fifo(int max_pfn,String input_file,String algo,boolean flag) throws FileNotFoundException {
        Scanner in=null;
        in = new Scanner(new File(input_file));
        ArrayList<Integer> queue = new ArrayList<>();
        ArrayList<Integer> page_table = new ArrayList<>(max_pfn);
        int i=0;
        while(in.hasNextInt()){
            queue.add(in.nextInt());
        }

        int miss=0;
        for (int j = 0; j <queue.size() ; j++){

            if (flag) System.out.print(queue.get(j)+": ");
            if(page_table.indexOf(queue.get(j))==-1) {
                if(page_table.size()==max_pfn)miss++;
                if (page_table.size() < max_pfn) {
                    page_table.add(queue.get(j));
                    if (flag)print(page_table, max_pfn);
                } else {
                    page_table.set(i % max_pfn, queue.get(j));
                    if (flag)print(page_table, max_pfn);
                    i++;
                }
                if (flag)System.out.println("  F");

            }
            else{
                if (flag)print(page_table, max_pfn);
                if (flag)System.out.println("");
            }
        }
        float miss_rate=(float) miss/(queue.size()-max_pfn);
        System.out.printf("Miss rate = %d / %d = %.2f %% \n",miss,queue.size()-max_pfn,miss_rate*100);
    }

    private static void opt(int max_pfn,String input_file,String algo,boolean flag){

    }



    private static void print(ArrayList<Integer> list, int max_pfn){
        int n =list.size(),temp,diff;
        System.out.print("[");
        for(int i=0;i<n;i++){
            temp=list.get(i);
            if(temp%10==temp) System.out.print(" ");
            System.out.print(temp);
            if(i<n-1) System.out.print("|");
        }

        diff=max_pfn-n;
        if(max_pfn>n){
            while(diff-->0) {
                System.out.print("| ");
            }
        }
        System.out.print("]");
       // System.out.println("");
    }


    private static void printToFile(LinkedList<Integer> list, int max_pfn,String out_file) throws IOException    {

        FileWriter fw = new FileWriter(out_file, true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter out = new PrintWriter(bw);

        int n =list.size(),temp,diff;
        out.print("[");
        for(int i=0;i<n;i++){
            temp=list.get(i);
            if(temp%10==temp) out.print(" ");
            out.print(temp);
            if(i<n-1)out.print("|");
        }

        diff=max_pfn-n;
        if(max_pfn>n){
            while(diff-->0) {
                out.print("| ");
            }
        }
        out.println("]");
        out.close();
    }

}