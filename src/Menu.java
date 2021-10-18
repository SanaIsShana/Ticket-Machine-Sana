import java.io.*;


public class Menu extends Payment {

    public void ticketMachineMenu(){
        System.out.println("1. Search trip | 2. My ticket | 3. Ticket price | 4. Quit");
        setMenuOption(scan.nextInt());
        switch (getMenuOption()){
            case 1:
                getStationLists();
                travelSearching();
                break;
            case 2:
                printMyTicket();
                break;

            case 4:
                System.exit(0);
                break;
        }
    }

    public void travelSearching(){
        System.out.print("Please choose your start station: ");
        setStartStationOption(scan.nextInt());
        setStationToStart(stationList.get(getStartStationOption()-1));
        System.out.print("Please choose your destination: ");
        setDestinationOption(scan.nextInt());
        setStationToGo(stationList.get(getDestinationOption()-1));
        buyTicket();
        myTicket();
    }
    public void myTicket(){
        if (getStartStationOption() != 0 && getDestinationOption() != 0) {
            try {
                writer = new BufferedWriter(new FileWriter("ticket.txt"));
                writer.write("------ My ticket ------");
                writer.write("\n" + getStationToStart() + " --- to --- " + getStationToGo());
                writer.write("\nTicket type and amount: ");
                for (String s : ticketTypeList) {
                    writer.write(s + " - ");
                }
                writer.write("\nTicket price: " + getTotalAmount() + "kr");
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void printMyTicket(){
        if (getStartStationOption() == 0 && getDestinationOption() == 0) {
            System.out.println("There is no ticket!");
            ticketMachineMenu();
        }
        else {
            try {
                reader = new BufferedReader(new FileReader("ticket.txt"));
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
