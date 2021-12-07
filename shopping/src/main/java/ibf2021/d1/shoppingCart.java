package ibf2021.d1;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Iterator;

public class shoppingCart {
    public static void main( String[] args )
    {
        HashMap<Integer, String> cart = new HashMap<>();
        String userinput = "";
        String [] inputArray;
        Scanner input = new Scanner(System.in);
        Integer fruitIndex = 1;

        while((!"add".equals(userinput))|| (!"delete".equals(userinput)) || (!"list".equals(userinput))){
            System.out.println("Welcome to your shopping cart" + "\n");
            userinput = input.next();
            
            if("list".equals(userinput)){
            if(cart.isEmpty()){
                        System.out.println("Your cart is empty!"+ "\n");
            } else if(!cart.isEmpty()){
                for (Integer i: cart.keySet()){
                    System.out.println(i + ". " + cart.get(i));
                }
            }

            }
            if (userinput.startsWith("add")){
                    //ask user for next input
                    //set pointer to the first string character after "add" command
                    userinput = input.nextLine();
                    //separate value of userinput by comma
                    inputArray = userinput.split(",");
                    //increment fruitID to set the numbers
                    for (int i = 0; i < inputArray.length;i++){
                        cart.put(fruitIndex, inputArray[i]);
                        fruitIndex++;
                    }
                    System.out.println("You added" + userinput + " to your cart." + "\n");
                    //list hashmap as table
                    for (Integer i: cart.keySet()){
                        System.out.println(i + ". " + cart.get(i));
                    }
            }
            if (userinput.startsWith("delete")){
                userinput = input.nextLine().trim();
                int x = Integer.parseInt(userinput);
                System.out.println(cart.get(x) + " removed from cart");
                cart.remove(x);
                for (HashMap.Entry<Integer, String> en :
                        cart.entrySet()) {
                            fruitIndex = en.getKey();
                            fruitIndex--;
                        System.out.println(en.getKey()
                                        + ". "
                                        + en.getValue());
        }

                    
                }


                
            }
            
        }
    
    }



