package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.text.NumberFormatter;

import bmi.People;

public class MainFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JFormattedTextField height,weight;
	private JComboBox comboGender;
	
	public MainFrame() {
		this.setLayout(new BorderLayout());
		this.add(CreateTitle(), BorderLayout.NORTH);
		this.add(Createteste());
		this.CreateWindow();
	}
	
	public Panel CreateTitle(){
		
		JLabel labelTitle = new JLabel("Enter your data");
		Panel panelTitle = new Panel();
		
		labelTitle.setHorizontalAlignment(JLabel.CENTER);
		panelTitle.setLayout(new BorderLayout());
		labelTitle.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		panelTitle.add(labelTitle, BorderLayout.NORTH); 
		   
		return panelTitle;
	}
	
	public JPanel Createteste(){
		
		JPanel grid = new JPanel(new GridLayout(1,4));
		
		grid.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		grid.add(CreateWeightButton());
		grid.add(CreateHeightButton());
		grid.add(CreateGenderButton());
		grid.add(CreateButton());
		
		return(grid);
	}
	
	public JPanel CreateGenderButton(){
		
		JPanel panel = new JPanel(new BorderLayout());
		JLabel label = new JLabel("Gender");
		String[] values = { "Female", "Male" };
		
		comboGender = new JComboBox(values);
		comboGender.setSelectedIndex(1);
		label.setBorder(BorderFactory.createEmptyBorder(0,1,0,0));
		panel.setBorder(BorderFactory.createEmptyBorder(0,5,5,5));
		panel.add(label, BorderLayout.NORTH);
		panel.add(comboGender, BorderLayout.CENTER);
		
		return(panel);
	}
		
	public JPanel CreateButton(){
		JPanel panel = new JPanel(new BorderLayout());
		JButton btnCalculator = new JButton();
		
		btnCalculator.setText("Calculate");
		btnCalculator.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SaveValues();
			}
		});
		panel.setBorder(BorderFactory.createEmptyBorder(15,5,5,5));
		panel.add(btnCalculator, BorderLayout.CENTER);
		
		return(panel);
	}
	public void SaveValues(){
		People people = new People();
		try {
			people.setHeight(Float.parseFloat(this.height.getText()));
			people.setWeight(Float.parseFloat(this.weight.getText()));
			JOptionPane.showMessageDialog(this.getContentPane(), "Your BMI is: "+people.calcBMI()  );
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this.getContentPane(), "Please, enter your date!");
		}	
	}
	
	public JPanel CreateWeightButton(){
		
		JPanel panel = new JPanel(new BorderLayout());
		JLabel label = new JLabel("Weight");
	
		
		label.setBorder(BorderFactory.createEmptyBorder(0,1,0,0));
		this.weight = new JFormattedTextField(getNumberFormatter());
		panel.setBorder(BorderFactory.createEmptyBorder(0,5,5,5));
		panel.add(label, BorderLayout.NORTH);
		panel.add(weight, BorderLayout.CENTER);
		
		return(panel);
	}
	
	
	public JPanel CreateHeightButton(){
		
		JPanel panel = new JPanel(new BorderLayout());
		JLabel label = new JLabel("Heigth");
		
		label.setBorder(BorderFactory.createEmptyBorder(0,1,0,0));
		height = new JFormattedTextField(getNumberFormatter());
		panel.setBorder(BorderFactory.createEmptyBorder(0,5,5,5));
		panel.add(label, BorderLayout.NORTH);
		panel.add(height, BorderLayout.CENTER);
		
		return(panel);
	}
	
	public NumberFormatter getNumberFormatter(){
		
		NumberFormat longFormat = NumberFormat.getIntegerInstance();
		NumberFormatter numberFormatter = new NumberFormatter(new DecimalFormat());
		numberFormatter.setValueClass(Integer.class);
		numberFormatter.setMinimum(0);
		numberFormatter.setMaximum(Integer.MAX_VALUE);
		numberFormatter.setCommitsOnValidEdit(true);
		numberFormatter.setAllowsInvalid(false);
		
		return(numberFormatter);
	}
	
	public void CreateWindow(){		
		this.setSize(420, 120);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setTitle("BMI Calculator");
		this.setVisible(true);
	}
	
	public void ShowResult(People people){
		
	}
}
