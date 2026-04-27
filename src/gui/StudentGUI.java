package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.ResultSet;

import dao.StudentDAO;
import model.student;

public class StudentGUI extends JFrame {

    private JTextField idField, nameField, ageField;
    private JTable table;
    private DefaultTableModel tableModel;
    private StudentDAO sDao;

    public StudentGUI() {
        sDao = new StudentDAO();

        setTitle("Student Management System");
        setSize(500, 400);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // TOP PANEL (Inputs)
        JPanel inputPanel = new JPanel(new GridLayout(3, 2));

        inputPanel.add(new JLabel("ID:"));
        idField = new JTextField();
        inputPanel.add(idField);

        inputPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Age:"));
        ageField = new JTextField();
        inputPanel.add(ageField);

        add(inputPanel, BorderLayout.NORTH);

        // BUTTON PANEL
        JPanel buttonPanel = new JPanel();

        JButton addBtn = new JButton("Add");
        JButton updateBtn = new JButton("Update");
        JButton deleteBtn = new JButton("Delete");
        JButton viewBtn = new JButton("View");

        buttonPanel.add(addBtn);
        buttonPanel.add(updateBtn);
        buttonPanel.add(deleteBtn);
        buttonPanel.add(viewBtn);

        add(buttonPanel, BorderLayout.CENTER);

        // TABLE
        tableModel = new DefaultTableModel(new String[]{"ID", "Name", "Age"}, 0);
        table = new JTable(tableModel);

        add(new JScrollPane(table), BorderLayout.SOUTH);

        // BUTTON ACTIONS

        addBtn.addActionListener(e -> {
            try {
                int id = Integer.parseInt(idField.getText());
                String name = nameField.getText();
                int age = Integer.parseInt(ageField.getText());

                student s = new student();
                s.setId(id);
                s.setName(name);
                s.setAge(age);

                sDao.addStudent(s);
                JOptionPane.showMessageDialog(this, "Added!");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid input!");
            }
        });

        updateBtn.addActionListener(e -> {
            try {
                int id = Integer.parseInt(idField.getText());
                String name = nameField.getText();
                int age = Integer.parseInt(ageField.getText());

                student s = new student();
                s.setId(id);
                s.setName(name);
                s.setAge(age);

                sDao.updateStudent(s);
                JOptionPane.showMessageDialog(this, "Updated!");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid input!");
            }
        });

        deleteBtn.addActionListener(e -> {
            try {
                int id = Integer.parseInt(idField.getText());
                sDao.deleteStudent(id);
                JOptionPane.showMessageDialog(this, "Deleted!");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Enter valid ID!");
            }
        });

        viewBtn.addActionListener(e -> loadTable());

        setVisible(true);
    }

    // LOAD DATA INTO TABLE
    private void loadTable() {
        try {
            tableModel.setRowCount(0); // clear old data

            ResultSet rs = sDao.getStudentsResultSet();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");

                tableModel.addRow(new Object[]{id, name, age});
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new StudentGUI();
    }
}