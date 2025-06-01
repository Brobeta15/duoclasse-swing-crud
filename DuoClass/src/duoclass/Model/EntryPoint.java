
package duoclass.Model;

import duoclass.View.TelaLogin;

public class EntryPoint {
    public static void main(String[] args) {
        
        javax.swing.SwingUtilities.invokeLater(() -> {
            TelaLogin telaInicial = new TelaLogin();
            telaInicial.setVisible(true);
        });
    }
}
