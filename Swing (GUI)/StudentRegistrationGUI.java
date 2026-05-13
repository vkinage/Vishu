import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentRegistrationGUI extends JFrame implements ActionListener {

    JTextField t1, t2, t3, t4;
    JTextArea address, output;

    JRadioButton male, female, other;
    JCheckBox java, python, web, ds;

    JComboBox<String> branch;

    JList<String> hobbies;

    JButton submit, clear, exit;

    StudentRegistrationGUI() {

        setTitle("Student Registration Form");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLayout(new GridLayout(0, 2, 5, 5));

        // TextFields
        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();

        // Gender
        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        other = new JRadioButton("Other");

        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);
        bg.add(other);

        JPanel genderPanel = new JPanel();
        genderPanel.add(male);
        genderPanel.add(female);
        genderPanel.add(other);

        // Checkboxes
        java = new JCheckBox("Java");
        python = new JCheckBox("Python");
        web = new JCheckBox("Web Dev");
        ds = new JCheckBox("Data Science");

        JPanel coursePanel = new JPanel();
        coursePanel.add(java);
        coursePanel.add(python);
        coursePanel.add(web);
        coursePanel.add(ds);

        // ComboBox
        String branches[] = {"CS", "IT", "ENTC", "Mechanical", "Civil"};
        branch = new JComboBox<>(branches);

        // JList
        String hob[] = {"Reading", "Sports", "Music", "Coding", "Travel"};
        hobbies = new JList<>(hob);
        hobbies.setVisibleRowCount(3);

        // Address
        address = new JTextArea(3, 20);

        // Output
        output = new JTextArea(5, 20);
        output.setEditable(false);

        // Buttons
        submit = new JButton("Submit");
        clear = new JButton("Clear");
        exit = new JButton("Exit");

        submit.addActionListener(this);
        clear.addActionListener(this);
        exit.addActionListener(this);

        // Add Components
        add(new JLabel("Name"));
        add(t1);

        add(new JLabel("Email"));
        add(t2);

        add(new JLabel("Contact"));
        add(t3);

        add(new JLabel("City"));
        add(t4);

        add(new JLabel("Gender"));
        add(genderPanel);

        add(new JLabel("Courses"));
        add(coursePanel);

        add(new JLabel("Branch"));
        add(branch);

        add(new JLabel("Hobbies"));
        add(new JScrollPane(hobbies));

        add(new JLabel("Address"));
        add(new JScrollPane(address));

        add(submit);
        add(clear);

        add(exit);

        add(new JLabel("Output"));
        add(new JScrollPane(output));

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == submit) {

            if (t1.getText().isEmpty() || t2.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Name and Email cannot be empty");
                return;
            }

            String gender = "";
            if (male.isSelected()) gender = "Male";
            if (female.isSelected()) gender = "Female";
            if (other.isSelected()) gender = "Other";

            String courses = "";
            if (java.isSelected()) courses += "Java ";
            if (python.isSelected()) courses += "Python ";
            if (web.isSelected()) courses += "Web Dev ";
            if (ds.isSelected()) courses += "Data Science ";

            String hobby = hobbies.getSelectedValuesList().toString();

            String result =
                    "Name: " + t1.getText() +
                    "\nEmail: " + t2.getText() +
                    "\nBranch: " + branch.getSelectedItem() +
                    "\nGender: " + gender +
                    "\nCourses: " + courses +
                    "\nHobbies: " + hobby;

            output.setText(result);

            JOptionPane.showMessageDialog(this, result);
        }

        else if (e.getSource() == clear) {

            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
            address.setText("");
            output.setText("");

        }

        else if (e.getSource() == exit) {

            int x = JOptionPane.showConfirmDialog(
                    this,
                    "Do you want to exit?"
            );

            if (x == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        new StudentRegistrationGUI();
    }
}