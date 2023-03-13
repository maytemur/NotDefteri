package notdefteri;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
class TextPanel{
    private JTabbedPane	tabbPane;
    private int tabbLimit = 20;
    private JTextPane[] jtp = new JTextPane[tabbLimit];
    public TextPanel(){
        JFrame	frame = new JFrame("TextEditor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        tabbPane = new JTabbedPane();

            JTextPane jtp = new JTextPane();
            JScrollPane paneScrollPane = new JScrollPane(jtp);
            paneScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            tabbPane.addTab("Tab " + 1, null, paneScrollPane, "Tab " + 1);

        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(tabbPane, "Center");
        frame.setVisible(true);
    }
    public static void main(String[] args){
        
        new TextPanel();
    }
}