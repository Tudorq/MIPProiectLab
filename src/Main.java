import interfaces.IApp;
import models.App;

public class Main {
    public static void main(String[] args) {
        IApp app = new App();
        app.startApp();
        app.closeApp();
    }


}