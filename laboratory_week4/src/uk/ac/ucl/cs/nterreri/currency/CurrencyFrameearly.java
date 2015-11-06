package uk.ac.ucl.cs.nterreri.currency;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.text.NumberFormat;

public class CurrencyFrameearly extends JFrame {

	/**
	 * adding serialVersionUID avoids a warning (?)
	 */
	private static final long serialVersionUID = 122380596439679935L;
	private JPanel contentPane;
	
	private JComboBox<String> currencyFromSelection;
	private JComboBox<String> currencyToSelection;
	
	private JFormattedTextField textField_amt;
	private JFormattedTextField textField_rslt;

	private Currency currencyFrom;
	private Currency currencyTo;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CurrencyFrameearly frame = new CurrencyFrameearly();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CurrencyFrameearly() {
		currencyFrom = new Currency();
		currencyTo = new Currency();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 402, 295);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCurrencyConverter = new JLabel("Currency Converter");
		lblCurrencyConverter.setBounds(5, 5, 438, 15);
		contentPane.add(lblCurrencyConverter);
		
		currencyFromSelection = new JComboBox<String>();
		currencyFromSelection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//User selects item from left combobox:
				String selectedCurrency = 
						(String)currencyFromSelection.getSelectedItem();
				//Constructor using name is called (Currency(String)):
				try {
					currencyFrom = new Currency(selectedCurrency);
				} catch (InvalidCurrencyException e) {
					currencyFrom = new Currency();
					e.printStackTrace();
				}
			}
		});
		currencyFromSelection.setModel(new DefaultComboBoxModel<String>(new String[] {"", "GBP", "USD", "YEN", "EUR"}));
		currencyFromSelection.setBounds(5, 82, 149, 24);
		contentPane.add(currencyFromSelection);
		
		JLabel lblConvertFrom = new JLabel("Convert from:");
		lblConvertFrom.setBounds(5, 55, 149, 15);
		contentPane.add(lblConvertFrom);
		
		JLabel lblConvertTo = new JLabel("Convert to:");
		lblConvertTo.setBounds(229, 55, 106, 15);
		contentPane.add(lblConvertTo);
		
		currencyToSelection = new JComboBox<String>();
		currencyToSelection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String selectedCurrency = 
						(String)currencyToSelection.getSelectedItem();
				try {
					currencyTo = new Currency(selectedCurrency);
				} catch (InvalidCurrencyException e) {
					currencyTo = new Currency();
					e.printStackTrace();
				}
			}
		});
		currencyToSelection.setModel(new DefaultComboBoxModel<String>(new String[] {"", "GBP", "USD", "YEN", "EUR"}));
		currencyToSelection.setBounds(229, 82, 161, 24);
		contentPane.add(currencyToSelection);
		
		JLabel lblAmount = new JLabel("Amount:");
		lblAmount.setBounds(12, 118, 70, 15);
		contentPane.add(lblAmount);
		
		JLabel lblResult = new JLabel("Result:");
		lblResult.setBounds(229, 118, 70, 15);
		contentPane.add(lblResult);
		
		textField_amt = new JFormattedTextField(NumberFormat.getNumberInstance());
		textField_amt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_rslt.setText(Double.toString(convert()));
			}
		});
		textField_amt.setBounds(5, 134, 114, 19);
		contentPane.add(textField_amt);
		textField_amt.setColumns(10);
		
		textField_rslt = new JFormattedTextField(NumberFormat.getNumberInstance());
		textField_rslt.setEditable(false);
		textField_rslt.setBounds(229, 134, 114, 19);
		contentPane.add(textField_rslt);
		textField_rslt.setColumns(10);
		
		JButton btnConvert = new JButton("Convert");
		btnConvert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_rslt.setValue(convert());
			}
		});
		btnConvert.setBounds(5, 165, 117, 25);
		contentPane.add(btnConvert);
		
		
	}
	
	public double convert(){
		try {
			return Double.parseDouble(textField_amt.getText()) *
				currencyFrom.compute_conversion_factor(currencyTo);
		} catch (ArithmeticException e) {
			e.printStackTrace();
			return 0.0;
		}
	}
}
