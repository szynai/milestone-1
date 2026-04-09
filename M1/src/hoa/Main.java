package hoa;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ResidentDAO rDAO = new ResidentDAO();
        VisitorDAO vDAO = new VisitorDAO();
        EventDAO eDAO = new EventDAO();
        

        while (true) {
            System.out.println("\n=== HOA SYSTEM ===");
            System.out.println("1. Register Resident");
            System.out.println("2. View Residents");
            System.out.println("3. Register Visitor");
            System.out.println("4. View Visitors");
            System.out.println("5. Register Event");
            System.out.println("6. View Events");
            System.out.println("7. Visitor Exit");
            System.out.println("8. Cancel Event");
            System.out.println("9. Exit");
            
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Contact: ");
                    String contact = sc.nextLine();
                    System.out.print("Address: ");
                    String address = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    Resident r = new Resident(name, contact, address, email);
                    rDAO.addResident(r);
                    break;

                case 2:
                    rDAO.viewResidents();
                    break;

                case 3:
                    System.out.print("Visitor Name: ");
                    String vname = sc.nextLine();
                    System.out.print("Resident to Visit: ");
                    String res = sc.nextLine();
                    if (!rDAO.checkResident(res)) {
                    break;  // stops and goes back to menu
                    }
                    System.out.print("Purpose: ");
                    String purpose = sc.nextLine();
                    System.out.print("Date: ");
                    String date = sc.nextLine();
                    System.out.print("Time In: ");
                    String time = sc.nextLine();

                    Visitor v = new Visitor(vname, res, purpose, date, time, "Inside");
                    vDAO.addVisitor(v);
                    break;

                case 4:
                    vDAO.viewVisitors();
                    break;

                case 5:
                    System.out.print("Organizer Name: ");
                    String ename = sc.nextLine();
                    System.out.print("Contact: ");
                    String econ = sc.nextLine();
                    System.out.print("Event Name: ");
                    String ev = sc.nextLine();
                    System.out.print("Event Date: ");
                    String edate = sc.nextLine();

                    Event e = new Event(ename, econ, ev, edate, "Active");
                    eDAO.addEvent(e);
                    break;

                case 6:
                    eDAO.viewEvents();
                    break;

                case 7:
                    System.out.print("Visitor ID to exit: ");
                    int vid = sc.nextInt();
                    vDAO.visitorExit(vid);
                    break;

                case 8:
                    System.out.print("Event ID to cancel: ");
                    int eid = sc.nextInt();
                    eDAO.cancelEvent(eid);
                    break;

                case 9:
                    System.exit(0);
            }
        }
    }
}
