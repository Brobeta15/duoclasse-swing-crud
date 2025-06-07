
package duoclass.Model;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TurmaDAO {
    
    public static void adicionarTurma(String nome, String email, String senha) throws SQLException{
        
        int cd = ProfessorDAO.encontrarCdProfessor(nome, senha, email);
        
        String sql = "INSERT INTO turma (nome_turma, cd_professor) VALUES (?, ?)";
        
        try (Connection conn = Conexao_banco.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, nome);
            ps.setInt(2, cd);
            
            ps.executeUpdate();
        }
    }
    
    public static boolean verificarTurmaCadastrada(String nome) throws SQLException{
        
        String sql = "SELECT turma FROM turma WHERE nome_turma = ?";
        
        try(Connection conn = Conexao_banco.conectar();
            PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, nome);
            
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                
                    rs.getString("nome_turma");
                    
                    return true;  
                }
            }
            return false;
        }
    }
}
