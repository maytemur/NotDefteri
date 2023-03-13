package notdefteri;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.*;
import java.awt.*;
import java.io.*;
public class JTableTest extends JFrame {
    public JTableTest(){
        /*String [][] oo=new String [][]{{"a","b"},{"c","d"},{"e","f"}};
        String [] cc=new String[]{"Col 1","Col 2"};
        JTable table=new JTable(oo,cc);*/       
        TestTableModel model=new TestTableModel ("C:\\");        
        JTable table=new JTable (model);
        getContentPane().add(new JScrollPane(table));
    }
    class TestTableModel extends AbstractTableModel {
        File file;
        TestTableModel(String path){
            file=new File(path);
        }        
        public int getColumnCount(){
            return 2;
        }
        public int getRowCount(){
            File[] files=file.listFiles();
            return files.length;
        }
        public String getColumnName(int column) {
	    String [] names={"isim","boy"};
            return names[column];
	}
        public Object getValueAt(int rowIndex,int columnIndex){
            File[] files=file.listFiles();
            File file=files[rowIndex];
            if(columnIndex==0){
                return file.getName();
            }else{
                return file.length()+" Byte";
            }
        }       
    }
    public static void main(String[] args) {
        JTableTest tt=new JTableTest();
        tt.setBounds(300,300,300,300);
        tt.setVisible(true);
    }
}