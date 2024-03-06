// WE ARE GOING TO BUILD RAILWAY RESERVATION 

// The Train represents a train in our railway system and encapsulates the following attributes:        
// name, departure time, source station, destination station, passenger strength, and train number.
// - The Train and the passenger details class holds information about booked tickets, 
// including the selected train, passenger names, and seat numbers.

// The railway reservation system and encompasses the following functionalities:
// * Display available trains based on source and destination.
// * Check seat availability for a specific train.
// * Book a ticket.
// * Cancel a ticket.
// * Display ticket details.

// create main class and try to create a overall structure component and try to complete getter and setter methods with user input using switch case to access all the methods.






// package RailwaySystem;

// class TrainSeat extends Train{
    
    

// }




// use a array of objects of passenger class(u can also extend to anther class) and store the passenger details for each object in the allocated seat

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

class Train {
    private final String name;//
    public final int train_number;//
    private String departure_time;//
    private String source_station;//
    private int passenger_strength;//
    private String destination_Station;//


    public String getDestination_Station() {
        return destination_Station;
    }
    public void setDestination_Station(String destination_Station,String username) {
        if(username.equals("ticketcollector")){
            this.destination_Station=destination_Station;
        }
        else{
            System.out.println("Acesss denied");
            return;
        }
    }
    public String getDeparture_time() {
        return departure_time;
    }
    public String getName() {
        return name;
    }
    public void setDeparture_time(String departure_time,String username) {
        if(username.equals("ticketcollector")){
            this.departure_time=departure_time;
        }
        else{
            
            System.out.println("Acesss denied");
            return;
        }
    }
    public String getSource_station() {
        return source_station;
    }
    public void setSource_station(String source_station,String username) {
        if(username.equals("ticketcollector")){
            this.source_station = source_station;return;
            
        }
        else{
            System.out.println("Acesss denied");
            return ;
        }
    }
    public int getPassenger_strength(String username) {
        if(username.equals("ticketcollector")){
            
            return passenger_strength;
        }
        else{
            System.out.println("Acesss denied");return -1;
        }
    }
    public void setPassenger_strength(int passenger_strength,String username) {
        if(username.equals("ticketcollector")){
            this.passenger_strength = passenger_strength;
        }
        else{
            System.out.println("Acesss denied");
        }
        
    }

    public Train(String name, int train_number,String departure_time,String source_station,String destination_station,String username) {
        if(username.equals("ticketcollector")){
            this.name = name;
            this.train_number = train_number;
            this.passenger_strength=0;
            this.departure_time=departure_time;
            this.destination_Station=destination_station;
            this.source_station=source_station;
        }
        else{
            System.out.println("Acesss denied");
            this.name = "";
            this.train_number = -1;
        }
    }


    // Train Seat details 

    public Passenger_details [][][] seat = new Passenger_details[3][3][3];
    private boolean arr [][][] = new boolean[3][3][3];
    private int i=0,j=0,k=0;

    public boolean isavailable(int i,int j,int k){
        if(this.arr[i][j][k]){
            return false;
        }
        else{
            return true;
        }
    }


        public int[] bookSeat(Passenger_details obj){
        if(isavailable(this.i, this.j, this.k)){
            obj.setSeatnumber(new int[]{this.i, this.j, this.k});
            this.seat[i][j][k] = obj;
            this.arr[i][j][k] = true;
            // System.out.println("i ="+i+"j= "+j+"k= "+k);
        // System.out.println(String.format("the bookseat number func is: %d %d %d",this.seat[i][j][k].getSeatnumber()[0],this.seat[i][j][k].getSeatnumber()[1],this.seat[i][j][k].getSeatnumber()[2]));
            int[] temp = {i,j,k};
            incrementIndices();
            setPassenger_strength(passenger_strength+1,"ticketcollector".toLowerCase());
            return temp;
        } 
        else {
            System.out.println("Seats are full");
            return null;
        }
    }

    private void incrementIndices() {
        this.k++;
        if(this.k >= 3) {
            this.k = 0;
            this.j++;
            if(this.j >= 3) {
                this.j = 0;
                this.i++;
                if(this.i >= 3) {
                    // System.out.println("All seats are booked.");
                    return;
                }
            }
        }
}
    @Override
    public String toString() {
        return "Train [name=" + name + ", train_number=" + train_number + ", departure_time=" + departure_time
                + ", source_station=" + source_station + ", passenger_strength=" + passenger_strength
                + ", destination_Station=" + destination_Station + "]";
    }

}

class Passenger_details{
    private String passenger_name;
    private short passenger_age;
    private String passenger_gender;
    private String passenger_destination;
    private String passenger_source;
    private int []seatnumber = new int[3];  // false --> seat empty    true --> seat full


    public int[] getSeatnumber() {
        return seatnumber;
    }

    public void setSeatnumber(int[] seatnumber) {
        // System.out.println(String.format("inside func the getseatnumber func number is: %d%d%d",seatnumber[0],seatnumber[1],seatnumber[2]));
        this.seatnumber[0] = seatnumber[0];
        this.seatnumber[1] = seatnumber[1];
        this.seatnumber[2] = seatnumber[2];

    }

    public String getPassenger_source(String username) {
        if(username.equals("ticketcollector")|| username.equals("customer")){
            return passenger_source;
        }
        else{
            
            System.out.println("Acesss denied");
            return "-1";
        }
        
    }

    public void setPassenger_source(String passenger_source,String username) {
        if(username.equals("ticketcollector")|| username.equals("customer")){
            this.passenger_source = passenger_source;
        }
        else{
            System.out.println("Acesss denied");
            return;
        }
    }

    public String getPassenger_destination(String username) {
        if(username.equals("ticketcollector")|| username.equals("customer")){
            return passenger_destination;
        }
        else{
            
            System.out.println("Acesss denied");
            return "-1";
        }
        
    }

    public void setPassenger_destination(String passenger_destination,String username) {
        if(username.equals("ticketcollector")|| username.equals("customer")){
            this.passenger_destination = passenger_destination;
        }
        else{
            System.out.println("Acesss denied");
            return;
        }
        
    }

    public String getPassenger_gender(String username) {
        if(username.equals("ticketcollector")|| username.equals("customer")){
            return passenger_gender;
        }
        else{
            
            System.out.println("Acesss denied");
            return "-1";
        }
        
    }

    public void setPassenger_gender(String passenger_gender,String username) {
        if(username.equals("ticketcollector")|| username.equals("customer")){
            this.passenger_gender = passenger_gender;
        }
        else{
            System.out.println("Acesss denied");
            return;
        }
        
    }

    public short getPassenger_age(String username) {
        if(username.equals("ticketcollector")|| username.equals("customer")){
            return passenger_age;
        }
        else{
            
            System.out.println("Acesss denied");
            return -1;
        }
        
    }

    public void setPassenger_age(short passenger_age,String username) {
        if(username.equals("ticketcollector")|| username.equals("customer")){
            this.passenger_age = passenger_age;
        }
        else{
            
            System.out.println("Acesss denied");
            return;
        }
        
    }

    public String getPassenger_name(String username) {
        if(username.equals("ticketcollector")|| username.equals("customer")){
            return passenger_name;
        }
        else{
            
            System.out.println("Acesss denied");
            return "-1";
        }
        
    }

    public void setPassenger_name(String passenger_name,String username) {
        if(username.equals("ticketcollector")|| username.equals("customer")){
            this.passenger_name = passenger_name;
        }
        else{
            System.out.println("Acesss denied");
            return;
        }
        
    }

}

public class Railway {
    public static void main(String[] args) {
        // System.out.println("in railway");
        
        // Passenger_details obj=new Passenger_details();
        // Train tr = new Train("tn express", 123, "ticketcollector".toLowerCase());
        // obj.setPassenger_age((short)19 ,"ticketcollector".toLowerCase());
        // obj.setPassenger_name("Farhaan", "ticketcollector".toLowerCase());
        // Passenger_details obj1=new Passenger_details();
        // obj1.setPassenger_age((short)19 ,"ticketcollector".toLowerCase());
        // obj1.setPassenger_name("Ezhil", "ticketcollector".toLowerCase());
        // Passenger_details obj2=new Passenger_details();
        // obj2.setPassenger_age((short)19 ,"ticketcollector".toLowerCase());
        // obj2.setPassenger_name("Aravind", "ticketcollector".toLowerCase());
        // Passenger_details obj3=new Passenger_details();
        // obj3.setPassenger_age((short)19 ,"ticketcollector".toLowerCase());
        // obj3.setPassenger_name("Aravind2", "ticketcollector".toLowerCase());
        // Passenger_details obj4=new Passenger_details();
        // obj4.setPassenger_age((short)19 ,"ticketcollector".toLowerCase());
        // obj4.setPassenger_name("Aravind3", "ticketcollector".toLowerCase());
        // tr.bookSeat(obj);
        // tr.bookSeat(obj1);
        // tr.bookSeat(obj2);
        // tr.bookSeat(obj3);
        // tr.bookSeat(obj4);
        // String temp = tr.seat[0][1][1].getPassenger_name("customer");
        // // int[] arr = tr.seat[0][0][0].getSeatnumber();
        // System.out.println("the name is :"+temp);
        // System.out.println(String.format("the seat number is: %d %d %d",tr.seat[0][1][1].getSeatnumber()[0],tr.seat[0][1][1].getSeatnumber()[1],tr.seat[0][1][1].getSeatnumber()[2]));


        short choice =-1;
        String username ="";
        Scanner in = new Scanner(System.in);
        HashMap<String,Train> trainHash = new HashMap<>();
        trainHash.put("Tamil Nadu Express", new Train("Tamil Nadu Express", 1121,"1:30 pm","Chennai central","Coimbatore central", "ticketcollector".toLowerCase()));
        trainHash.put("Mumbai Express", new Train("Mumbai Express", 1122,"4:00 pm","Chennai central","Coimbatore central", "ticketcollector".toLowerCase()));
        trainHash.put("Delhi Express", new Train("Delhi Express", 1123,"12:00 pm","Chennai central","Coimbatore central", "ticketcollector".toLowerCase()));
        System.out.println("Wellcome to Indian Railway System");
        System.out.println("Enter your username :");
        username= in.nextLine();username=username.toLowerCase();
        do{
            System.out.println("Enter the Number based on the operation You want to perform:");
            System.out.println("1. Display the available train based on source and destination stations");
            System.out.println("2. Display Check seat availability based on Train no.");
            System.out.println("3. Book seat for a specific train");

            System.out.println("9. To exit from the progam");
            choice=in.nextShort();
            // Iterator<String,String> it = trainHash.entrySet().iterator();
            if(choice==1){
                System.out.println("Enter the source Station");
                in.nextLine();
                String source=in.nextLine();
                System.out.println("Enter the destination Station");
                String destination=in.nextLine();
                // System.out.println("this is the source "+source+"this is the destination "+destination);
                ArrayList<Train> arr= new ArrayList<>();
                for(Train tp: trainHash.values()){
                    if(tp.getSource_station().toLowerCase().equals(source.toLowerCase())){
                        arr.add(tp);
                    }
                }
                // System.out.println(arr);
                if(arr.isEmpty()){
                    System.out.println("Sorry no train are available");
                }
                else{
                    System.out.println(String.format("the available trains from %s to %s are:",source.toLowerCase(),destination.toLowerCase()));
                    for(Train tp: arr){
                        System.out.println(String.format("Train name: %s Train depature time: %s Train number: %d",tp.getName(),tp.getDeparture_time(),tp.train_number));
                    }
                }
            }
            else if(choice==2){
                System.out.println("Enter the train number:");
                int trno=in.nextInt();
                int totalseat=25;
                int availableseat=0;
                String trainname="Train not found";
                for(Train tp: trainHash.values()){
                    if(tp.train_number==trno){
                        availableseat=totalseat-tp.getPassenger_strength("ticketcollector");
                         trainname= tp.getName();
                    }
                }
                if(trainname=="Train not found"){
                    System.out.println("Sorry u entered the wrong train number!");
                }
                else{
                    System.out.println("The avalable seat's in "+trainname+" are :"+availableseat);
                }
            }
            else if(choice==3){
                System.out.println("Wellcome to the booking section");
                System.out.println("Enter the train number in to book seat :");
                int trno=in.nextInt();
                int totalseat=25;
                int availableseat=0;
                Train train=null;
                for(Train tp: trainHash.values()){
                    if(tp.train_number==trno){
                        availableseat=totalseat-tp.getPassenger_strength("ticketcollector");
                         train=tp;
                    }
                }
                if(train==null){
                    System.out.println("Sorry u entered the wrong train number!");
                }
                else{
                    if(availableseat==0){
                        System.out.println("The seat's are full");
                    }
                    else{
                        Passenger_details obj = new Passenger_details();
                        System.out.println("Enter your name :");
                        obj.setPassenger_name(in.nextLine(), username);
                        in.nextLine();
                        System.out.println("Enter your age:");
                        obj.setPassenger_age(in.nextShort(), username);
                        in.nextLine();
                        System.out.println("Enter your gender :");
                        obj.setPassenger_gender(in.nextLine(),username);
                        obj.setPassenger_destination(train.getDestination_Station(), username);
                        obj.setPassenger_source(train.getSource_station(),username);
                        int [] pass_seat_number=train.bookSeat(obj);
                        System.out.println(String.format("your seat number is %d %d %d",pass_seat_number[0],pass_seat_number[1],pass_seat_number[2]));
                        System.out.println("Your seat has been booked succesfully!");
                    }
                }
            }
        }while(choice!=9);
        if(choice==9){
            System.out.println("you have succesfully exited the Railway system program");
        }
        in.close();
      //add new features to show ticket details and cancel a ticket.
      //testing git clone from windows
    }
    
}
