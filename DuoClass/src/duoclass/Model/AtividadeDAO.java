
package duoclass.Model;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AtividadeDAO {
    

    
    public static void cadastrarAtividade(String titulo, String descricao, int cdTurma) throws SQLException{
        
        String sql = "INSERT INTO atividade (nome_atividade, ds_atividade, cd_turma) VALUES (?,?,?)";
        
        try(Connection conn = Conexao_banco.conectar();
            PreparedStatement ps = conn.prepareStatement(sql)){
            
            ps.setString(1, titulo);
            ps.setString(2, descricao);
            ps.setInt(3, cdTurma);
            
            ps.executeUpdate();
        }
    }
}
