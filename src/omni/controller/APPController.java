/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omni.controller;

import java.awt.Desktop;
import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 * @author grender
 */
public class APPController {

    public static void openApp(String url) {
        Runtime app = Runtime.getRuntime();
        try {
            if (OSController.isUnix() || OSController.isMac()) {
                if (url.contains(".jar")) {
                    app.exec("java -jar " + url);
                } else if (url.contains(".sh")) {
                    app.exec("chmod +x " + url);
                    app.exec(url);
                } else if (url.contains(".")){
                    Desktop.getDesktop().open(new File(url));
                }else{
                    app.exec(url);
                }
            } else {
                if (url.contains(".exe")) {
                    app.exec(url);
                } else if (url.contains(".jar")) {
                    app.exec("java -jar " + url);
                } else if (url.contains(".bat")) {
                    app.exec("cmd /c start " + url);
                } else if (url.contains(".")){
                    Desktop.getDesktop().open(new File(url));
                }else{
                    app.exec(url);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se ha podido abrir la aplicacion, asegúrate de que es un archivo ejecutable.",
                    "Error al intentar abrir", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}
