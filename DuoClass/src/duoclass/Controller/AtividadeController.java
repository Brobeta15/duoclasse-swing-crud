
package duoclass.Controller;

import duoclass.Model.AtividadeDAO;
import duoclass.Model.TurmaDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AtividadeController {
    
    
    public static void cadastrarAtividade(String titulo, String descricao, String turma){
        
        try {
            int cd = TurmaDAO.retornarCdTurma(turma);
            AtividadeDAO.cadastrarAtividade(titulo, descricao, cd);
            
        } catch (SQLException ex) {
            Logger.getLogger(AtividadeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
