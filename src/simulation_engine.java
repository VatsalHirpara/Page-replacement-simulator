import java.util.*;
import java.io.*;
public class simulation_engine {
    public static void run(int max_pfn,String input_file,String algo) throws IOException {
        if(algo.equalsIgnoreCase("lru")){
            lru(max_pfn, input_file,algo);
        }
        else if (algo.equalsIgnoreCase("fifo")){
            fifo(max_pfn, input_file,algo);
        }
        else if (algo.equalsIgnoreCase("opt")){
            opt(max_pfn, input_file,algo);
        }
    }

    private static void lru(int max_pfn,String input_file,String algo){

    }

    private static void fifo(int max_pfn,String input_file,String algo)  {

    }

    private static void opt(int max_pfn,String input_file,String algo){}


    private static void print(LinkedList<Integer> list, int max_pfn){
        int n =list.size(),temp,diff;
        System.out.print("[");
        for(int i=0;i<n;i++){
            temp=list.get(i);
            if(temp%10==temp) System.out.print(" ");
            System.out.print(temp);
            if(i<n-1)System.out.print("|");
        }

        diff=max_pfn-n;
        if(max_pfn>n){
            while(diff-->0) {
                System.out.print("| ");
            }
        }
        System.out.println("]");
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