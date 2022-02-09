/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VISTA;

import CLASES.GENERAL_CLASS;
import CLASES.MySQL_Query;
import java.io.FileWriter;
import java.io.PrintWriter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author JAVIER
 */
public class RutasLong extends javax.swing.JFrame {

    /**
     * Creates new form Bodegas
     */
    public RutasLong(MySQL_Query BodegasInicio, boolean ini,String IdRutas)  {
        initComponents();
           QuerysUnidad = BodegasInicio;
        try{
          
           CodigoRuta.setText(IdRutas);
             IniciarData();
            ini= inic;
            activa(inic);
        }catch(Exception ex){
        JOptionPane.showMessageDialog(null,"Error Familia inicios "+ex.getMessage());
        }
    }

    private RutasLong() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    //Limpia 
    public void Limpiar(){
        JTextField text [] ={Latitud};
       // JComboBox com [] ={EstadoPro,SelectTc};
        idEstado.setText("");
        general.LimpiarTodo(text);
       // general.LimpiarTodo(com);
    }
    //Inicia los componentes 
    public void IniciarData() throws SQLException{
        int[] Colum = {1,2,3}; 
        String idRuta = CodigoRuta.getText();
        general.AgregarTable(jTable1, Colum, QuerysUnidad.InicioRutaLong(idRuta));
//        general.AgregarDatosCombobox(EstadoPro, QuerysUnidad.Familia3(),1);
    }
    //Activar componentes 
    public  void  activa( Boolean x){
    Latitud.setEnabled(x);
    Longitud.setEnabled(x);
    idEstado.setEnabled(x);
    btGuardar.setEnabled(x);
    btAdicionar.setVisible(!x);
  //  EstadoPro.setEnabled(x);
    btCancelar.setVisible(x);
    btActualizar.setVisible(x);
    btModificar.setVisible(!x);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        Latitud = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        btAdicionar = new javax.swing.JButton();
        btModificar = new javax.swing.JButton();
        btGuardar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        btActualizar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        CodigoRuta = new javax.swing.JLabel();
        idEstado1 = new javax.swing.JLabel();
        idEstado = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        Longitud = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CREAR BODEGAS");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 153));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jPanel1KeyReleased(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("LONGITUD");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        Latitud.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Latitud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LatitudActionPerformed(evt);
            }
        });
        Latitud.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                LatitudKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                LatitudKeyReleased(evt);
            }
        });
        jPanel1.add(Latitud, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, 200, 30));

        jLabel10.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(649, 57, -1, -1));

        btAdicionar.setBackground(new java.awt.Color(255, 255, 255));
        btAdicionar.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        btAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/Agregar.png"))); // NOI18N
        btAdicionar.setText("ADICIONAR");
        btAdicionar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btAdicionar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btAdicionar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAdicionarActionPerformed(evt);
            }
        });
        btAdicionar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btAdicionarKeyReleased(evt);
            }
        });
        jPanel1.add(btAdicionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 120, 60));

        btModificar.setBackground(new java.awt.Color(255, 255, 255));
        btModificar.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        btModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/Modificar.png"))); // NOI18N
        btModificar.setText("MODIFICAR");
        btModificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btModificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btModificar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btModificarActionPerformed(evt);
            }
        });
        btModificar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btModificarKeyReleased(evt);
            }
        });
        jPanel1.add(btModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 450, 120, 60));

        btGuardar.setBackground(new java.awt.Color(255, 255, 255));
        btGuardar.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        btGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/Guardar.png"))); // NOI18N
        btGuardar.setText("GUARDAR");
        btGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btGuardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGuardarActionPerformed(evt);
            }
        });
        btGuardar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btGuardarKeyReleased(evt);
            }
        });
        jPanel1.add(btGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 450, 140, 60));

        jTable1.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "CODIGO", "LONGITUD", "LATITUD"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable1.setGridColor(new java.awt.Color(0, 0, 0));
        jTable1.setRowHeight(24);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable1KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(30);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 420, 270));

        jLabel15.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("LATITUD");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, 70, -1));

        btActualizar.setBackground(new java.awt.Color(255, 255, 255));
        btActualizar.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        btActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/Actualizar.png"))); // NOI18N
        btActualizar.setText("ACTUALIZAR");
        btActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btActualizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btActualizar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btActualizarActionPerformed(evt);
            }
        });
        btActualizar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btActualizarKeyReleased(evt);
            }
        });
        jPanel1.add(btActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 450, 120, 60));

        btCancelar.setBackground(new java.awt.Color(255, 255, 255));
        btCancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/Cancelar.png"))); // NOI18N
        btCancelar.setText("CANCELAR");
        btCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btCancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });
        btCancelar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btCancelarKeyReleased(evt);
            }
        });
        jPanel1.add(btCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 117, 60));

        jPanel2.setBackground(new java.awt.Color(0, 0, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("GPS");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        CodigoRuta.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        CodigoRuta.setForeground(new java.awt.Color(255, 255, 255));
        CodigoRuta.setText("0000");
        jPanel2.add(CodigoRuta, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, -1, -1));

        idEstado1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        idEstado1.setForeground(new java.awt.Color(255, 255, 255));
        idEstado1.setText("Ruta:");
        jPanel2.add(idEstado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, -1, -1));

        idEstado.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        idEstado.setForeground(new java.awt.Color(255, 255, 255));
        idEstado.setText("0000");
        jPanel2.add(idEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 50));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, 60, 10));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 120, 10));

        Longitud.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Longitud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LongitudActionPerformed(evt);
            }
        });
        Longitud.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                LongitudKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                LongitudKeyReleased(evt);
            }
        });
        jPanel1.add(Longitud, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 190, 30));

        jButton1.setText("General KML");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 230, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 0, 440, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LatitudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LatitudActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LatitudActionPerformed

    private void btGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGuardarActionPerformed

        try {
            String idRuta = CodigoRuta.getText();
            String Long = Longitud.getText();
            String Lant = Latitud.getText();
            QuerysUnidad.InsertarLatitudLongitudRutas( Long, Lant,idRuta);
            Limpiar();
            IniciarData();
            activa(false);
        } catch (Exception ex) {
            Logger.getLogger(RutasLong.class.getName()).log(Level.SEVERE, null, ex);
            
        }
       
        btModificar.setEnabled(false);
    }//GEN-LAST:event_btGuardarActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
       int conf = general.ValdarCerrar();
        if (conf == 0) {
            Limpiar();
            activa(false); 
        }
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btActualizarActionPerformed
        try {
                String Latid =Latitud.getText();
                String id =idEstado.getText();
                String Longituds = Longitud.getText();
                 QuerysUnidad.UptatesRutasLongLant( Longituds,Latid, id);
                IniciarData();
                activa(false);
                Limpiar();
              } catch (Exception ex) {
              }   
    }//GEN-LAST:event_btActualizarActionPerformed

    private void btModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btModificarActionPerformed
    activa(true);        
    }//GEN-LAST:event_btModificarActionPerformed

    private void btAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdicionarActionPerformed
            try {
                activa(true);
                btActualizar.setVisible(false); 
              } catch (Exception ex) {
              }
        
          
    }//GEN-LAST:event_btAdicionarActionPerformed
            public void Keys(java.awt.event.KeyEvent evt){
                    general.CerrarWindowsKey(evt, this);
                    int  cerrar = evt.getKeyCode();
                    if (116 == cerrar ){
                        try {  
                            IniciarData();
                        } catch (SQLException ex) {
                            Logger.getLogger(RutasLong.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
            }
    private void LatitudKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_LatitudKeyReleased
        general.Mayus(Latitud); 
    Keys(evt);
    }//GEN-LAST:event_LatitudKeyReleased

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
    btModificar.setEnabled(true);
    String [] DatosTable =general.DatosJTable(jTable1);
    idEstado.setText(DatosTable[0]);
    Latitud.setText(DatosTable[1]);
    Longitud.setText(DatosTable[2]);
    //EstadoPro.setSelectedItem(DatosTable[2]); 
   // EstadoPro.setSelectedItem(DatosTable[3]);
    }//GEN-LAST:event_jTable1MouseClicked

    private void LatitudKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_LatitudKeyPressed
  
    }//GEN-LAST:event_LatitudKeyPressed

    private void jPanel1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel1KeyPressed
Keys(evt);      // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1KeyPressed

    private void jTable1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyReleased
Keys(evt);        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1KeyReleased

    private void btAdicionarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btAdicionarKeyReleased
Keys(evt);        // TODO add your handling code here:
    }//GEN-LAST:event_btAdicionarKeyReleased

    private void btModificarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btModificarKeyReleased
Keys(evt);        // TODO add your handling code here:
    }//GEN-LAST:event_btModificarKeyReleased

    private void btCancelarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btCancelarKeyReleased
Keys(evt);        // TODO add your handling code here:
    }//GEN-LAST:event_btCancelarKeyReleased

    private void btActualizarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btActualizarKeyReleased
Keys(evt);        // TODO add your handling code here:
    }//GEN-LAST:event_btActualizarKeyReleased

    private void btGuardarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btGuardarKeyReleased
Keys(evt);        // TODO add your handling code here:
    }//GEN-LAST:event_btGuardarKeyReleased

    private void jPanel1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel1KeyReleased
Keys(evt);        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1KeyReleased

    private void LongitudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LongitudActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LongitudActionPerformed

    private void LongitudKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_LongitudKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_LongitudKeyPressed

    private void LongitudKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_LongitudKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_LongitudKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int TableInt= jTable1.getRowCount();
        String lon[]= new String[TableInt];
        String lat [] = new String[TableInt];
        for (int i = 0; i < TableInt; i++) {
            lon [i]= jTable1.getValueAt( i,1).toString();
             lat [i]= jTable1.getValueAt( i,2).toString();
        }
        general.GeneralKMl("Ruta"+CodigoRuta.getText(), lat, lon,jPanel1);
     
// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed
    
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RutasLong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RutasLong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RutasLong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RutasLong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
    
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RutasLong().setVisible(true);
            }
        });
    }
    int  idRutas;
    private MySQL_Query QuerysUnidad;
    private boolean inic =false;
    private  GENERAL_CLASS general = new GENERAL_CLASS() ;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CodigoRuta;
    private javax.swing.JTextField Latitud;
    private javax.swing.JTextField Longitud;
    private javax.swing.JButton btActualizar;
    private javax.swing.JButton btAdicionar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btGuardar;
    private javax.swing.JButton btModificar;
    private javax.swing.JLabel idEstado;
    private javax.swing.JLabel idEstado1;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
