
package duoclass.Controller;

import duoclass.Model.ProfessorDAO;
import duoclass.Model.Turma;
import duoclass.Model.TurmaDAO;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TurmaController {
    
    public static boolean verificarTurmaComAtividadeController(String nomeTurma){
     
        try {
            int cdTurma = TurmaDAO.retornarCdTurma(nomeTurma);
            return TurmaDAO.verificaRTurmaComAtividade(cdTurma);
            
        } catch (SQLException ex) {
            Logger.getLogger(TurmaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public static List<String> selecionarTurmaController(){
        
        try {
            return TurmaDAO.selecionarTurma();
            
        } catch (SQLException ex) {
            Logger.getLogger(TurmaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static void excluirTurmaController(String nomeTurma, String email, String senha){
        
        try {
            int cd = ProfessorDAO.encontrarCdProfessor(senha, email);
            TurmaDAO.excluirTurma(nomeTurma, cd);
        } catch (SQLException ex) {
            Logger.getLogger(TurmaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static boolean verificarTurmaExistente(String nomeTurma, String email, String senha){
        
        try {
            int cdProfessor = ProfessorDAO.encontrarCdProfessor(senha, email);
            return TurmaDAO.verificarTurmaCadastrada(nomeTurma, cdProfessor);
            
        } catch (SQLException ex) {
            Logger.getLogger(TurmaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public static void inserirTurma(String nome, String email, String senha){
        
        try {

            TurmaDAO.adicionarTurma(nome, email, senha);
        } catch (SQLException ex) {
            Logger.getLogger(TurmaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   

}
