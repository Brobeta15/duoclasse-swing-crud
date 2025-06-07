
package duoclass.Model;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProfessorDAO {
    
    public static int encontrarCdProfessor(String nome, String senha, String email) throws SQLException{
        
        String sql = "SELECT cd_professor FROM professor WHERE senha_professor = ? AND email_professor = ?";
        
        try(Connection conn = Conexao_banco.conectar();
            PreparedStatement ps = conn.prepareStatement(sql)
            ) {
            
            ps.setString(1,senha);
            ps.setString(2,email);
            
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                
                    int cd = rs.getInt("cd_professor");
                    
                    return cd;  
                }
            }
            System.out.println("deu errado");
            return 0;
        }
    }
    public static String encontrarNomeProfessor(String senha, String email)throws SQLException{
        
        String sql = "SELECT nm_professor FROM professor WHERE senha_professor = ? AND email_professor = ?";
        
        try(Connection conn = Conexao_banco.conectar();
            PreparedStatement ps = conn.prepareStatement(sql)
            ) {
            
            ps.setString(1,senha);//aqui o que quero achar no banco
            ps.setString(2,email);
            
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                
                    String nome = rs.getString("nm_professor");
                    
                    return nome;
                }
            }
        }

        return null;
    }
    
    
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
