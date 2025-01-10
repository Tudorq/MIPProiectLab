package models;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void testCreateList() {
        App app = new App();
        app.createList("List1");
        app.createList("List2");
        assertEquals(app.lists.get(0).getId(), 1);
        assertEquals(app.lists.get(1).getId(), 2);
        assertEquals(app.lists.get(0).getName(), "List1");
        assertEquals(app.lists.get(1).getName(), "List2");
    }

    @Test
    void testDeleteList() {
        App app = new App();
        app.createList("List1");
        app.createList("List2");
        app.deleteList(2);
        assertEquals(app.lists.size(), 1);
        assertEquals(app.lists.get(0).getId(), 1);
        assertEquals(app.lists.get(0).getName(), "List1");
    }

    @Test
    void exportToFile() throws FileNotFoundException {
        App app = new App();
        app.createList("List1");
        app.createList("List2");
        app.lists.get(0).createTask("task1", "this is task1");
        app.exportToFile();
        File file = new File("export.txt");

        Scanner sc = new Scanner(file);

        String result = sc.nextLine();
        assertEquals(result, "2!1!List1!2!List2!1!0!task1!this is task1!false!1!");
    }

}