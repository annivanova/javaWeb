package com.srk.pkg;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.SwingConstants;

public class DbEntry extends JFrame {

	private JPanel contentPane;
	private JTextField tfpublisher;
	private JTextField tfAuthor;
	private JTextField tfmovie;
	private JTextField tfTitle;
	private JTextField tfid;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DbEntry frame = new DbEntry();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection connection=null;
	private JTextField id;
	public DbEntry() {
		connection=MyConnection.dbConnectior();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 539, 352);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfpublisher = new JTextField();
		tfpublisher.setBounds(241, 155, 118, 28);
		contentPane.add(tfpublisher);
		tfpublisher.setColumns(10);
		
		tfAuthor = new JTextField();
		tfAuthor.setBounds(241, 116, 118, 28);
		contentPane.add(tfAuthor);
		tfAuthor.setColumns(10);
		
		tfmovie = new JTextField();
		tfmovie.setBounds(241, 200, 118, 28);
		contentPane.add(tfmovie);
		tfmovie.setColumns(10);
		
		tfTitle = new JTextField();
		tfTitle.setBounds(241, 71, 118, 28);
		contentPane.add(tfTitle);
		tfTitle.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("title");
		lblNewLabel.setBounds(61, 75, 140, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("authors");
		lblNewLabel_1.setBounds(61, 123, 118, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("publisher");
		lblNewLabel_2.setBounds(59, 162, 142, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("movie");
		lblNewLabel_3.setBounds(61, 207, 118, 14);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection myConn=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?useSSL=false&serverTimeZone=Europe/Sofia", "", "");
					JOptionPane.showMessageDialog(null, "Connection established");
					
					PreparedStatement stmt= myConn.prepareStatement("INSERT INTO books(title,authors,publisher,movie)VALUES(?,?,?,?)");
					stmt.setString(1, tfTitle.getText());
					stmt.setString(2, tfAuthor.getText());
					stmt.setString(3, tfpublisher.getText());
					stmt.setString(4, tfmovie.getText());
					stmt.execute();
					JOptionPane.showMessageDialog(null, "insert succesfull");
				}
			 catch (ClassNotFoundException | SQLException e)  {
				e.printStackTrace();
			}	
					 	
			}
		});
		btnNewButton.setBounds(341, 239, 89, 43);
		contentPane.add(btnNewButton);
		
		JButton delbtn = new JButton("delete");
		delbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String query= "DELETE from books where id='"+tfid.getText()+"'";
					PreparedStatement stmt= connection.prepareStatement(query);
					stmt.execute();
					JOptionPane.showMessageDialog(null, "Data Deteled");
					stmt.close();
				}
				catch(Exception ex){
					ex.printStackTrace();
				}
			}
		});
		delbtn.setBounds(25, 239, 89, 43);
		contentPane.add(delbtn);
		
		JButton update = new JButton("update");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String query= "Update books set title='"+tfTitle.getText()+"', authors='"+tfAuthor.getText()+"',publisher='"+tfpublisher.getText()+"', movie='"+tfmovie.getText()+"'";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.execute();
					JOptionPane.showMessageDialog(null, "Updated");
					pst.close();
				}
				catch(Exception ex){
					ex.printStackTrace();
				}
			}
		});
		update.setBounds(178, 239, 89, 43);
		contentPane.add(update);
		
		tfid = new JTextField();
		tfid.setBounds(241, 26, 118, 34);
		contentPane.add(tfid);
		tfid.setColumns(10);
		
		JLabel lblId = new JLabel("IDM");
		lblId.setBounds(61, 36, 46, 14);
		contentPane.add(lblId);
	}
}
