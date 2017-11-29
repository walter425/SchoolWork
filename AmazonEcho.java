package amazonecho;

import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.text.DateFormat;

/**
 * November 22, 2017
 * @author walter acevedo
 * This "blueprint" class models an Amazon Echo capable of getting 
 * instructions from user and display responses.
 */
public class AmazonEcho {
    final int MAX_VOLUME = 10;
    final int MAX_TEMPERATURE = 90;
    final String KEYWORD = "alexa";
    private boolean lightIsOn = false;
    private String command;
 
    // method to get command from user and Amazon Echo will identify
    // if user is using the keyword specified above.
    public String getCommand() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Command: ");
        command = scan.nextLine();
        String lowercasecommand = command.toLowerCase();
        
        // search in the string if the keyword is present, returning value 0.
        int searchresult = lowercasecommand.indexOf(KEYWORD);
        
        // if keyword is found, switch will look for a command word after
        // keyword and execute the proper method.
        if (searchresult == 0) {
            // example of .split method taken from:
            // http://javadevnotes.com/java-string-split-tutorial-and-examples
            String arr[] = command.split(" ");
            switch(arr[1].toLowerCase()) {
                    case "volume":
                        increaseVolume();
                        break;
                    case "weather":
                        announceWeatherReport();
                        break;
                    case "temperature":
                        controlThermostat();
                        break;
                    case "lights":
                        controlRoomLights();
                        break;
                    case "time":
                        displayTime();
                        break;
                    case "commands":
                        displayCommands();
                        break;
                    case "stop":
                        break;
                    default:     
                        System.out.println("Invalid command");
            } // end switch
        } else { 
            System.out.println("Invalid keyword");
        } // end if/else
        return command;
    } // close getCommand()
    
    // user will indicate the volume level, which should be between 0 and 
    // MAX_VOLUMEN
    public void increaseVolume() {
        int volume = -1;
        while (volume < 0 || volume > MAX_VOLUME) {
            Scanner scan = new Scanner(System.in);
            System.out.print("Enter volume level (0-10): ");
            volume = scan.nextInt();
            if (volume >= 0 && volume <= MAX_VOLUME) {
                System.out.println("Volume is set to " + volume + ".");
            } else {
                System.out.println("Volume must be specified from 0 to " +
                        MAX_VOLUME + ".");
            } // end if/else
        } // end while
    } // close increaseVolume()
    
    // Weather method will display current weather conditions in Pittsburgh.
    public void announceWeatherReport() {
        System.out.println("In Pittsburgh, it's 40 degrees and raining.");
    } // close announceWeatherReport()
    
    // Thermostat methot will scanner user for desired room temperature, 
    // provided is within the range of 0 and MAX_TEMPERATURE declared above.
    public void controlThermostat() {
        int temperature = -1;
        while (temperature < 0 || temperature > MAX_TEMPERATURE) {
            Scanner scan = new Scanner(System.in);
            System.out.print("Enter temperature level (0-90 degrees): ");
            temperature = scan.nextInt();
            if (temperature >= 0 && temperature <= MAX_TEMPERATURE) {
                System.out.println("Heater is set to " + temperature + " "
                        + "degrees.");
            } else {
                System.out.println("Temperature must be specified from 0 to " +
                        MAX_TEMPERATURE + ".");
            } // end if/else
        } // end while
    } // close controlThermostat()
    
    // lights method asks user to switch light on or off. In case the light
    // is on and user wants to turn it on again, the method will advice that.
    // Same if light is already off and user tries to turn it off.
    public void controlRoomLights() {
        String lightSwitch = " ";
        while (!lightSwitch.equals("on") && !lightSwitch.equals("off")) {
            Scanner scan = new Scanner(System.in);
            System.out.print("Light switch (on/off): ");
            lightSwitch = scan.nextLine();
            switch (lightSwitch.toLowerCase()) {
                case "on":
                    if (lightIsOn)
                        System.out.println("The light is already on.");
                    else {
                        lightIsOn = true;
                        System.out.println("The light is on.");
                    }
                    break;
                case "off":
                    if (lightIsOn) {
                        lightIsOn = false;
                        System.out.println("The light is off.");
                    } else
                        System.out.println("The light is already off.");
                    break;
                default:
                    System.out.println("Invalid switch mode.");
                    break;
            } // end switch
        } // end while
    } // close controlRoomLights()
    
    // displayTime method displays the current time in 12hr format.
    // example of the method taken from:
    // https://beginnersbook.com/2013/05/current-date-time-in-java/
    public void displayTime() {
        DateFormat df = new SimpleDateFormat("hh:mm aa");
        Calendar calobj = Calendar.getInstance();
        System.out.print("The time is ");
        System.out.println(df.format(calobj.getTime()));
    } // close displayTime()
    
    // This method displays the current commands available for the Echo
    // to perform.
    public void displayCommands() {
        String commandArr[] = {"Volume", "Weather", "Lights", "Temperature",
            "Time", "Commands", "Stop"};
        System.out.println("Enter the keyword \""+KEYWORD+"\", followed"
                + "by any of these commands.");
        for (String i: commandArr) {
            System.out.println(i);
        } // end for
    } // close displayCommands()
    
} // close AmazonEcho class
