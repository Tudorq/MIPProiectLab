package models;
import java.util.ArrayList;
import java.util.Scanner;



public class App {

    ArrayList<List> lists;
    int currentScreen;
    int input;
    Scanner in;


    public App() {
        lists = new ArrayList<>();
        currentScreen = 0;
        input = 1;
        in = new Scanner(System.in);
    }

    public void startApp()
    {

        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to your TODO list");


        while(input != 0)
        {

            if(this.currentScreen == 0)
            {
                this.runScreen0();
            }
        }

        if(currentScreen == 1)
        {
            System.out.println("1. Show listsd ");
        }
    }

    private void runScreen0()
    {
        System.out.println("1. Import lists from file");
        System.out.println("2. Continue without importing");

        input = this.in.nextInt();
        if(input == 1)
        {
            this.importFromFile();
        }
        this.currentScreen++;
    }

    private void runScreen1() {

        String name;
        while(this.input != 0)
        {
            if(this.lists.isEmpty())
            {
                System.out.println("You currently have no TODO lists");
                System.out.println("1. Create a TODO list");
                System.out.println("0. Quit the app");

                this.input = this.in.nextInt();

                if(input == 1)
                {
                    System.out.println("Enter the lists name");
                    name = in.nextLine();
                    this.createList(name);

                } else if (input != 0) {
                    System.out.println("Please enter a valid option");
                }
            }
            else
            {
                System.out.println("Your lists:");
                for(List list : this.lists)
                {
                    
                }
            }
        }
    }

    public void createList(String name) {

    }

    public void showAllLists()
    {

    }

    public void showList(int listId)
    {

    }

    public void closeApp()
    {

    }

    public void exportToFile()
    {

    }

    public void importFromFile()
    {

    }

}
