
package duoclass.Model;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProfessorDAO {
    
    public boolean verificarUsuario(String senha, String email) throws SQLException {
        
        String sql = "SELECT senha_professor, email_professor FROM professor WHERE senha_professor = ? AND email_professor = ?";
        
        try(Connection conn = Conexao_banco.conectar();
            PreparedStatement ps = conn.prepareStatement(sql)
            ) {
            
            ps.setString(1,senha);//aqui o que quero achar no banxo
            ps.setString(2,email);
            
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                
                    //não preciso colocar nada pq se o if for executado é pq é vdd
                    return true;
                }
            
                return false;
            }
        }
    }
}
