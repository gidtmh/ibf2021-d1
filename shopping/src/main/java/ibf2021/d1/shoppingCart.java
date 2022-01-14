package ibf2021.d1;

import java.util.Scanner;

public class shoppingCart
{
    public static void main(String[] args) {

        HandleCommands handler = new HandleCommands();
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Please use only the following commands: ");
        System.out.println("  add <item>");
        System.out.println("  delete <position of item>");
        System.out.println("  list");
        System.out.println("  exit");
        System.out.println("Welcome to your shopping cart");

        
        //instantiate a String variable labelled command to contain the next input after the user's input.
        String command = scan.next();
        String arguments = scan.nextLine();

        if (!"add".equals(command) && !"delete".equals(command) &&
                !"list".equals(command) && !"exit".equals(command)) {
            System.out.println("Invalid command, program will exit.");
            scan.close();
            return;
        }

        while (!"exit".equals(command)) {

            if ("add".equals(command)) {
                /*call method of handler class to take arguments from command, arguments and scan strings)
                values of the variables command, argument adn scan are being taken into the method parameters to run the code*/
                handler.handleAdd(command, arguments, scan);
                System.out.println("-- Item(s) added --");
            }

            if ("delete".equals(command)) {
                handler.handleDelete(command, arguments, scan);
                System.out.println("-- Item removed --");
            }
            
            if ("list".equals(command)) {
                handler.handleList(command);
                System.out.println("-- End of list --");
            }

            command = scan.next();
            arguments = scan.nextLine();
        }
       
        scan.close();
        System.out.println("Program has ended.");
    }
}