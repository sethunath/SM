/*
 * ComApp.java
 */

package comapp;

import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;

/**
 * The main class of the application.
 */
public class ComApp extends SingleFrameApplication {

    /**
     * At startup create and show the main frame of the application.
     */
    @Override protected void startup() {
        show(new ComView(this));
    }

    /**
     * This method is to initialize the specified window by injecting resources.
     * Windows shown in our application come fully initialized from the GUI
     * builder, so this additional configuration is not needed.
     */
    @Override protected void configureWindow(java.awt.Window root) {
    }

    /**
     * A convenient static getter for the application instance.
     * @return the instance of ComApp
     */
    public static ComApp getApplication() {
        return Application.getInstance(ComApp.class);
    }

    /**
     * Main method launching the application.
     */
    public static void main(String[] args) {
        /*if(System.currentTimeMillis()>new Date(110,3,14).getTime()){
        return;
        }*/
        /*System.out.println(System.currentTimeMillis());
        System.out.println(new Date(2010,4,14).getTime());*/
        launch(ComApp.class, args);
    }
}
