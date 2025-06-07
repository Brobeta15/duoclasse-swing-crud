
package duoclass.Controller;

import duoclass.Model.Professor;
import duoclass.Model.ProfessorDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProfessorController {

    public static String imprimirNomeProfessor(String email, String senha ){

        String nome ="";
        
        try {
            nome = ProfessorDAO.encontrarNomeProfessor(senha, email);
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nome;
    }
    
    
    public static boolean verificarUsuario(String senha, String email) throws SQLException{
        
        ProfessorDAO pdao = new ProfessorDAO();
        
        boolean resultadoVerificacao = pdao.verificarUsuario(senha, email);

        return resultadoVerificacao;
    }
    
}
