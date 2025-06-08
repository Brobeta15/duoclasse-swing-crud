
package duoclass.Controller;

import duoclass.Model.Atividade;
import duoclass.Model.AtividadeDAO;
import duoclass.Model.Conexao_banco;
import duoclass.Model.TurmaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AtividadeController {
    
    public static List<Atividade> selecionarTurmaController(int cdTurma){
        
        try {
            return AtividadeDAO.selecionarTurma(cdTurma);
            
        } catch (SQLException ex) {
            Logger.getLogger(AtividadeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static void cadastrarAtividade(String titulo, String descricao, String turma){
        
        try {
            int cd = TurmaDAO.retornarCdTurma(turma);
            AtividadeDAO.cadastrarAtividade(titulo, descricao, cd);
            
        } catch (SQLException ex) {
            Logger.getLogger(AtividadeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
