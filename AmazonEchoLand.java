package amazonecho;

/**
 * November 25, 2017
 * @author walter acevedo
 * "client" class creates a new instance of an Amazon Echo; Echo Dot.
 */
public class AmazonEchoLand {
    
    public static AmazonEcho echoDot;
    
    public static void main(String[] args) {
        System.out.println("Your Amazon Echo Dot is activated.");
        System.out.println("");
        
        // creates a new instance of the AmazonEcho object.
        echoDot = new AmazonEcho();        
        startOperation();
        
        System.out.println("");
        System.out.println("You Amazon Echo Dot is deactivated.");
        
    } // close main()
    
    public static void startOperation() {
        String action = " ";
        System.out.println("Enter a command. For a list of commands enter "
                + "\"Alexa Commands\"");
        System.out.println("Enter \"Alexa Stop\" to end operation.");
        System.out.println("");
        // while loop asks user for a command until "alexa stop" is entered.
        while (!action.equals("alexa stop")) {
            action = echoDot.getCommand();
        } // end while
            
    } // close startOperation()
    
} // close AmazonEchoLand class
