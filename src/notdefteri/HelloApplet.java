package notdefteri;
import java.applet.*;
import java.awt.*;
public class HelloApplet extends Applet{
    public void init(){
        System.out.println("Initializing..");
    }
    public void destroy(){
        System.out.println("Destroying..");
    }
    public void start(){
        System.out.println("Starting..");
    }
    public void stop(){
        System.out.println("Stoping..");
    }
    public void paint(Graphics g){
        System.out.println("Panting..");
        System.out.println(getCodeBase());
        System.out.println(getDocumentBase());
    }
}