import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BasicToDoApp {

    private JFrame frame;
    private JTextField taskField;
    private JButton addButton;
    private JButton deleteButton;
    private DefaultListModel<String> listModel;
    private JList<String> taskList;

    public BasicToDoApp() {
        // Frame setup
        frame = new JFrame("Basic ToDo App");
        frame.setSize(350, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null); // using absolute layout for simplicity

        // Input field
        taskField = new JTextField();
        taskField.setBounds(20, 20, 200, 30);
        frame.add(taskField);

        // Add button
        addButton = new JButton("Add");
        addButton.setBounds(230, 20, 80, 30);
        frame.add(addButton);

        // Task list
        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(taskList);
        scrollPane.setBounds(20, 70, 290, 200);
        frame.add(scrollPane);

        // Delete button
        deleteButton = new JButton("Delete");
        deleteButton.setBounds(100, 290, 120, 30);
        frame.add(deleteButton);

        // Add task action
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String task = taskField.getText().trim();
                if (!task.isEmpty()) {
                    listModel.addElement(task);
                    taskField.setText("");
                } else {
                    JOptionPane.showMessageDialog(frame, "Please enter a task.");
                }
            }
        });

        // Delete task action
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int index = taskList.getSelectedIndex();
                if (index != -1) {
                    listModel.remove(index);
                } else {
                    JOptionPane.showMessageDialog(frame, "Select a task to delete.");
                }
            }
        });

        // Show the GUI
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new BasicToDoApp();
    }
}
