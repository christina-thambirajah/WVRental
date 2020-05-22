/**This class contains the main method which the console runs on and all the attributes necessary for the
 * application to be managed. 4 lists are used to extract all related information form the datbase and the are used
 * to perform the vairious taskes given to the manager. Function to open the GUI is also availablein the main menu of this
 * Console.
 * */

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;
import java.awt.Desktop;

public class WVR_Manager implements VR_Manager {
    //These lists are used to access the details saved in the datbase and perform certain functions on them
    private List<Car> car_list = new ArrayList<>( );
    private List<Motor_Bike> bike_list= new ArrayList<>( );
    private List<Customer> cust_list= new ArrayList<>( );
    private List<Schedule> sch_list= new ArrayList<>( );
    //default constructor
    public WVR_Manager() {

    }
    public static void main(String[] args) {
        WVR_Manager manager = new WVR_Manager();
        //main menu provides option between access to console and GUI
        manager.mainMenu();
    }
    Scanner sc = new Scanner( System.in );
    /**An EntityManagerFactory is constructed for a certain database,
     *  and by managing resources efficiently (e.g. a pool of sockets),
     *  Allows to create many entity mangaers.
    */
     public static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory( "NewPersistenceUnit" );

    //Car functions
    public void addCar(Car car) {
        car_list.add( car );
        //car object will be added to the list.
        System.out.println( "The Car has been added to database" );
        carMenu();
    }
    public void deleteCar() {
        Car carObject = null;
        System.out.println("Enter the licence plate Number of the car to delete. ");
        String plate_Number = sc.nextLine();

        for (Car car : car_list) {
            if (plate_Number.equals(car.getPlate_Number())) {
                //process of obtaining the car object with the specific primary key
                carObject = car;
            }
        }
        System.out.println(carObject);
        //here car object will be removed from the list
        car_list.remove(carObject);
        System.out.println("This car has been deleted");
        carMenu();
    }

    public void updateCar() {
        Car carObject = null;
        System.out.println("Enter the licence plate Number of the car to update. ");
        String LicencePNumber = sc.nextLine();
        //finding the object car with this plate number
        for (Car car : car_list) {
            if (LicencePNumber.equals(car.getPlate_Number())) {
                carObject = car;
            }
        }
        if (carObject==null){
            //if the car is not available in the datbase
            System.out.println("No such car is in the database.");
            carMenu();
        }
        else {
            //displaying cardetauils befor update
            System.out.println( carObject );
        }
        car_list.remove(carObject);
        //car is removed form the list
        addCar(getCarDetails());
        //car is added with new details or updated.
        System.out.println("Car has been updated");

        carMenu();
    }
    public void searchCar() { Car carObject = null;
        System.out.println("Enter the licence plate Number of the car to delete. ");
        String plate_Number = sc.nextLine();

        for (Car car : car_list) {
            //finding th car opject
            if (plate_Number.equals(car.getPlate_Number())) {
                carObject = car;
            }
        }
        if (carObject==null){
            System.out.println("No such car is in the database.");
        }
        else {
            //display
            System.out.println( carObject );
        }
        carMenu();
    }

    //bike functions
    public void addMotorBike(Motor_Bike bike) {
        bike_list.add( bike );
        //motorbike object is added to the list form the database
        System.out.println( "The Motorbike has been added to database" );
        bikeMenu();
    }
    public void deleteMotorBike() {
        Motor_Bike bikeObject = null;
        System.out.println("Enter the licence plate Number of the bike to delete. ");
        String plate_Number = sc.nextLine();

        for (Motor_Bike motor_bike : bike_list) {
            if (plate_Number.equals(motor_bike.getPlate_Number())) {
                //finding the related motorbike objects
                bikeObject = motor_bike;
            }
        }
        System.out.println(bikeObject);
        //removing the motorbike object from the list
        bike_list.remove(bikeObject);
        System.out.println("This bike has been deleted");
        bikeMenu();
    }
    public void updateMotorBike() {
        Motor_Bike bikeObject = null;
        System.out.println("Enter the licence plate Number of the bike to update. ");
        String plate_Number = sc.nextLine();

        for (Motor_Bike motor_bike : bike_list) {
            if (plate_Number.equals(motor_bike.getPlate_Number())) {
                //finding the motorbike object
                bikeObject = motor_bike;
            }
        }
        if (bikeObject==null){
            // When there is no such plate number
            System.out.println("No such bike is in the database.");
            bikeMenu();
        }
        else {
            System.out.println(bikeObject);
        }
        //remove bike from list
        bike_list.remove(bikeObject);
        addMotorBike( getMotorbikeDetails() );
        // add the new details of the bike and update
        System.out.println("This bike has been updated");
        bikeMenu();
    }
    public void searchMotorBike() {
        Motor_Bike bikeObject = null;
        System.out.println("Enter the licence plate Number of the bike to search. ");
        //find the related object with licence plate number
        String plate_Number = sc.nextLine();

        for (Motor_Bike motor_bike : bike_list) {
            if (plate_Number.equals(motor_bike.getPlate_Number())) {
                //
                bikeObject = motor_bike;
            }
        }
        System.out.println(bikeObject);
        bikeMenu();
    }

    //rental Functions
    public void searchRental() {
        Schedule rentalObject = null;
        System.out.println("Enter the BookingId of the bike to search. ");
        String plate_Number = sc.nextLine();

        for (Schedule rental : sch_list) {
            //finding th object of the rental from booking id
            if (plate_Number.equals(rental.getBookingID())) {
                rentalObject = rental;
            }
        }
        System.out.println(rentalObject);
        rentalMenu();
    }
    //customer functions
    public void searchCustomer() {
        Customer custObject = null;
        System.out.println("Enter the CustomerID of the Customer to search. ");
        String plate_Number = sc.nextLine();

        for (Customer customer : cust_list) {
            //finding object of customer with customer id
            //displa details
            if (plate_Number.equals(customer.getCustomerID())) {
                custObject = customer;
            }
        }
        System.out.println(custObject);
        customerMenu();
    }

    public void databaseToList() {
        EntityManager entityManager = EMF.createEntityManager();
        //used to get the access the rows in the sql database
        EntityTransaction entityTransaction = null;

        try {
            entityTransaction = entityManager.getTransaction();
            //process of retrieveing the data from the datbase
            entityTransaction.begin();
            //lists to extract the data from the database into
            car_list = entityManager.createQuery( "select car from Car car" ).getResultList();
            bike_list = entityManager.createQuery( "select bike from Motor_Bike bike" ).getResultList();
            cust_list = entityManager.createQuery( "select customer from Customer customer" ).getResultList();
            sch_list = entityManager.createQuery( "select schedule from Schedule schedule" ).getResultList();
            //commit closes the entity trasaction
            entityTransaction.commit();
        } catch (Exception ex) {
            if (entityManager != null) {
                entityTransaction.rollback();
            }
            ex.printStackTrace();
            //error
        } finally {
            entityManager.close();
            //end of process
        }
    }
    public void listToDatabse() {
        EntityManager entityManager = EMF.createEntityManager();
        //create object entity manager
        EntityTransaction entityTransaction = null;

        try {
            //start transactio
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            for (Car car : car_list) {
                //iterate through the list and pass objects
                entityManager.persist( car );
                //adding list to db through persist
            }
            for (Motor_Bike motorbike : bike_list) {
                entityManager.persist( motorbike );
                //adding list to db through persist
            }
            entityTransaction.commit();
        } catch (NullPointerException ex) {
            //exception handling
            if (entityTransaction != null) {
                entityTransaction.rollback();
            }
            ex.printStackTrace();

        }catch(javax.persistence.EntityExistsException e){
            System.out.println("A licence plate number was repeated on adding a vehicle. Try Again.");
            consoleMenu();

        } finally {
            //mark end of transaction
            entityManager.close();
        }
    }
    public void removeFromDatabse() {
        //code to empty databse to save all changesmade to the database.
        EntityManager entityManager = EMF.createEntityManager();
        EntityTransaction entityTransaction = null;

        try {
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            //process of ADDING the objects done to a list
            List<Car> carRemoveList = entityManager.createQuery( "select car from Car car" ).getResultList();
            List<Motor_Bike> motorbikeRemoveList = entityManager.createQuery( "select bike from Motor_Bike bike" ).getResultList();


            for (Car car : carRemoveList) {
                //list to iterate through and delete items in the databse
                Car managed = entityManager.merge( car );
                entityManager.remove( managed );
            }
            for (Motor_Bike motorbike : motorbikeRemoveList) {
                //list to iterate through and delete items in the databse
                Motor_Bike managed = entityManager.merge( motorbike );
                entityManager.remove( managed );
            }

            entityTransaction.commit();
        } catch (Exception ex) {
            //exception handling
            if (entityTransaction != null) {
                entityTransaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            //terminate the transaction
            entityManager.close();
        }

    }
    public void viewAllVehicles() {

        if (car_list == null && bike_list == null) {
        } else {
            for (Car car : car_list) {
                //iterate through lsiat and print the stringvalue of the object
                String c= car.toString();
                String carObject =String.valueOf(c);
                System.out.println(carObject);
            }
            for (Motor_Bike motor_bike : bike_list) {
                //iterate through lsiat and print the stringvalue of the object
                String b= motor_bike.toString();
                String bikeObject =String.valueOf(b);
                System.out.println(bikeObject.toString());
            }
        }
        vehicleMenu();
    }
    public void viewAllRentals() {

        if (car_list == null && bike_list == null) {
        } else {
            for (Schedule sch : sch_list) {
                //iterate through list and print
                String s= sch.toString();
                String scheduleObject =String.valueOf(s);
                System.out.println(scheduleObject);
            }

        }
        rentalMenu();
    }
    public void viewAllCustomers() {

        if (car_list == null && bike_list == null) {
        } else {
            for (Customer customer : cust_list) {
                //iterate through list and print
                String c= customer.toString();
                String customerObject =String.valueOf(c);
                System.out.println(customerObject);
            }
        }
    }
    public Car getCarDetails() {
        Car car = new Car();

        System.out.println( "Enter the following details about the Car:" );
        System.out.println( "Licence Plate Number:" );
        car.setPlate_Number( sc.nextLine() );
        System.out.println( "Make :" );
        car.setMake( sc.nextLine() );
        System.out.println( "Model :" );
        car.setModel( sc.nextLine() );
        System.out.println( "Colour :" );
        car.setColor( sc.nextLine() );
        System.out.println( "Daily Rate:" );
        //loop till accurate input
        while (true) {
            try {
                car.setratePerDay( new BigDecimal( sc.nextLine() ) );
                break;
            } catch (NumberFormatException e) {
                //validation
                System.out.println( "Invalid Input, Enter a decimal value." );
                System.out.println( "Daily Rate:" );
                continue;
            }
        }
        System.out.println( "Does it have AC(yes or no):" );

        while (true) {
            String input = sc.nextLine();
            if ((input.toLowerCase()).equals( "yes" ) || (input.toLowerCase()).equals( "y" )) {
                car.setHasAC( true );
                break;
                //validations
            } else if (((input.toLowerCase()).equals( "no" ) || (input.toLowerCase()).equals( "n" ))) {
                car.setHasAC( false );
                break;
            } else {
                System.out.println( "Invalid Input, Enter yes or no." );
                System.out.println( "Does it have AC(yes or no):" );
                continue;
            }
        }
        System.out.println( "Number of seats :" );
        boolean flag = false;
        while (!flag) {
            try {
                car.setNoOfSeats( sc.nextInt() );
                sc.nextLine();
                flag=true;
                //validation with loop
            } catch (InputMismatchException e) {
                System.out.println( "Invalid Input, Enter a number." );
                System.out.println("Number of seats :" );
                sc.nextLine();
            }
        }
        return car;
    }
    public Motor_Bike getMotorbikeDetails() {
        Motor_Bike bike = new Motor_Bike();

        System.out.println( "Enter the following details about the Motor Bike:" );
        System.out.println( "Licence Plate Number:" );
        bike.setPlate_Number( sc.nextLine() );
        System.out.println( "Make :" );
        bike.setMake( sc.nextLine() );
        System.out.println( "Model :" );
        bike.setModel( sc.nextLine() );
        System.out.println( "Colour :" );
        bike.setColor( sc.nextLine() );
        System.out.println( "Daily Rate:" );
        while (true) {
            try {
                bike.setratePerDay( new BigDecimal( sc.nextLine() ) );
                break;
                //validations
            } catch (NumberFormatException e) {
                System.out.println( "Invalid Input, Enter a decimal value." );
                System.out.println( "Daily Rate:" );
                continue;
            }
        }
        System.out.println( "Is it a scooter(yes or no):" );
        while (true) {
            String input = sc.nextLine();
            if ((input.toLowerCase()).equals( "yes" ) || (input.toLowerCase()).equals( "y" )) {
                bike.setScooterType( true );
                break;
            } else if (((input.toLowerCase()).equals( "no" ) || (input.toLowerCase()).equals( "n" ))) {
                bike.setScooterType( false);
                break;
                //validations
            } else {
                System.out.println( "Invalid Input, Enter yes or no." );
                System.out.println( "Is it a scooter(yes or no):" );
                continue;
            }
        }

        System.out.println( "Does it have storage(yes or no):" );
        while (true) {
            String input = sc.nextLine();
            if ((input.toLowerCase()).equals( "yes" ) || (input.toLowerCase()).equals( "y" )) {
                bike.setHasStorage( true );
                break;
                //validation and looping
            } else if (((input.toLowerCase()).equals( "no" ) || (input.toLowerCase()).equals( "n" ))) {
                bike.setHasStorage(  false);
                break;
            } else {
                System.out.println( "Invalid Input, Enter yes or no." );
                System.out.println( "Does it have storage(yes or no):" );
                continue;
            }
        }
        return bike;
    }

    public void mainMenu() {
        databaseToList();
        //all item taken into list form databse here
        System.out.println( "---Main Menu---" );
        System.out.println( "1. Open Console" );
        System.out.println( "2. Open GUI" );
        System.out.println( "0. Exit" );
        System.out.println( "Select an option :" );
        //validation
        int option = getOption( 0, 2);
        switch (option) {
            case 1:
                consoleMenu();
                break;
            case 2:
                if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                    try {
                        Desktop.getDesktop().browse( new URI("http://localhost:4200") );
                    } catch (IOException | URISyntaxException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("GUI is open on the browser");
                break;
            case 0:
                exitConsole();
                break;
            default:
                System.out.println( "Invalid. Please enter a valid option. " );
        }mainMenu();
    }
    public void consoleMenu(){
        System.out.println( "1. Manage Vehicles" );
        System.out.println( "2. Veiw Rental Details" );
        System.out.println( "3. Veiw Customer Details" );
        System.out.println( "0. Exit" );
        System.out.println( "Select an option :" );

        int option = getOption( 0, 3 );
        switch (option) {
            case 1:
                vehicleMenu();
                break;
            case 2:
                rentalMenu();
                break;
            case 3:
                customerMenu();
                break;
            case 0:
                exitConsole();
                break;
            default:
                //validation
                System.out.println( "Invalid. Please enter a valid option. " );
        }

    }
    public void vehicleMenu() {
        System.out.println( "---Vehicle Menu---" );
        System.out.println( "1. Manage Car" );
        System.out.println( "2. Manage Motor Bike" );
        System.out.println( "3. Veiw All Vehicles" );
        System.out.println( "0. Exit." );
        System.out.println( "Select an Option :" );

        int option = getOption( 0, 3 );
        boolean flag = true;
        while (flag) {
            switch (option) {
                case 1:
                    carMenu();
                    break;
                case 2:
                    bikeMenu();
                    break;
                case 3:
                    viewAllVehicles();
                    flag = false;
                    break;
                case 0:
                    exitConsole();
                    break;
                default:
                    //validation
                    System.out.println( "Invalid. Please enter a value from options above." );
            }
            consoleMenu();
        }

    }
    public void carMenu() {

        System.out.println( "1 - Add Cars " );
        System.out.println( "2 - Delete Cars " );
        System.out.println( "3 - Update Cars" );
        System.out.println( "4 - Search Cars" );
        System.out.println( "0 - Exit" );
        System.out.println( "Select an Option :" );
        //validation
        int option = getOption( 0, 5 );

        boolean flag = true;
        while (flag) {
            switch (option) {
                case 1:
                    addCar( getCarDetails() );
                    flag = false;
                    break;
                case 2:
                    deleteCar();
                    flag = false;
                    break;
                case 3:
                    updateCar();
                    flag = false;
                    break;
                case 4:
                    searchCar();
                    flag = false;
                    break;
                case 0:
                    exitConsole();
                    break;
                default:
                    //validation
                    System.out.println( "Invalid Option. Please Enter valid option. " );
            }vehicleMenu();
        }

    }
    public void bikeMenu() {
        System.out.println( "1 - Add Motor Bikes" );
        System.out.println( "2 - Delete Motor Bikes" );
        System.out.println( "3 - Update Motor Bikes" );
        System.out.println( "4 - Search Motor Bikes" );
        System.out.println( "0 - Exit" );
        System.out.println( "Select an Option :" );
        //validation
        int option = getOption( 0, 4 );

        boolean flag = true;
        while (flag) {
            switch (option) {
                case 1:
                    addMotorBike( getMotorbikeDetails() );
                    flag = false;
                    break;
                case 2:
                    deleteMotorBike();
                    flag = false;
                    break;
                case 3:
                    updateMotorBike(  );
                    flag = false;
                    break;
                case 4:
                    searchMotorBike( );
                    flag = false;
                    break;
                case 0:
                    exitConsole();
                    break;
                default:
                    //validation
                    System.out.println( "Invalid Option. Please Enter valid option. " );
            }
            vehicleMenu();
        }
        }
    public void rentalMenu() {
        System.out.println( "1 - Search Rental" );
        System.out.println( "2 - Veiw all Rentals" );
        System.out.println( "0 - Exit" );
        System.out.print( "Select an option:" );
        //validation
        int option = getOption( 0, 2 );

        boolean flag = true;
        while (flag) {
            switch (option) {
                case 1:
                    searchRental();
                    flag = false;
                    break;
                case 2:
                    viewAllRentals();
                    flag = false;
                    break;
                case 0:
                    exitConsole();
                    break;
                default:
                    //validation
                    System.out.println( "Invalid Option. Please Enter valid option. " );
            }
            consoleMenu();
        }
    }
    public void customerMenu() {
        System.out.println( "1 - Search Customer" );
        System.out.println( "2 - Veiw all Customers");
        System.out.println( "0 - Exit" );
        System.out.print( "Select an option:" );
        //validation
        int option = getOption( 0, 2 );

        boolean flag = true;
        while (flag) {
            switch (option) {
                case 1:
                    searchCustomer( );
                    flag = false;
                    break;
                case 2:
                    viewAllCustomers();
                    flag = false;
                    break;
                case 0:
                    exitConsole();
                    break;
                default:
                    //validation
                    System.out.println( "Invalid Option. Please Enter valid option. " );
            }
        }consoleMenu();
    }
    public void exitConsole() {
        removeFromDatabse();
        //all changes madr to the four list are loaded to the datbase here.
        listToDatabse();
        EMF.close();
        System.out.println( "**********" );
        System.exit( 0 );
    }
    //validation for numerical optional inputs
    public int getOption(int min, int max){
            int input;
            int option = -1;
            boolean flag = false;
            while (!flag) {
                try {
                    input= sc.nextInt();
                    sc.nextLine();
                } catch (InputMismatchException e) {
                    System.out.println( "Invalid Input, Enter a valid input." );
                    sc.nextLine();
                    continue;
                }

                if (option >= min && option <= max) {
                } else {
                    flag= true;
                }
                option= input;

            }
            return option;
    }
}

