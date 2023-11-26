/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Views;

import Model.Usuario;
import database.ConexaoBD;
import static database.ConexaoBD.getConexao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;
import Model.Usuario;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author bruno
 */
public class teste {
    
        private final Color BACKGROUND_COLOR = new Color(134, 163, 195);
	private final Color BACKGROUND_TABLE = new Color(157, 194, 236);
	private final Color COLOR_BLUE_LIGHT = new Color(199,231,238);
	private final int SCREEN_WIDTH = 500;
	private final int SCREEN_HIGHT = 180;
        private Statement statement;
        
        private List<Usuario> usuario = new ArrayList<>();
	private JTable table = new JTable();
	
    /**
     *
     */
    public teste() {
		formatReadAthlete();
	}

	private void formatReadAthlete() {
		setLayout(new BorderLayout());
		setTitle("Read Athlete");
		setSize(SCREEN_WIDTH, SCREEN_HIGHT);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane();

		readData();
		
		JPanel panel = new JPanel();
		add(panel);
		panel.add(table);
		
		table.setBackground(COLOR_BLUE_LIGHT);
		table.setPreferredScrollableViewportSize(new Dimension(480, 100));
	
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(table);
		scroll.getViewport().setBackground(BACKGROUND_TABLE);
		
		setModelTable();
		loadTable();
		
		panel.add(scroll);
		setVisible(true);
	}

	private void readData(){
        try {
            Connection connect = getConexao();
            statement  = connect.createStatement();
            
            
            String query = "SELECT * FROM usuario";
            
            ResultSet resultSet = statement.executeQuery(query);
            
            while(resultSet.next()){
                int id = resultSet.getInt("IdUsuario");
                String nome = resultSet.getString("NomeUsuario");
                String email = resultSet.getString("EmailUsuario");
                String login = resultSet.getString("LoginUsuario");
                String Senha = resultSet.getString("SenhaUsuario");
                
                usuario.add(new Usuario(id, nome, email, login, Senha));
                
                resultSet.close();
                statement.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
	
	public void loadTable() {
		DefaultTableModel model = (DefaultTableModel) table.getModel(); 
		model.setNumRows(0);

		table.getColumnModel().getColumn(0).setPreferredWidth(5);
		table.getColumnModel().getColumn(1).setPreferredWidth(20);
		table.getColumnModel().getColumn(2).setPreferredWidth(5);
		table.getColumnModel().getColumn(3).setPreferredWidth(10);
		table.getColumnModel().getColumn(4).setPreferredWidth(10);

		try {
			for(Usuario tempUser: usuario) {
				model.addRow(new Object[] {
					tempUser.getIdUsuario(),
                                        tempUser.getNomeUsuario(),
                                        tempUser.getEmailUsuario(),
                                        tempUser.getLoginUsuario(),
                                        tempUser.getSenhaUsuario()
					
				} );
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error to load the table on the database");
		}
	}
	
	public void setModelTable() {
		table.setModel(new DefaultTableModel(
		new Object[][] {
		},
		new String[] {
			"Id","Name", "Email", "Login", "Senha"
		}
		));
	}

    void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void setTitle(String read_Athlete) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void setLayout(BorderLayout borderLayout) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void add(JPanel panel) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private Object getContentPane() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void setDefaultCloseOperation(int DISPOSE_ON_CLOSE) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void setSize(int SCREEN_WIDTH, int SCREEN_HIGHT) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void setLocationRelativeTo(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
