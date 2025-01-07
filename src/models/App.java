package models;
import java.util.ArrayList;
import java.util.Scanner;



public class App {

    ArrayList<List> lists;
    int currentScreen;
    int input;
    Scanner in;
    int currentListId;


    public App() {
        lists = new ArrayList<>();
        currentScreen = 0;
        input = 1;
        currentListId = 0;
        in = new Scanner(System.in);
    }

    public void startApp()
    {

        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to your TODO list");


        while(input != 0)
        {

            switch(this.currentScreen)
            {
                case 0:
                    this.runScreen0();
                    break;
                case 1:
                    this.runScreen1();
                    break;
                case 2:
                    this.runScreen2();
                    break;
            }

            if(this.currentScreen == 0)
            {
                this.runScreen0();
            }
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
        int id;
        while(this.input != 0 && this.currentScreen == 1)
        {
            if(this.lists.isEmpty())
            {
                System.out.println("You currently have no TODO lists");
                System.out.println("1. Create a TODO list");
                System.out.println("2. Go back");
                System.out.println("0. Quit the app");

                this.input = this.in.nextInt();

                switch(this.input)
                {
                    case 1:
                        System.out.println("Enter the list name");
                        name = in.nextLine();
                        this.createList(name);
                        break;
                    case 2:
                        this.currentScreen--;
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Please enter a valid option");
                }
            }
            else
            {
                System.out.println("Your lists:");
                for(List list : this.lists)
                {
                    System.out.println("Id: " + list.getId());
                    System.out.println("Name: " + list.getName());
                }

                System.out.println("1. Open TODO list");
                System.out.println("2. Create a TODO list");
                System.out.println("3. Delete a TODO list");
                System.out.println("4. Go back");
                System.out.println("0. Quit the app");

                this.input = this.in.nextInt();

                switch(this.input)
                {
                    case 1:
                        System.out.println("Enter the list id");
                        this.currentListId = in.nextInt();
                        this.currentScreen++;
                        break;
                    case 2:
                        System.out.println("Enter the list name");
                        name = in.nextLine();
                        this.createList(name);
                        break;
                    case 3:
                        System.out.println("Enter the list id");
                        id = in.nextInt();
                        this.deleteList(id);
                        break;
                    case 4:
                        this.currentScreen--;
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Please enter a valid option");
                }
            }
        }
    }

    public void runScreen2()
    {
        String name;
        String description;
        int id;
        ArrayList<Task> tasks;

        while(this.input != 0 && this.currentScreen == 2)
        {
            tasks = this.lists.get(this.currentListId - 1).getTasks();

            if(tasks.isEmpty())
            {
                System.out.println("You currently have no tasks");
                System.out.println("1. Create a task");
                System.out.println("2. Go back");
                System.out.println("0. Quit the app");

                this.input = this.in.nextInt();

                switch(this.input)
                {
                    case 1:
                        System.out.println("Enter the task name");
                        name = in.nextLine();
                        System.out.println("Enter the task description");
                        description = in.nextLine();
                        this.lists.get(this.currentListId - 1).createTask(name, description);
                        break;
                    case 2:
                        this.currentScreen--;
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Please enter a valid option");
                }
            }
            else
            {
                System.out.println("Your tasks:");
                for(Task task : tasks)
                {
                    System.out.println("Id: " + task.getId());
                    System.out.println("Name: " + task.getName());
                    System.out.println("Description: " + task.getDescription());

                    if(task.isDone())
                    {
                        System.out.println("Status: DONE");
                    }
                    else
                    {
                        System.out.println("Status: DOING");
                    }

                    System.out.println(" ");
                }

                System.out.println("1. Create a task");
                System.out.println("2. Delete a task");
                System.out.println("3. Mark task as done");
                System.out.println("4. Go back");
                System.out.println("0. Quit the app");

                this.input = this.in.nextInt();

                switch(this.input)
                {
                    case 1:
                        System.out.println("Enter the task name");
                        name = in.nextLine();
                        System.out.println("Enter the task description");
                        description = in.nextLine();
                        this.lists.get(this.currentListId - 1).createTask(name, description);
                        break;
                    case 2:
                        System.out.println("Enter the task id");
                        id = in.nextInt();
                        this.lists.get(this.currentListId - 1).deleteTask(id);
                        break;
                    case 3:
                        System.out.println("Enter the task id");
                        id = in.nextInt();
                        this.lists.get(this.currentListId - 1).getTask(id - 1).setDone(true);
                        break;
                    case 4:
                        this.currentScreen--;
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Please enter a valid option");
                }
            }
        }
    }



    public void createList(String name) {

    }

    public void deleteList(int id) {

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
