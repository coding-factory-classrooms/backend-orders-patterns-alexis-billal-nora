import org.example.HomeSystem;
import org.example.models.Caretaker;
import org.example.models.Command;
import org.example.models.Item;
import org.junit.Test;

import java.awt.*;
import  java.awt.event.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.*;


public class MementoTest extends JFrame {

    public static void main(String args){
        new MementoTest();
    }

    private JButton saveBut, undoBut, redoBut;

    private List<Command> listCommand = new ArrayList<Command>();

    HomeSystem homeSystem = HomeSystem.getInstance();

    Caretaker caretaker = new Caretaker();
    Command command = new Command();

    int saveCommand = 0;
    int currentCommand = 0;

    public MementoTest(){

        this.setSize(750,780);
        this.setTitle("Memento test");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel1 = new JPanel();

        panel1.add(new JLabel("Command"));

        ButtonListener saveListener = new ButtonListener();
        ButtonListener undoListener = new ButtonListener();
        ButtonListener redoListener = new ButtonListener();

        saveBut = new JButton("Save");
        saveBut.addActionListener(saveListener);

        undoBut = new JButton("Undo");
        undoBut.addActionListener(undoListener);

        redoBut = new JButton("Redo");
        redoBut.addActionListener(redoListener);

        panel1.add(saveBut);
        panel1.add(undoBut);
        panel1.add(redoBut);

        this.add(panel1);
        this.setVisible(true);
    }

    class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        if(e.getSource() = saveBut){

            command.storeInMemento(listCommand);
            caretaker.addMemento(command.storeInMemento());

            saveCommand++;
            currentCommand++;

            System.out.println("Save" + saveCommand);
            undoBut.setEnabled(true);
        } else
            if(e.getSource() = undoBut){

                if(currentCommand >-1){
                    currentCommand --;

                }
            }




        }
    }
}
