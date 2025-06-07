
package duoclass.Controller;

import duoclass.Model.TurmaDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TurmaController {
    
    public static void inserirTurma(String nome, String email, String senha){
        
        try {
            TurmaDAO.adicionarTurma(nome, email, senha);
        } catch (SQLException ex) {
            Logger.getLogger(TurmaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static boolean verificarTurma(String nome){
        
        try {
            return TurmaDAO.verificarTurmaCadastrada(nome);
        } catch (SQLException ex) {
            Logger.getLogger(TurmaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
