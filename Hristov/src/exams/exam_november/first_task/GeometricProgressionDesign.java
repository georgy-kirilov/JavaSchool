package exams.exam_november.first_task;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GeometricProgressionDesign 
{

	private JFrame frame;
	private JTextField txtInitialTerm;
	private JTextField txtCommonRatio;
	private JTextField txtNthTerm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					GeometricProgressionDesign window = new GeometricProgressionDesign();
					window.frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GeometricProgressionDesign() 
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblInitialTerm = new JLabel("Initial term:");
		lblInitialTerm.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblInitialTerm.setBounds(22, 28, 88, 21);
		frame.getContentPane().add(lblInitialTerm);
		
		txtInitialTerm = new JTextField();
		txtInitialTerm.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtInitialTerm.setBounds(132, 28, 45, 20);
		frame.getContentPane().add(txtInitialTerm);
		txtInitialTerm.setColumns(10);
		
		JLabel lblCommonRatio = new JLabel("Common ratio:");
		lblCommonRatio.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblCommonRatio.setBounds(22, 60, 88, 21);
		frame.getContentPane().add(lblCommonRatio);
		
		txtCommonRatio = new JTextField();
		txtCommonRatio.setHorizontalAlignment(SwingConstants.LEFT);
		txtCommonRatio.setBounds(132, 59, 45, 20);
		frame.getContentPane().add(txtCommonRatio);
		txtCommonRatio.setColumns(10);
		
		JLabel lblNthTerm = new JLabel("N-th Term:");
		lblNthTerm.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNthTerm.setBounds(22, 92, 74, 14);
		frame.getContentPane().add(lblNthTerm);
		
		txtNthTerm = new JTextField();
		txtNthTerm.setBounds(132, 90, 45, 20);
		frame.getContentPane().add(txtNthTerm);
		txtNthTerm.setColumns(10);
		
		JButton btnPrintTerms = new JButton("Print terms");
		
		btnPrintTerms.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnPrintTerms.setBounds(22, 144, 108, 23);
		frame.getContentPane().add(btnPrintTerms);
		
		JButton btnClear = new JButton("Clear");
		
		btnClear.setBounds(22, 178, 108, 23);
		frame.getContentPane().add(btnClear);
		
		JButton btnExit = new JButton("Exit");
		
		btnExit.setBounds(22, 212, 108, 23);
		frame.getContentPane().add(btnExit);
		
		JTextArea txtAreaPrintTerms = new JTextArea();
		txtAreaPrintTerms.setBounds(224, 47, 181, 187);
		frame.getContentPane().add(txtAreaPrintTerms);
		
		JLabel lblPrintTerms = new JLabel("Print terms:");
		lblPrintTerms.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblPrintTerms.setBounds(224, 22, 74, 14);
		frame.getContentPane().add(lblPrintTerms);
		
		btnClear.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				String emptyString = "";
				
				txtInitialTerm.setText(emptyString);
				txtCommonRatio.setText(emptyString);
				txtNthTerm.setText(emptyString);
				txtAreaPrintTerms.setText(emptyString);
			}
		});
		
		btnPrintTerms.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{	
				try
				{
					double initialTerm = Double.parseDouble(txtInitialTerm.getText());
					double commonRatio = Double.parseDouble(txtCommonRatio.getText());
					int nThTerm = Integer.parseInt(txtNthTerm.getText());
					
					GeometricProgression progression = new 
							GeometricProgression(initialTerm, commonRatio);
					
					String output = progression.printNTermsStartingFromM(1, nThTerm - 1);
					txtAreaPrintTerms.setText(output);
				}
				catch (RuntimeException ex)
				{
					JOptionPane.showMessageDialog(frame, ex.getMessage());
				}
			}
		});
		
		btnExit.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				System.exit(0);
			}
		});
	}
}
