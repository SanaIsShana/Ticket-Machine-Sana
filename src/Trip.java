import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

abstract class Trip {
    BufferedReader reader;
    BufferedWriter writer;
    public int startStationOption, destinationOption;
    private int menuOption, paymentOption;
    private String stationToStart,stationToGo;
    public Scanner scan = new Scanner(System.in);
    public ArrayList<String> stationList = new ArrayList<>();
    public ArrayList<String> trainLineList = new ArrayList<>();
    public ArrayList<String> ticketTypeList= new ArrayList<>();
    private double moneyToPay, moneyPaid;

    public void setMoneyToPay(double moneyToPay) {
        this.moneyToPay = moneyToPay;
    }

    public void setMoneyPaid(double moneyPaid) {
        this.moneyPaid = moneyPaid;
    }

    public double getMoneyToPay() {
        return moneyToPay;
    }

    public double getMoneyPaid() {
        return moneyPaid;
    }

    public void setStartStationOption(int startPlace) {
        this.startStationOption = startPlace;
    }

    public int getStartStationOption() {
        return startStationOption;
    }

    public void setDestinationOption(int destination) {
        this.destinationOption = destination;
    }

    public int getDestinationOption() {
        return destinationOption;
    }

    public void setMenuOption(int menuOption) {
        this.menuOption = menuOption;
    }

    public int getMenuOption() {
        return menuOption;
    }

    public ArrayList<String> getStationList() {
        return stationList;
    }

    public ArrayList<String> getTrainLineList() {
        return trainLineList;
    }

    public ArrayList<String> getTicketTypeList() {
        return ticketTypeList;
    }

    public void setPaymentOption(int paymentOption) {
        this.paymentOption = paymentOption;
    }

    public int getPaymentOption() {
        return paymentOption;
    }

    public void setStationToGo(String stationToGo) {
        this.stationToGo = stationToGo;
    }

    public void setStationToStart(String stationToStart) {
        this.stationToStart = stationToStart;
    }

    public String getStationToGo() {
        return stationToGo;
    }

    public String getStationToStart() {
        return stationToStart;
    }

    public void getTravelLines(){
        try {
            reader = new BufferedReader(new FileReader("avgangar.txt"));
            String trainLines;
            int number = 1;
            System.out.println("Welcome to use our ticket machine!");
            System.out.println("We have 5 different travel lines between different cities.");
            System.out.println("Here are our different train lines: ");
            while ((trainLines = reader.readLine()) != null){
                this.trainLineList.add(trainLines);
                System.out.println("Line " + number + ": " + trainLines);
                number++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void getStationLists(){
        try {
            reader = new BufferedReader(new FileReader("stationer.txt"));
            String stations;
            int number = 1;
            while ((stations = reader.readLine()) != null){
                this.stationList.add(stations);
                System.out.println(number + ". " + stations);
                number++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
