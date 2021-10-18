public class TestTicketMachine {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.getTravelLines();
        while (menu.getMenuOption()!=4) {
            menu.ticketMachineMenu();
        }
    }
}
