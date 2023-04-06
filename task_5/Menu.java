/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2;

/**
 *
 * @author Asus
 */
    public class Menu {
    private static Menu instance = null;

    private Menu() {}

    public static Menu getInstance() {
        if (instance == null) {
            instance = new Menu();
        }
        return instance;
    }

    public void showMenu() {
        System.out.println("------------");
        System.out.println("|   Menu:  |");
        System.out.println("| 1. Start |");
        System.out.println("| 2. Exit  |");
        System.out.println("------------");
    }

    public void handleCommand(int command) {
        switch (command) {
            case 1:
                System.out.println("Calculating areas...");
                break;
            case 2:
                System.out.println("Undoing last command...");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid command");
                break;
        }
    }
    
}
