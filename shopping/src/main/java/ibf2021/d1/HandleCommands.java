package ibf2021.d1;

import java.util.Scanner;

public class HandleCommands 
{
    private Cart cart;

    //constructor to pass an instance of the Cart class into this handlecommands class
    public HandleCommands() {
        cart = new Cart();
    }

    public Cart getCart() {
        return cart;
    }

    public void handleAdd(String command, String arguments, Scanner scan) {
        
        while ("add".equals(command)) {//as long as the scanner line contains "add" in the string

            //the Array will trim the arguments
            String [] strArray = arguments.trim().split(",");

            while ("".equals(arguments.trim())) {
                System.out.println("Please add an item " +
                        "or items separted with a comma");
                command = scan.next();
                arguments = scan.nextLine();
                arguments.trim().split(",");
            }

            strArray = arguments.trim().split(",");

            for (int i = 0; i < strArray.length; i++) {
                
                if (cart.getCart().contains(strArray[i].trim())) {
                    System.out.println("You have " + 
                            strArray[i] + " in your cart");
                    continue;
                }

                cart.addItem(strArray[i].trim());
                System.out.println(strArray[i] + " added to the cart");
            }

            break;
        }
    }

    /* public void handleAdd2(String command, String arguments, Scanner scan) {
        String [] strArray = arguments.trim().split(",");
        for (int i = 0; i < strArray.length; i++) {
                
            if (cart.getCart().contains(strArray[i].trim())) {
                System.out.println("You have " + 
                        strArray[i] + " in your cart");
                continue;
            }
            cart.addItem(strArray[i].trim());
            System.out.println(strArray[i] + " added to the cart");
        }
    } */

    public void handleDelete(String command, String arguments, Scanner scan) {
        
        while ("delete".equals(command)) {

            int position = -1;

            while (position == -1) {

                try {
                    //set the position to fetch the string inside the argument variable which came from the user and parse it as an Integer, and trim the white space around it
                    position = Integer.parseInt(arguments.trim());
                    //sets the position to match the index number of the fruit
                    position = position -1;
                } catch (NumberFormatException nfe) {
                    System.out.println("Please provide a number");
                }

                if (!(position < 0) && position < cart.numberOfItemsInCart()) {
                    String item = cart.deleteItem(position);
                    System.out.println(item + " removed from cart");
                    break;
                }

                System.out.println("Incorrect item index");
                position = -1;
                command = scan.next();
                arguments = scan.nextLine();
            }

            break;
        }
    }

    public void handleList(String command){

        while ("list".equals(command)) {

            if (cart.numberOfItemsInCart() == 0) 
                System.out.println("Your cart is empty");
            
            for (int i = 0; i < cart.getCart().size(); i++)
                System.out.println("" + (i+1) + "." + cart.getCart().get(i));

            break;
        }
    }
}