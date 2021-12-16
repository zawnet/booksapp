package application;

public class StartupApp {
    public static void main(String[] args) {
        ApplicationService applicationService = new Application();

        new App(applicationService).start();
    }

}
