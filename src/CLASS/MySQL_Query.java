/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CLASS;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import javax.swing.JLabel;
import javax.swing.JOptionPane;


/**
 *
 * @author JAVIER
 */
//Generador Querys de Busqueda y modificacion de datos 
public class MySQL_Query extends CONEXION_MySQL  {
    
    private JLabel  TextCarga;
     // Abrir Conexion y heredar de la clase Conexion, se realiza para llamar los datos de MySQL
    public MySQL_Query(JLabel TextCarga1 ){
        Conexion();
        TextCarga= TextCarga1;
        TextCarga.setText("Abriendo Conexion...");
    }
    public ResultSet IniciosBD(){
        ResultSet querys= null;
        try {
             querys=Buscar("SELECT `IdCiclos`, `Descripcion`, `EnlaceWEB` FROM `catastro`.`ciclos` WHERE  `IdCiclos`=1;");
             return querys;
        } catch (SQLException ex) {
            Logger.getLogger(MySQL_Query.class.getName()).log(Level.SEVERE, null, ex);
        }
        return querys;

    }
    
   
        
      
}
