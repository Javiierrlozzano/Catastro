/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CLASES;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


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

    public ResultSet Familia3(){
      ResultSet resultado ;
        try {
            resultado  =Buscar("SELECT * FROM `catastro`.`ciclos`  LIMIT 1000;");
             TextCarga.setText("Iniciando Ciclos ....");
            return resultado;
        }catch(Exception ex){
        JOptionPane.showMessageDialog(null,"Error" + ex.getMessage());
        }
        return resultado = null;
    } 
    //Familia2
      public ResultSet Familia2(){
      ResultSet resultado ;
        try {
            resultado  =Buscar("SELECT * FROM `catastro`.`rutas` LIMIT 1000;");
             TextCarga.setText("Iniciando Rutas ....");
            return resultado;
            
        }catch(Exception ex){
        JOptionPane.showMessageDialog(null,"Error" + ex.getMessage());
        }
        return resultado = null;
    } 
    //Iniciar datos
    public ResultSet InicioFamilia3(){
        ResultSet resultado ;
        try {
            resultado  =Buscar("SELECT * FROM `catastro`.`ciclos`  LIMIT 1000;");
                         TextCarga.setText("Iniciando Unidad de Familia 3 ....");
            return resultado;
        }catch(Exception ex){
        JOptionPane.showMessageDialog(null,"Error" + ex.getMessage());
        }
        return resultado = null;
    }
    //Insertar datos
    public void InsertarFamilia3(String Descripcion,String EnlaceWeb,String Estado){
   
        try {
            Ingresar("INSERT INTO `catastro`.`ciclos` (`Descripcion`, `EnlaceWEB`, `Estado`)"
                    + " VALUES ('"+Descripcion+"', '"+EnlaceWeb+"', '"+Estado+"');");
            }catch(Exception ex){
                System.out.println( ex.getMessage());
        JOptionPane.showMessageDialog(null,"Error" + ex.getMessage());
        }
   }
    //Actualizar Datos
    public void UpdateFamilia3(String id,String Descripcion, String EnlaceWeb,String Estado){
   
        try {
            
            Ingresar("UPDATE `catastro`.`ciclos` SET `Descripcion`='"+Descripcion+"', `EnlaceWEB`='"+EnlaceWeb+"', `Estado`='"+Estado+"' WHERE  `IdCiclos`="+id+";");
            }catch(Exception ex){
        System.out.println( ex.getMessage());
        JOptionPane.showMessageDialog(null,"Error" + ex.getMessage());
        }
   }
    //Familia2
    //Iniciar datos
    public  ResultSet InicioFamilia2(){
       ResultSet resultado ;
        try {
            resultado  =Buscar("SELECT ruta.idRutas, ruta.Descripcion, ruta.Estado,ciclo.Descripcion,ruta.EnlaceWeb  \n" +
"                             FROM `catastro`.`rutas` AS ruta \n" +
"                             INNER  JOIN  `catastro`.`ciclos` as ciclo  \n" +
"                             ON ruta.Ciclos_IdCiclos = ciclo.IdCiclos\n" +
"                             where ciclo.Estado ='Activo'");
             TextCarga.setText("Iniciando Unidad de Familia 2 ....");
            return resultado;
        }catch(Exception ex){
        JOptionPane.showMessageDialog(null,"Error" + ex.getMessage());
        }
        return resultado = null;
        
    }
    //Update Familia2
    public void UpdateFamilia2(String id,String Estado,String Descripcion,String Ciclo,String EnlaceWeb){
  String Cs=null;
    try {
                ResultSet Ciclos= Buscar("SELECT IdCiclos FROM `catastro`.`ciclos` WHERE  Descripcion = '"+Ciclo+"' LIMIT 1");
                while(Ciclos.next()){
                Cs =Ciclos.getString(1);
                }
            Ingresar("UPDATE `catastro`.`rutas` SET `Descripcion`='"+Descripcion+"', `Estado`='"+Estado+"', `EnlaceWeb`='"+EnlaceWeb+"' ,`Ciclos_IdCiclos`= '"+Cs+"' WHERE  `idRutas`='"+id+"';");
            }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Error" + ex.getMessage());
        }
    }
    public void UptatesRutasLongLant(String Long ,String Latitud ,String Id){
        
    try{
    Ingresar("UPDATE `catastro`.`rutaslong` SET `Longitud`='"+Long+"', `Latitud`='"+Latitud+"' WHERE  `idRutasLong`="+Id+";");
    }catch(Exception ex){ 
    JOptionPane.showMessageDialog(null, "Error Actualizar Long "+ex.getMessage());
    }
    
    }
        public ResultSet InicioRutaLong (String idRuta){
        ResultSet Resultado= null;
            try{
        Resultado=Buscar("SELECT * FROM `catastro`.`rutaslong` where `Rutas_idRutas` ="+idRuta+"");
        }catch(Exception ex ){
        JOptionPane.showMessageDialog(null,"Error Inicio Long y Latitud " +ex.getMessage());
        }
       return Resultado; 
        }
       public void InsertarLatitudLongitudRutas(String Longitud,String Latitud,String IdRuta){
   
        try {
            Ingresar("INSERT INTO `catastro`.`rutaslong` (`Longitud`, `Latitud`, `Rutas_idRutas`) VALUES ('"+Longitud+"', '"+Latitud+"', '"+IdRuta+"');");
            }catch(Exception ex){
            System.out.println( ex.getMessage());
            JOptionPane.showMessageDialog(null,"Error Long Latitud" + ex.getMessage());
        }
   }
    //Familia 2 Buscar 
    public ResultSet BuscarFamilia2 (String Familia1){
   ResultSet  resultado= null;
        try{
                resultado =     Buscar ("SELECT fm2.Descripcion \n" +
"from `almacen.pos`.`familia2` AS fm2\n" +
"INNER JOIN `almacen.pos`.`familia1` AS fm1  \n" +
"ON fm2.Familia1_Familia2 = fm1.idFamilia1\n" +
"INNER JOIN  `almacen.pos`.`estados` AS es ON fm2.Estado = es.idEstado\n" +
"WHERE  fm1.Descripcion = '"+Familia1+"' AND es.NombreEstado='Activo'"); 
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Error" + ex.getMessage());
        }
return resultado;
    
    }
    //buscar Familia 3
        public ResultSet BuscarFamilia3 (String Familia1){
   ResultSet  resultado= null;
        try{
                resultado =     Buscar ("SELECT fm3.Descripcion \n" +
"from `almacen.pos`.`familia3` AS fm3\n" +
"INNER JOIN `almacen.pos`.`familia2` AS fm1  \n" +
"ON fm3.Familia2_idFamilia2 = fm1.idFamilia2\n" +
"INNER JOIN  `almacen.pos`.`estados` AS es ON fm3.Estado = es.idEstado\n" +
"WHERE  fm1.Descripcion = '"+Familia1+"' AND es.NombreEstado='Activo'"); 
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Error" + ex.getMessage());
        }
return resultado;
    
    }
    //Insertar familia2
    public void InsertFamilia2(String Descripcion,String Estado,String Ciclo,String EnlaceWeb){
   String Cs=null;
    try {
                ResultSet Ciclos= Buscar("SELECT IdCiclos FROM `catastro`.`ciclos` WHERE  Descripcion = '"+Ciclo+"' LIMIT 1");
                while(Ciclos.next()){
                Cs =Ciclos.getString(1);
                }
                Ingresar("INSERT INTO `catastro`.`rutas` (`Descripcion`, `Estado`, `EnlaceWeb`, `Ciclos_IdCiclos`) "
                        + "VALUES ('"+Descripcion+"', '"+Estado+"', '"+EnlaceWeb+"', '"+Cs+"');"
                        );
        }catch(Exception ex){
            System.out.println( ex.getMessage());
    JOptionPane.showMessageDialog(null,"Error" + ex.getMessage());
    }
    }
    public void InsetEmpresa(String Nombre,String Nit,String inticado,String Regimen,String Reprecentante ,String Telefono, String Email, String Direccion ,byte[] Foto ){
    String sql="INSERT INTO `almacen.pos`.`empresa` "
            + "(`NombreEmpresa`, `NIT_CC`, `Indicador`, `Regimen`, `NombreReprecentateLegal`, `Telefono`, `Email`, `Direccion`, `Logo`) VALUES "
            + "('"+Nombre+"', '"+Nit+"', '"+inticado+"', '"+Regimen+"', '"+Reprecentante+"', '"+Telefono+"', '"+Email+"', '"+Direccion+"', ?);";
     PreparedStatement ps = null;
    try{
        ps = con.prepareStatement(sql);
        ps.setBytes(1, Foto);
     ps.execute();
    }catch(Exception ex){
    
        System.out.println("    Eroor"+ ex);}
    //Configuraciones;
    }
    public ResultSet InicioEmpresa(){
        ResultSet resultado ;
        String sql = "SELECT  `NombreEmpresa`, `NIT_CC`, `Indicador`, `NombreReprecentateLegal`, `Telefono`, `Email`, `Direccion`, `Logo` , `Regimen` FROM `almacen.pos`.`empresa`";
        try{
            resultado = Buscar(sql);
             TextCarga.setText("Iniciando Empresa....");
             return resultado;
        }catch(Exception ex){
        
        }
         return resultado = null;
    }
    //USUARIO BASIC
    
    //InicarDataInser 
    public ResultSet InicioUsuario(){
          ResultSet resultado ;
      /*  try {
            resultado  =Buscar("SELECT IdUsuario\n" +
                                "FROM usuariobasico\n" +
                                "ORDER by IdUsuario DESC\n" +
                                "LIMIT 1");
              TextCarga.setText("Iniciando Usuario....");
            return resultado;
        }catch(Exception ex){
        JOptionPane.showMessageDialog(null,"Error" + ex.getMessage());
        }*/
        return resultado = null;
        
    }
    
    public void InsertarUsuarioBC(){
     /*         
        try {
                   String sql="";
 PreparedStatement ps = null;
    try{
        ps = con.prepareStatement(sql);
     //   ps.setBytes(1, Foto);
        ps.execute();
        }catch(Exception ex){
            System.out.println("Eroor "+ ex);}}
            catch(Exception ex){
            System.out.println( ex.getMessage());
        JOptionPane.showMessageDialog(null,"Error" + ex.getMessage());
     }*/
   }
    //Insertar Usuario-Proveedor
    public void InsertarProveedor(String RazonSocial,String Direcion,String Telefono,String EmailFactura,boolean ResponsableIVA,boolean AutoRetenedor,String Id){
   
    /*    try {
            Ingresar("INSERT INTO `almacen.pos`.`proveedor` (`RazonSocial`, `Direccion`, `Telefono`, `CorreoFactura`, `ResponsableIva`, `AutoRenedor`, `UsuarioBasico_IdUsuario`) VALUES "
                    + "('"+RazonSocial+"', '"+ Direcion+"', '"+Telefono+"', '"+EmailFactura+"', '"+ResponsableIVA+"', '"+AutoRetenedor+"', '"+Id+"');");
            }catch(Exception ex){
                System.out.println( ex.getMessage());
        JOptionPane.showMessageDialog(null,"Error" + ex.getMessage());
        }*/
   } 
    //Buscar usuario por Documento
    public ResultSet UsuarioDocBC(String idBusqueda,String Id ) throws SQLException{
  ResultSet  resultado = null;
        /*  resultado  =Buscar("SELECT  BC.IdUsuario, \n" +
        "BC.NDocumento, BC.TipoDoc,BC.NombreUsuari,\n" +
        "BC.Email,BC.NCuentaBancaria,\n" +
        "BC.NombreCuenta, ES.NombreEstado\n" +
        ",BC.Proveedor,BC.Empleado,BC.Cliente,BC.Banco,BC.Corriente,BC.Ahorro,\n" +
        "PRO.RazonSocial,PRO.Direccion,\n" +
        "PRO.Telefono,PRO.CorreoFactura,\n" +
        "PRO.ResponsableIva,PRO.AutoRenedor , BC.Foto\n" +
        "FROM `almacen.pos`.`usuariobasico` AS BC \n" +
        "LEFT JOIN `almacen.pos`.`estados` AS ES ON ES.IdEstado = BC.Estado \n" +
        "LEFT JOIN `almacen.pos`.`proveedor` AS PRO ON PRO.UsuarioBasico_IdUsuario=BC.IdUsuario \n" +
        "WHERE  `"+Id+"`='"+idBusqueda+"';");*/
    return resultado;
    } 
    
    
    //Buscar Usuario
     public ResultSet BuscarUsuario(String idBusqueda,String Where ) throws SQLException{
    ResultSet  resultado =null;
          /*  
          resultado  =Buscar("SELECT  BC.IdUsuario, \n" +
        "BC.NDocumento,BC.NombreUsuari,\n" +
        "BC.Email,BC.NCuentaBancaria,\n" +
        "BC.NombreCuenta, ES.NombreEstado\n" +
        ",if(BC.Proveedor = 'true','Proveedor',null) AS `Proveedor` ,\n" +
"if(BC.Empleado = 'true','Empleado',null) AS `Empleado`, if(BC.Cliente  = 'true','Cliente',null) AS `Cliente`" +
        "FROM `almacen.pos`.`usuariobasico` AS BC \n" +
        "LEFT JOIN `almacen.pos`.`estados` AS ES ON ES.IdEstado = BC.Estado \n" +
        "WHERE  "+idBusqueda+" REGEXP  '^"+Where+"' ;");*/
    return resultado;
    } 
     //Modicicar Usuario
        public void ModificarUsuarioBD(String TipoDOC,String NDocumento,
                String NombreUsuario,String Email,String NumeroCuenta,
                String NomCuenta,String Estado,Boolean Pro,Boolean Cli,Boolean Em,String id,
                Boolean CheakBanco, Boolean ChecKCorriente,Boolean ChecKAhorro,byte[] Foto){
      String idEstados = null ; 
       /* try {
            ResultSet  resultado  =Buscar("SELECT idEstado   FROM estados  WHERE  NombreEstado = '"+Estado+"' LIMIT 1");
                while (resultado.next()){
                   idEstados =  resultado.getString(1);}
                String SQL=
                   "UPDATE `almacen.pos`.`usuariobasico` SET `TipoDoc`='"+TipoDOC+"', "
                           + "`NDocumento`='"+NDocumento+"', `NombreUsuari`='"+NombreUsuario+"', "
                           + "`Email`='"+Email+"', `NCuentaBancaria`='"+NumeroCuenta+"', "
                           + "`NombreCuenta`='"+NomCuenta+"', `Estado`='"+idEstados+"', "
                           + "`Proveedor`='"+Pro+"', `Cliente`='"+Cli+"', `Empleado`='"+Em+"' ,`Banco`='"+CheakBanco+"', `Corriente`='"+ChecKCorriente+"', `Ahorro`='"+ChecKAhorro+"',`Foto` = ? "
                           + " WHERE  `IdUsuario`="+id+";";
                PreparedStatement ps = null;
                 
                ps = con.prepareStatement(SQL);
                ps.setBytes(1, Foto);
  

                ps.execute();
                
            }catch(Exception ex){
                System.out.println( ex.getMessage());
        JOptionPane.showMessageDialog(null,"Error" + ex.getMessage());
        }*/
   }
    //Modicar Proveedor
    public void ModicarProveedor(String RazonSocial,String Direcion,String Telefono,String EmailFactura,boolean ResponsableIVA,boolean AutoRetenedor,String Id){
      /*  try {
            ResultSet  resultado  =Buscar("SELECT `UsuarioBasico_IdUsuario` from `almacen.pos`.`proveedor`   WHERE `UsuarioBasico_IdUsuario`='"+Id+"' LIMIT 1");
           if(resultado.next()){
           Ingresar("UPDATE `almacen.pos`.`proveedor` SET `RazonSocial`='"+RazonSocial+"', `Direccion`='"+ Direcion+"', `Telefono`='"+Telefono+"',"
                   + " `CorreoFactura`='"+EmailFactura+"', `ResponsableIva`='"+ResponsableIVA+"', `AutoRenedor`='"+AutoRetenedor+"' WHERE  `UsuarioBasico_IdUsuario`='"+Id+"';");
           }else{
            Ingresar("INSERT INTO `almacen.pos`.`proveedor` (`RazonSocial`, `Direccion`, `Telefono`, `CorreoFactura`, `ResponsableIva`, `AutoRenedor`, `UsuarioBasico_IdUsuario`) VALUES "
                    + "('"+RazonSocial+"', '"+ Direcion+"', '"+Telefono+"', '"+EmailFactura+"', '"+ResponsableIVA+"', '"+AutoRetenedor+"', '"+Id+"');");
           }
           
            }catch(Exception ex){
                System.out.println( ex.getMessage());
        JOptionPane.showMessageDialog(null,"Error" + ex.getMessage());
        }*/
   }   
        
      
}
