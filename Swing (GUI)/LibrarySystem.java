import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class LibrarySystem extends JFrame implements ActionListener {

    JTextField searchField;
    JButton searchBtn, issueBtn, returnBtn, clearBtn;
    JTable table;
    DefaultTableModel model;
    JLabel resultLabel;
    JComboBox<String> categoryBox;

    LibrarySystem() {

        setTitle("Library Book System");
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Top Panel
        JPanel top = new JPanel();

        searchField = new JTextField(15);

        searchBtn = new JButton("Search");
        issueBtn = new JButton("Issue Book");
        returnBtn = new JButton("Return Book");
        clearBtn = new JButton("Clear");

        String categories[] = {
                "All", "Fiction", "Science",
                "History", "Technology"
        };

        categoryBox = new JComboBox<>(categories);

        top.add(new JLabel("Search"));
        top.add(searchField);
        top.add(categoryBox);
        top.add(searchBtn);
        top.add(issueBtn);
        top.add(returnBtn);
        top.add(clearBtn);

        add(top, BorderLayout.NORTH);

        // Table
        String cols[] = {
                "BookID", "Title",
                "Author", "Category", "Status"
        };

        model = new DefaultTableModel(cols, 0);

        table = new JTable(model);

        JScrollPane sp = new JScrollPane(table);

        add(sp, BorderLayout.CENTER);

        // Result Label
        resultLabel = new JLabel("Books Found: 0");
        add(resultLabel, BorderLayout.SOUTH);

        // Preloaded Books
        model.addRow(new Object[]{"101", "Core Java", "James", "Technology", "Available"});
        model.addRow(new Object[]{"102", "Python Basics", "Mark", "Technology", "Available"});
        model.addRow(new Object[]{"103", "History of India", "Raj", "History", "Available"});
        model.addRow(new Object[]{"104", "Physics", "John", "Science", "Available"});
        model.addRow(new Object[]{"105", "Harry Potter", "Rowling", "Fiction", "Available"});
        model.addRow(new Object[]{"106", "Data Science", "Andrew", "Science", "Available"});

        // Menu Bar
        JMenuBar mb = new JMenuBar();

        JMenu file = new JMenu("File");
        JMenu help = new JMenu("Help");

        JMenuItem exit = new JMenuItem("Exit");
        JMenuItem about = new JMenuItem("About");

        exit.addActionListener(e -> System.exit(0));

        about.addActionListener(e -> JOptionPane.showMessageDialog(this, "Library Management System"));

        file.add(exit);
        help.add(about);

        mb.add(file);
        mb.add(help);

        setJMenuBar(mb);

        // Button Actions
        searchBtn.addActionListener(this);
        issueBtn.addActionListener(this);
        returnBtn.addActionListener(this);
        clearBtn.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        // SEARCH
        if (e.getSource() == searchBtn) {

            String text = searchField.getText().toLowerCase();
            String category = categoryBox.getSelectedItem().toString();

            int count = 0;

            for (int i = 0; i < table.getRowCount(); i++) {

                String title = model.getValueAt(i, 1).toString().toLowerCase();
                String author = model.getValueAt(i, 2).toString().toLowerCase();
                String cat = model.getValueAt(i, 3).toString();

                boolean matchText = title.contains(text) || author.contains(text);

                boolean matchCategory = category.equals("All") || cat.equals(category);

                if (matchText && matchCategory) {
                    table.setRowSelectionInterval(i, i);
                    count++;
                }
            }
            resultLabel.setText("Books Found: " + count);
        }

        // ISSUE BOOK
        else if (e.getSource() == issueBtn) {
            int row = table.getSelectedRow();

            if (row != -1) {
                model.setValueAt("Issued", row, 4);
                JOptionPane.showMessageDialog(this, "Book Issued Successfully");
            }
        }

        // RETURN BOOK
        else if (e.getSource() == returnBtn) {
            int row = table.getSelectedRow();

            if (row != -1) {
                model.setValueAt("Available", row, 4);
                JOptionPane.showMessageDialog(this, "Book Returned Successfully");
            }
        }

        // CLEAR
        else if (e.getSource() == clearBtn) {
            searchField.setText("");
            table.clearSelection();
            resultLabel.setText("Books Found: 0");
            categoryBox.setSelectedIndex(0);
        }
    }

    public static void main(String[] args) {
        new LibrarySystem();
    }
}