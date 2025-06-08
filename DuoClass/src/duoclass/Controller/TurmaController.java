
package duoclass.Controller;

import duoclass.Model.ProfessorDAO;
import duoclass.Model.Turma;
import duoclass.Model.TurmaDAO;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TurmaController {

    
    public static Integer verificarCdTurma(String turma){
        
        try {
            return TurmaDAO.retornarCdTurma(turma);
        } catch (SQLException ex) {
            Logger.getLogger(TurmaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static boolean verificarTurmaComAtividadeController(String nomeTurma){
     
        try {
            int cdTurma = TurmaDAO.retornarCdTurma(nomeTurma);
            return TurmaDAO.verificaRTurmaComAtividade(cdTurma);
            
        } catch (SQLException ex) {
            Logger.getLogger(TurmaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public static List<String> selecionarTurmaController(String email, String senha){
        
        try {
            int cd = ProfessorDAO.encontrarCdProfessor(senha, email);
            return TurmaDAO.selecionarTurma(cd);
            
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
    
    public static boolean verificarTurmaExistente(String nomeTurma){
        
        try {
            return TurmaDAO.verificarTurmaCadastrada(nomeTurma);
            
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
