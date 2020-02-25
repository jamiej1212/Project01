package proj01;

import javax.swing.*;
import java.awt.*;

public class AddressBookGUI
{
    private JPanel window01;
    private JPanel window02;
    private JScrollPane scrollPanel;
    private JButton displayButton;
    private JButton newButton;
    private JButton removeButton;
    private JPanel box;

    public static void main(String args[])
    {
        AddressBookGUI inst = new AddressBookGUI();
        JFrame frame = new JFrame("Address Book");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(inst.windowBox());
        frame.pack();
        frame.setVisible(true);
    }

    private JPanel windowBox()
    {
        box = new JPanel();
        box.setLayout(new BorderLayout());
        box.add(firstWindow(), BorderLayout.CENTER);
        box.add(secondWindow(), BorderLayout.SOUTH);

        return box;

    }

    private JPanel firstWindow()
    {
        window01 = new JPanel();
        scrollPanel = new JScrollPane();
        scrollPanel.setPreferredSize(new Dimension(100,50));
        scrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        //window01.setLayout(new GridLayout(2, 2, 10, 10));
        window01.add(scrollPanel, BorderLayout.NORTH);
        window01.setBounds(0, 0, 300, 150);

        return window01;
    }

    private JPanel secondWindow()
    {
        window02 = new JPanel();
        displayButton = new JButton("Display");
        newButton = new JButton("New");
        removeButton = new JButton("Remove");
        //window02.setLayout(new GridLayout(2, 4, 10, 10));
        window02.add(displayButton);
        window02.add(newButton);
        window02.add(removeButton);
        window02.setBounds(0, 150, 300, 150);
        return window02;
    }

}
