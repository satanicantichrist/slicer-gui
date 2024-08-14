package com.mojang.slicer;

import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import static com.mojang.slicer.Slicer.skippedFiles;
import static com.mojang.slicer.Slicer.slicedFiles;

public class AppGui extends JPanel {
    private JTextField inputField;
    private JTextField outputField;
    private JTextField leftoverField;
    private String inputFolder;
    private String outputFolder;
    private String leftoverFolder;

    public AppGui(String minecraftVersion, List<InputFile> INPUTS, String sourcePath, String outputPath, String leftoverPath) {
        this.inputFolder = sourcePath;
        this.outputFolder = outputPath;
        this.leftoverFolder = leftoverPath;
        new AppGui(minecraftVersion, INPUTS);
    }

    public AppGui(String minecraftVersion, List<InputFile> INPUTS) {
        FlatLightLaf.setup();

        //construct components
        JFrame frame = new JFrame("Minecraft Slicer - " + minecraftVersion);
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        JButton inputButton = new JButton("...");
        JButton leftoverButton = new JButton("...");
        inputField = new JTextField(5);
        JButton outputButton = new JButton("...");
        JButton runButton = new JButton("Run");
        outputField = new JTextField(5);
        leftoverField = new JTextField(5);
        JLabel inputLabel = new JLabel("Input directory or .zip file");
        JLabel outputLabel = new JLabel("Output directory");
        JLabel leftoverLabel = new JLabel("Leftover directory");

        //adjust size and set layout
        setPreferredSize(new Dimension(578, 186));
        setLayout(null);

        //add components
        add(inputButton);
        add(leftoverButton);
        add(inputField);
        add(outputButton);
        add(runButton);
        add(outputField);
        add(leftoverField);
        add(inputLabel);
        add(outputLabel);
        add(leftoverLabel);

        //set component bounds (only needed by Absolute Positioning)
        inputButton.setBounds(500, 10, 50, 25);
        leftoverButton.setBounds(500, 70, 50, 25);
        inputField.setBounds(170, 10, 330, 25);
        outputButton.setBounds(500, 40, 50, 25);
        runButton.setBounds(235, 145, 100, 25);
        outputField.setBounds(170, 40, 330, 25);
        leftoverField.setBounds(170, 70, 330, 25);
        inputLabel.setBounds(27, 10, 150, 25);
        outputLabel.setBounds(70, 40, 100, 25);
        leftoverLabel.setBounds(64, 70, 115, 25);

        inputField.setText(inputFolder);
        outputField.setText(outputFolder);
        leftoverField.setText(leftoverFolder);

        inputButton.addActionListener(e -> {
            int returnVal = fileChooser.showOpenDialog(frame);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                inputField.setText(file.getAbsolutePath());
            }

        });

        outputButton.addActionListener(e -> {
            int returnVal = fileChooser.showOpenDialog(frame);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                outputField.setText(file.getAbsolutePath());
            }

        });

        leftoverButton.addActionListener(e -> {
            int returnVal = fileChooser.showOpenDialog(frame);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                leftoverField.setText(file.getAbsolutePath());
            }
        });

        runButton.addActionListener(e -> {
            inputFolder = inputField.getText();
            outputFolder = outputField.getText();
            leftoverFolder = leftoverField.getText();
            try {
                if (leftoverFolder.isBlank()) {
                    new Slicer(Path.of(inputFolder), Path.of(outputFolder), null).process(INPUTS);
                } else
                    new Slicer(Path.of(inputFolder), Path.of(outputFolder), Path.of(leftoverFolder)).process(INPUTS);
                if (slicedFiles == 0) {
                    JOptionPane.showMessageDialog(frame, "Skipped all files. \n" +
                            "This can be caused by an empty resource pack or it is already up to date");
                } else {
                    JOptionPane.showMessageDialog(frame, "Slicing finished. \n" +
                            "Created " + slicedFiles + " new files \n" +
                            "Skipped " + skippedFiles + " files");
                }

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.setResizable(false);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
