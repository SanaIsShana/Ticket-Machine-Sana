

public class Payment extends Trip{
    private int numberOTickets, childTicket, adultTicket, seniorTicket, ticketType;
    private double totalAmount;

    public double getTotalAmount() {
        return totalAmount;
    }

    public void buyTicket(){
        while (getPaymentOption()>=0 && getPaymentOption()<=2) {
            System.out.print("--- Ticket type ---\n1.Child 2.Adult 3.Senior\n");
            this.ticketType = scan.nextInt();
            System.out.print("----- Amount -----\n");
            this.numberOTickets = scan.nextInt();
            setTicketAmount();
            System.out.println("Would you like to more? choose \"1\" to continue, choose \"2\" to the payment.");
            setPaymentOption(scan.nextInt());
            if (getPaymentOption() == 2){
                payTheBill();
                break;
            }
        }
    }

    public void setPrice(){
        if (getStartStationOption() == 8 || getDestinationOption() == 8){
            if (this.childTicket!=0){
                setMoneyToPay(getMoneyToPay() + this.childTicket*90);
            }
            if (this.adultTicket!=0){
                setMoneyToPay(getMoneyToPay() + this.adultTicket*150);
            }
            if (this.seniorTicket!=0){
                setMoneyToPay(getMoneyToPay() + this.seniorTicket*120);
            }
        }
        else{
            if (this.childTicket!=0){
                setMoneyToPay(getMoneyToPay() + this.childTicket*42);
            }
            if (this.adultTicket!=0){
                setMoneyToPay(getMoneyToPay() + this.adultTicket*70);
            }
            if (this.seniorTicket!=0){
                setMoneyToPay(getMoneyToPay() + this.seniorTicket*56);
            }
        }
    }

    private void setTicketAmount(){
        if (this.ticketType == 1){
            ticketTypeList.add("Child");
            this.childTicket += numberOTickets;
            this.ticketTypeList.add(Integer.toString(this.numberOTickets));
        }
        else if (this.ticketType == 2){
            ticketTypeList.add("Adult");
            this.adultTicket += numberOTickets;
            this.ticketTypeList.add(Integer.toString(this.numberOTickets));
        }
        else if (this.ticketType == 3){
            ticketTypeList.add("Senior");
            this.seniorTicket += numberOTickets;
            this.ticketTypeList.add(Integer.toString(this.numberOTickets));
        }
    }

    public void payTheBill(){
        setPrice();
        for (String s : ticketTypeList) {
            System.out.print(s + " ");
        }
        System.out.println("Amount to pay: " + getMoneyToPay());
        this.totalAmount = getMoneyToPay();
        setMoneyPaid(scan.nextDouble());

        if (getMoneyToPay() == getMoneyPaid()){
            System.out.println("Your tickets are ready, please check it in \"My ticket\" !");
        }
        if (getMoneyPaid() < getMoneyToPay()) {
            while (getMoneyToPay() != getMoneyPaid()){
                setMoneyToPay(getMoneyToPay()-getMoneyPaid());
                System.out.println("You need to pay " + getMoneyToPay() + "kr more, thanks!");
                setMoneyPaid(scan.nextDouble());
                if (getMoneyPaid() > getMoneyToPay()) {
                    largePayment();
                    break;
                }
                else if (getMoneyToPay() == getMoneyPaid()) {
                    System.out.println("Your tickets are ready, please check it in \"My ticket\" !");}
            }
        }
        else if (getMoneyPaid() > getMoneyToPay()) {
            largePayment();
        }

    }
    private void largePayment(){
            setMoneyToPay(getMoneyPaid()-getMoneyToPay());
            System.out.println("Your tickets are ready, please check it in \"My ticket\" !");
            System.out.println("Here is your change " + getMoneyToPay() + "kr, thanks!");
    }

}
