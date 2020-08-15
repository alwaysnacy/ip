public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        for (int i=0; i<20; i++) {
            System.out.print("-");
        }
        System.out.println();
        
        System.out.println("Hello! I'm Duke\n" + "What do you want to do today?");
        for (int i=0; i<20; i++) {
            System.out.print("-");
        }
        System.out.println();

        System.out.println("Bye. See you tomorrow!");
        for (int i=0; i<20; i++) {
            System.out.print("-");
        }
        System.out.println();

    }
}
