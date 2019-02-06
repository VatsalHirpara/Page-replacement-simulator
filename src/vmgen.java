import java.io.*;
public class vmgen {
    public static void main(String[] args) {
        int range =Integer.parseInt(args[0]);
        int len=Integer.parseInt(args[1]);
        String input_file= args[2];

        try{
            FileWriter wr = new FileWriter("vmrefs.dat");
            wr.write("5454445");
            wr.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
