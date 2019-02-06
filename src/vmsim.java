public class vmsim {
    public static void main(String[] args) {

       if (args.length!=3) {
            System.out.println("Enter command line arguments like shown below:");
            System.out.println("[total physical memory frames] [input_file] [page replacement algo]");
            System.out.println("For example :  vmsim 5 vmrefs.dat lru");
            System.exit(1);
            
       }
        int max_pfn = Integer.parseInt(args[0]);
        String input_file= args[1];
        String algo = args[2];



        
    }
}
