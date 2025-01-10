package models;
import interfaces.IApp;

import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;



public class App implements IApp {

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
    @Override
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
        System.out.println("0. Quit the app");

        this.input = this.in.nextInt();
        this.in.nextLine();

        switch(this.input)
        {
            case 1:
                this.importFromFile();
                this.currentScreen++;
                System.out.println("Sdaw");
                break;
            case 2:
                this.currentScreen++;
                break;
            default:
                break;
        }
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
                this.in.nextLine();

                switch(this.input)
                {
                    case 1:
                        System.out.println("Enter the list name");
                        name = this.in.nextLine();
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
                this.in.nextLine();

                switch(this.input)
                {
                    case 1:
                        System.out.println("Enter the list id");
                        this.currentListId = this.in.nextInt();
                        this.in.nextLine();
                        this.currentScreen++;
                        break;
                    case 2:
                        System.out.println("Enter the list name");
                        name = in.nextLine();
                        this.createList(name);
                        break;
                    case 3:
                        System.out.println("Enter the list id");
                        id = this.in.nextInt();
                        this.in.nextLine();
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
                this.in.nextLine();

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
                this.in.nextLine();

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
                        this.in.nextLine();
                        this.lists.get(this.currentListId - 1).deleteTask(id);
                        break;
                    case 3:
                        System.out.println("Enter the task id");
                        id = in.nextInt();
                        this.in.nextLine();
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
        int id = this.lists.size() + 1;
        List list = new List(id, name);
        this.lists.add(list);
    }

    public void deleteList(int id) {
        this.lists.remove(id - 1);
        this.updateListIds();
    }


    public void closeApp()
    {
        this.exportToFile();
    }

    public void exportToFile()
    {

        int numOfTasks = 0;

        try(FileWriter fWriter = new FileWriter("export.txt")) {

            fWriter.write(this.lists.size() + "!");
            for(List list : this.lists)
            {
                numOfTasks+= list.getTasks().size();
                fWriter.write(list.toString());
            }
            fWriter.write(numOfTasks + "!");
            for(List list : this.lists)
            {
                for(Task task : list.getTasks())
                {
                    fWriter.write(task.toString());
                }
            }
        }
        catch (IOException e)
        {

            // Print the exception
            System.out.print(e.getMessage());
        }
    }

    public void importFromFile()
    {
        try
        {
            File file = new File("export.txt");

            Scanner sc = new Scanner(file);
            sc.useDelimiter("!");

            int numOfLists = sc.nextInt();
            System.out.println(numOfLists);
            System.out.println("test");
            System.out.println("testint");
            int listId;
            int taskId;
            boolean done;
            String description;
            String taskName;
            String listName;

            System.out.println("test1");
            for(int i = 0; i < numOfLists; i++)
            {
                listId = sc.nextInt();
                listName = sc.next();
                this.createList(listName);

            }
            System.out.println("test2");
            int numOfTasks = sc.nextInt();
            System.out.println(numOfTasks);
            for(int i = 0; i < numOfTasks; i++)
            {
                taskId = sc.nextInt();
                System.out.println("test");

                taskName = sc.next();
                System.out.println("test");

                description = sc.next();
                System.out.println("test");

                done = sc.nextBoolean();
                System.out.println("test");

                listId = sc.nextInt();
                System.out.println("test");


                this.lists.get(listId - 1).addTask(taskName, description, done);
            }
            System.out.println("test4");

        }
        catch (IOException e)
        {

            // Print the exception
            System.out.print(e.getMessage());
        }
    }

    private void updateListIds()
    {
        for(List list : this.lists)
        {
            list.setId(this.lists.indexOf(list) + 1);
        }
    }
}
