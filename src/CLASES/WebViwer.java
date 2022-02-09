/*

 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CLASES;



import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author JAVIER
 */
public class WebViwer {
    //se crea el JFrame y se 
    public   void CrearWeb(String PaginaWeb){
        JFrame frame  = new JFrame ("FX y swinf");
        final JFXPanel fx =new JFXPanel();
        fx.setPreferredSize( frame.getMinimumSize());
     
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.add(fx);
       
       GENERAL_CLASS  general = new GENERAL_CLASS();
       general.OpenWindows(frame, null);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
    Platform.runLater(new Runnable(){
    @Override
            public void run(){
                InitFX(fx,PaginaWeb);
            }
        });
    }
    private static void InitFX(JFXPanel fx,String WebPagina){
        Scene sc = createScene(WebPagina);
        fx.setScene(sc);
    }
    //Se crea la web en el tipo 
    private static Scene createScene(String WebPagina){
        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();
        webEngine.load(WebPagina);
        Group root = new  Group();
        root.getChildren().add(webView);
        root.scaleXProperty().add(55);
        Scene scene= new Scene (root);
     
      
        return(scene);
    }
 
}
