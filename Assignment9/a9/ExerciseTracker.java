package a9;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

/**
 * CPSC 24500-001- Object-Oriented Programming
 * Assignment 9
 * The ExerciseTracker class represents a GUI application for tracking exercises.
 * It allows users to log in, add exercises of various types (Run/Walk, Rock Climbing, Weightlifting)
 * save exercises to a file and view exercise summaries.
 */
public class ExerciseTracker {
    private JFrame frame;
    private JMenuBar menuBar;
    private JMenu fileMenu, helpMenu;
    private JMenuItem loginMenuItem, logoutMenuItem, saveMenuItem, exitMenuItem, aboutMenuItem;
    private JLabel nameLabel, dateLabel, durationLabel, commentLabel, distanceLabel, exerciseSummaryLabel;
    private JTextField nameField, dateField, durationField, distanceField, usernameField;
    private JPasswordField passwordField;
    JPanel loginPanel;
    private JButton addExerciseButton,sortByDateButton, sortByCaloriesButton;
    private JTextArea exerciseSummaryTextArea,commentField;
    private JScrollPane exerciseSummaryScrollPane;
    private boolean isLoggedIn = false;
    private JDialog dialog;



    private ArrayList<Exercise> exerciseList = new ArrayList<>();

    /**
     * Constructs a new ExerciseTracker object and initializes the GUI.
     */
    public ExerciseTracker() {
        frame = new JFrame("Exercise Tracker");
        frame.setSize(700, 400);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        helpMenu = new JMenu("Help");

        loginMenuItem = new JMenuItem("Log in");
        logoutMenuItem = new JMenuItem("Log out");
        saveMenuItem = new JMenuItem("Save");
        exitMenuItem = new JMenuItem("Exit");
        aboutMenuItem = new JMenuItem("About");

        fileMenu.add(loginMenuItem);
        fileMenu.add(logoutMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.add(exitMenuItem);
        helpMenu.add(aboutMenuItem);

        menuBar.add(fileMenu);
        menuBar.add(helpMenu);

        frame.setJMenuBar(menuBar);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(5, 2));

        nameLabel = new JLabel("Name:");
        nameField = new JTextField();
        dateLabel = new JLabel("Date (MM/dd/yyyy):");
        dateField = new JTextField();
        durationLabel = new JLabel("Duration:");
        durationField = new JTextField();
        distanceLabel = new JLabel("Distance:");
        distanceField = new JTextField();
        commentLabel = new JLabel("Add Comment:");
        commentField = new JTextArea(1,4);
       
        
        addExerciseButton = new JButton("Add Exercise");

        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(dateLabel);
        inputPanel.add(dateField);
        inputPanel.add(durationLabel);
        inputPanel.add(durationField);
        inputPanel.add(distanceLabel);
        inputPanel.add(distanceField);       
        
       // Panel for comment label and field
        JPanel commentPanel = new JPanel(new BorderLayout());
        commentPanel.add(commentLabel, BorderLayout.NORTH);
        commentPanel.add(commentField, BorderLayout.CENTER);
        inputPanel.add(commentPanel);
        
        frame.add(inputPanel, BorderLayout.WEST);

      
        JPanel summaryPanel = new JPanel(new BorderLayout());
        summaryPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 10));

        exerciseSummaryLabel = new JLabel("Exercise Summary");
        exerciseSummaryLabel.setHorizontalAlignment(JLabel.CENTER);
        exerciseSummaryTextArea = new JTextArea(10, 35);
        exerciseSummaryTextArea.setEditable(false);
        exerciseSummaryScrollPane = new JScrollPane(exerciseSummaryTextArea);
        
        
        //sort buttons
        sortByDateButton = new JButton("Sort By Date");
        sortByCaloriesButton = new JButton("Sort By Calories");
        JPanel summaryButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        summaryButtonPanel.add(sortByDateButton);
        summaryButtonPanel.add(sortByCaloriesButton);
        sortByDateButton.setVisible(false);
        sortByCaloriesButton.setVisible(false);
        
        
        summaryPanel.add(exerciseSummaryLabel, BorderLayout.NORTH);
        summaryPanel.add(exerciseSummaryScrollPane, BorderLayout.CENTER);
        summaryPanel.add(summaryButtonPanel, BorderLayout.SOUTH);

        frame.add(summaryPanel, BorderLayout.EAST);
        
        
        // a panel for the "Add Exercise" button
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        addExerciseButton = new JButton("Add Exercise");
        buttonPanel.add(addExerciseButton);

        frame.add(buttonPanel, BorderLayout.SOUTH);

      
        //Action Listener classes for the buttons and menu items
        addExerciseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addExercise();
            }
        });


        loginMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });
        
        logoutMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                logout();
            }
        });
        
        saveMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveExercisesToFile();
            }
        });

        exitMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        aboutMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showAboutDialog();
            }
        });
     // Add action listeners to sorting buttons
        sortByDateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sortByDate();
            }
        });

        sortByCaloriesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sortByCaloriesBurned();
            }
        });

        toggleInputFields(false); // Disable input fields initially
        frame.setVisible(true);
    }

    //login the user
    private void login() {
    	
    	 loginPanel = new JPanel();
        loginPanel.setLayout(new GridLayout(6, 1));
        loginPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding
        JLabel usernameLabel = new JLabel("Username:");
         usernameField = new JTextField(15);
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(15);
          
        JButton loginButton = new JButton("Login");
        JButton cancelButton = new JButton("Cancel");
        loginPanel.add(usernameLabel);
        loginPanel.add(usernameField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);
        loginPanel.add(new JPanel());
        loginPanel.add(new JPanel());
        loginPanel.add(loginButton);
        loginPanel.add(cancelButton);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (username.equals("healthy") && password.equals("donut")) {
                    isLoggedIn = true;
                    toggleInputFields(true);
                    JOptionPane.showMessageDialog(frame, "Logged in Successfully");
                    dialog.setVisible(false);
                    
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid username or password");
                }
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dialog.setVisible(false); // Close the dialog

            }
        });
        
     // Create the dialog
        dialog = new JDialog(frame, "Please log in", true); // true makes it modal
        dialog.add(loginPanel);
        dialog.setPreferredSize(new Dimension(300, 200));
        dialog.pack();
        dialog.setLocationRelativeTo(frame);
        dialog.setVisible(true);
    
   }
    	
    //logout the user
    private void logout() {
    	if (isLoggedIn) {
        isLoggedIn = false;
        JOptionPane.showMessageDialog(frame, "Logged out successfully");
        toggleInputFields(false);
        sortByDateButton.setVisible(false);
        sortByCaloriesButton.setVisible(false);
    	}
    	else
    	JOptionPane.showMessageDialog(frame, "Please log in first.");
    	
    	
    }
    //Toggles the input fields based on the login state.
    private void toggleInputFields(boolean enabled) {
        nameField.setEnabled(enabled);
        dateField.setEnabled(enabled);
        durationField.setEnabled(enabled);
        distanceField.setEnabled(enabled);
        commentField.setEnabled(enabled);
        addExerciseButton.setEnabled(enabled);
        if(!enabled) {
        	nameField.setText("");
            dateField.setText("");
            durationField.setText("");
            distanceField.setText("");
            commentField.setText("");
        }
    }
    //Adds a new exercise
    private void addExercise() {
        if (!isLoggedIn) {
            JOptionPane.showMessageDialog(frame, "Please log in first.");
            return;
        }

        String name = nameField.getText();
        String dateString = dateField.getText();
        String comment = commentField.getText();

        if (name.isEmpty() || dateString.isEmpty() || comment.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Please fill in all fields.");
            return;
        }

        Date date;
        try {
            date = new SimpleDateFormat("MM/dd/yyyy").parse(dateString);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, "Invalid date format. Please use MM/dd/yyyy.");
            return;
        }

        double duration;
        try {
            duration = Double.parseDouble(durationField.getText());
            if (duration <= 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "The Duration must be a non zero number");
            return;
        }
        
        double distance;
        try {
        	distance = Double.parseDouble(distanceField.getText());
            if (distance <= 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "The Distance must be a non zero number.");
            return;
        }
        
     // Prompt the user to select the type of exercise
        String[] exerciseTypes = {"Run/Walk", "Rock Climbing", "Weightlifting"};
        String selectedType = (String) JOptionPane.showInputDialog(frame, "Select exercise type:", "Add Exercise",
                JOptionPane.QUESTION_MESSAGE, null, exerciseTypes, exerciseTypes[0]);

        // Create the appropriate exercise based on the selected type
        Exercise exercise = null;
        if (selectedType != null) {
        switch (selectedType) {
            case "Run/Walk":
                exercise = new RunWalk(name, date, duration, comment, distance);
                break;
            case "Rock Climbing":
                exercise = promptForRockClimbingDetails(date);
                break;
            case "Weightlifting":
                exercise = promptForWeightLiftingDetails(date);
                break;
            
        }
        exerciseList.add(exercise);

        // Update total calories burned
        updateTotalCalories();
        updateExerciseSummary();    
        //sort buttons
        if(exerciseList.size()>1) {
        sortByDateButton.setVisible(true);
        sortByCaloriesButton.setVisible(true);
        }
        nameField.setText("");
        dateField.setText("");
        durationField.setText("");
        distanceField.setText("");
        commentField.setText("");
        }
        
    }
    //Updates the total calories burned.
    private void updateTotalCalories() {
        double totalCalories = 0;
        for (Exercise exercise : exerciseList) {
            totalCalories += exercise.getCaloriesBurned();
        }
            
        exerciseSummaryLabel.setText(String.format("Exercise Summary ( %.2f burned) ",totalCalories));
               
    }
    //Sorts the exercises by calories burned.
    private void sortByCaloriesBurned() {
    	if(exerciseList.size()>1)
    	{
        Collections.sort(exerciseList, new ExerciseCompareByCalories());
        }
    	updateExerciseSummary();
    	
    }
    //Sorts the exercises by date.
    public void sortByDate() {
    	if(exerciseList.size()>1)
    	{
    		Collections.sort(exerciseList, new Comparator<Exercise>() {
                @Override
                public int compare(Exercise e1, Exercise e2) {
                    return e1.compareTo(e2);
                }
            });
    	}
    	updateExerciseSummary();
    }
    
   // Updates the exercise summary text area with sorted exercises
    private void updateExerciseSummary()
    {
    	String tabulatedSummary = ExerciseWriter.tabulateSummary(exerciseList);

        // Set the text area to the tabulated summary
        exerciseSummaryTextArea.setText(tabulatedSummary);
    }
    //Prompts the user for Weightlifting details.
    private WeightLifting promptForWeightLiftingDetails(Date date) {
        JPanel weightLiftingPanel = new JPanel();
        weightLiftingPanel.setLayout(new GridLayout(1, 2));
        JLabel totalWeightLabel = new JLabel("Total Weight Lifted (lbs):");
        JTextField totalWeightField = new JTextField(15);
        weightLiftingPanel.add(totalWeightLabel);
        weightLiftingPanel.add(totalWeightField);

        int option = JOptionPane.showConfirmDialog(frame, weightLiftingPanel, "Weightlifting Details", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            try {
                double totalWeight = Double.parseDouble(totalWeightField.getText());
                // Validate input
                if (totalWeight <= 0) {
                    throw new NumberFormatException();
                }
                // Create and return a new WeightLifting instance
                return new WeightLifting(nameField.getText(),
                                         date,
                                         Double.parseDouble(durationField.getText()),
                                         commentField.getText(),
                                         totalWeight);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(frame, "Invalid input. Please enter a positive number for total weight lifted.");
                return null;
            }
        } else {
            return null;
        }
    }
    //Prompts the user for Rock Climbing details.
    private RockClimbing promptForRockClimbingDetails(Date date) {
        JPanel rockClimbingPanel = new JPanel();
        rockClimbingPanel.setLayout(new GridLayout(3, 2));
        JLabel wallHeightLabel = new JLabel("Wall Height (ft):");
        JTextField wallHeightField = new JTextField(15);
        JLabel repetitionsLabel = new JLabel("Repetitions:");
        JTextField repetitionsField = new JTextField(15);
        rockClimbingPanel.add(wallHeightLabel);
        rockClimbingPanel.add(wallHeightField);
        rockClimbingPanel.add(repetitionsLabel);
        rockClimbingPanel.add(repetitionsField);

        int option = JOptionPane.showConfirmDialog(frame, rockClimbingPanel, "Rock Climbing Details", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            try {
                double wallHeight = Double.parseDouble(wallHeightField.getText());
                int repetitions = Integer.parseInt(repetitionsField.getText());
                // Validate inputs
                if (wallHeight <= 0 || repetitions <= 0) {
                    throw new NumberFormatException();
                }
                // Create and return a new RockClimbing instance
                return new RockClimbing(nameField.getText(), 
                                         date, 
                                         Double.parseDouble(durationField.getText()), 
                                         commentField.getText(), 
                                         wallHeight, 
                                         repetitions);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(frame, "Invalid input. Please enter positive numbers for wall height and repetitions.");
                return null;
            }
        } else {
            return null;
        }
    }
    
    //Saves exercises to a file.
    private void saveExercisesToFile() {
    	
            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showSaveDialog(frame);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try (PrintWriter writer = new PrintWriter(file)) {
                    // Write each exercise to the file
//                    for (Exercise exercise : exerciseList) {
//                        writer.println(exercise.toString());
//                    }
                	ExerciseWriter.writeExercisesToFile(exerciseList, file);
                    JOptionPane.showMessageDialog(frame, "Exercises saved successfully.");
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(frame, "Error occurred while saving exercises.");
                    e.printStackTrace();
                }
            }
        }
       
    //Shows the about dialog under the Help menu
    private void showAboutDialog() {
        JOptionPane.showMessageDialog(frame, "Exercise Tracker Application\nVersion 2.0\nDeveloped by Sai Gokul");
    }
    //Main method to launch the ExerciseTracker application.
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ExerciseTracker();
            }
        });
    }
}



