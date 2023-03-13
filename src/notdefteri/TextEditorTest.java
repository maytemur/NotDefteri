package notdefteri;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class TextEditorTest extends JPanel implements DocumentListener, ActionListener {

    /**
     * Creates a new instance of TextEditorTest
     */
    /* adding the textpane to the scrollpane and adding the scrollpane to the gui,
         you add the textpane directly to the gui and the scrollpane is never used*/
    private String newline = "\n";
    protected static final String textFieldString = "JTextField";
    protected static final String passwordFieldString = "JPasswordField";
    protected static final String ftfString = "JFormattedTextField";
    protected static final String buttonString = "JButton";
    protected JLabel actionLabel;
    public JPanel leftPane = new JPanel(new BorderLayout());
    JTextArea textArea = new JTextArea(
            "This is an editable JTextArea. "
            + "A text area is a \"plain\" text component, "
            + "which means that although it can display text "
            + "in any font, all of the text is in the same font."
    );

    public TextEditorTest() {
        setLayout(new BorderLayout());

        textArea.setFont(new Font("Serif", Font.ITALIC, 16));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        JScrollPane areaScrollPane = new JScrollPane(textArea);
        areaScrollPane.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        areaScrollPane.setPreferredSize(new Dimension(250, 250));
        areaScrollPane.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createCompoundBorder(
                                BorderFactory.createTitledBorder("Plain Text"),
                                BorderFactory.createEmptyBorder(5, 5, 5, 5)),
                        areaScrollPane.getBorder()));

        leftPane.add(areaScrollPane,
                BorderLayout.CENTER);

        add(leftPane, BorderLayout.LINE_START);

        JMenuBar bar = new JMenuBar();
        JMenu menu = new JMenu("File");
        JMenu menu2 = new JMenu("Edit");
        JMenu menu3 = new JMenu("Format");

        JMenuItem newItem = new JMenuItem("New");
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem saveasItem = new JMenuItem("Save As");
        JMenuItem exitItem = new JMenuItem("Exit");
        newItem.addActionListener(this);
        openItem.addActionListener(this);
        saveItem.addActionListener(this);
        saveasItem.addActionListener(this);
        exitItem.addActionListener(this);
        menu.add(newItem);
        menu.add(openItem);
        menu.add(saveItem);
        menu.add(saveasItem);
        menu.add(exitItem);

        JMenuItem undoItem = new JMenuItem("Undo");
        JMenuItem redoItem = new JMenuItem("Redo");
        JMenuItem findItem = new JMenuItem("Find");
        JMenuItem replaceItem = new JMenuItem("Replace");
        JMenuItem cutItem = new JMenuItem("Cut");
        JMenuItem copyItem = new JMenuItem("Copy");
        JMenuItem pasteItem = new JMenuItem("Paste");
        undoItem.addActionListener(this);
        redoItem.addActionListener(this);
        findItem.addActionListener(this);
        replaceItem.addActionListener(this);
        cutItem.addActionListener(this);
        copyItem.addActionListener(this);
        pasteItem.addActionListener(this);
        menu2.add(undoItem);
        menu2.add(redoItem);
        menu2.add(findItem);
        menu2.add(replaceItem);
        menu2.add(cutItem);
        menu2.add(copyItem);
        menu2.add(pasteItem);

        JMenuItem fontItem = new JMenuItem("Font");
        fontItem.addActionListener(this);
        menu3.add(fontItem);

        bar.add(menu);
        bar.add(menu2);
        bar.add(menu3);
    }

    public static void main(String[] args) {
        TextEditorTest t = new TextEditorTest();
        t.setBounds(50, 50, 300, 300);
        t.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("New")) {
            System.out.println("yeni");
            TextEditorTest t = new TextEditorTest();
            t.setBounds(50, 50, 300, 300);
            t.setVisible(true);

        } else if (e.getActionCommand().equals("Open")) {
            System.out.println("aç");
            JFileChooser chooser = new JFileChooser();
            int result = chooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File file = chooser.getSelectedFile();
                try {
                    FileInputStream fis = new FileInputStream(file);
                    //leftPane(fis, null);

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        } else if (e.getActionCommand().equals("Save")) {
            System.out.println("kaydet");
        } else if (e.getActionCommand().equals("Save As")) {
            System.out.println("farkli kaydet");
        } else if (e.getActionCommand().equals("Exit")) {
            System.out.println("çik");
        } else if (e.getActionCommand().equals("Undo")) {
            System.out.println("geri al");
        } else if (e.getActionCommand().equals("Redo")) {
            System.out.println("ileri al");
        } else if (e.getActionCommand().equals("Find")) {
            System.out.println("bul");
        } else if (e.getActionCommand().equals("Replace")) {
            System.out.println("degistir");
        } else if (e.getActionCommand().equals("Cut")) {
            System.out.println("kes");
        } else if (e.getActionCommand().equals("Copy")) {
            System.out.println("Kopyala");
        } else if (e.getActionCommand().equals("Paste")) {
            System.out.println("yapistir");
        } else if (e.getActionCommand().equals("Font")) {
            System.out.println("font");
        }
    }

    public void changedUpdate(DocumentEvent e) {
        System.out.println("change");
    }

    public void insertUpdate(DocumentEvent e) {
        System.out.println("insert");
    }

    public void removeUpdate(DocumentEvent e) {
        System.out.println("update");
    }
}
