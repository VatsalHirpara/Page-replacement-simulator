import java.io.*;

public class vmstats {
    public static void main(String[] args) throws IOException {
        int min_frame = Integer.parseInt(args[0]);
        int max_frame = Integer.parseInt(args[1]);
        int increment = Integer.parseInt(args[2]);
        String input_file = args[3];


        PrintWriter writer = new PrintWriter("vmrates.dat");
        writer.print("");
        writer.close();
        FileWriter fw = new FileWriter("vmrates.dat", true);
        BufferedWriter bw = new BufferedWriter(fw);
        for (int i = min_frame; i <=max_frame ;i+= increment ) {
            bw.write(Integer.toString(i));
            bw.write(" ");
        }
        bw.write("\n"); bw.flush();



        for (int i = min_frame; i <=max_frame ;i+= increment ) {
            System.out.print("opt, " + i + " frames :");
            simulation_engine.run(i,input_file,"opt",false);
        }
        System.out.println("");
        bw.write("\n"); bw.flush();

        for (int i = min_frame; i <=max_frame ;i+= increment ) {
            System.out.print("lru, " + i + " frames :");
            simulation_engine.run(i,input_file,"lru",false);
        }
        System.out.println("");
        bw.write("\n"); bw.flush();

        for (int i = min_frame; i <=max_frame ;i+= increment ) {
            System.out.print("fifo, " + i + " frames :");
            simulation_engine.run(i,input_file,"fifo",false);
        }
    }


}
