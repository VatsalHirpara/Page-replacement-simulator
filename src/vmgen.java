import java.io.*;
public class vmgen {
    public static void main(String[] args) {
        int range =Integer.parseInt(args[0]);
        int len=Integer.parseInt(args[1]);
        String input_file= args[2];

        BufferedWriter wr=null;
        try{
             wr = new BufferedWriter(new FileWriter(input_file));
             int temp1=0,temp2;
             for(int i =1 ;i<=len;i++){
                 temp2= (int) (Math.random()*range);
                 if(i==1) temp1=temp2;

                 while(temp1==temp2){
                     temp2= (int) (Math.random()*range);
                 }
                 temp1=temp2;
                 wr.write(String.valueOf(temp2));
                 wr.write(" ");
             }
            wr.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
