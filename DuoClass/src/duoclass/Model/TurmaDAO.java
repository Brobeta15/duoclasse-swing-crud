
package duoclass.Model;

import java.util.List;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TurmaDAO {
    
    
    public static boolean verificaRTurmaComAtividade(int cdTurma) throws SQLException{
        
        String sql = "SELECT 1 FROM atividade WHERE cd_turma = ?";
        
        try(Connection conn = Conexao_banco.conectar();
            PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, cdTurma);
            
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()){

                    return true;  
                }
            }
            return false;
        }
    }
    
    public static Integer retornarCdTurma(String nomeTurma) throws SQLException{
        
        String sql = "SELECT cd_turma FROM turma WHERE nome_turma = ?";
        
        try(Connection conn = Conexao_banco.conectar();
            PreparedStatement ps = conn.prepareStatement(sql)){
            
            ps.setString(1, nomeTurma);
            
            try(ResultSet rs = ps.executeQuery()){//o excute query sempre tem q ficar dps de setar o valor que será adicionado no banco de dados
                                                  //senão dá erro
                if(rs.next()){
                
                    int cd = rs.getInt("cd_turma");   
                    return cd;  
                }
            return null;
            }
        }
    }
    
    public static List<String> selecionarTurma() throws SQLException{
        
        List<String> listaTurmas = new ArrayList<String>();
        
        String sql = "SELECT nome_turma FROM turma";
        
        try(Connection conn = Conexao_banco.conectar();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){
            
            while(rs.next()){

                listaTurmas.add(rs.getString("nome_turma")); 
            }           
        }
        return listaTurmas;
    }
    
    public static void excluirTurma(String nomeTurma, int cdProfessor) throws SQLException{
        
        String sql = "DELETE FROM turma WHERE nome_turma = ? AND cd_professor = ?";
        
        try(Connection conn = Conexao_banco.conectar();
            PreparedStatement ps = conn.prepareStatement(sql)){
            
            ps.setString(1,nomeTurma);
            ps.setInt(2, cdProfessor);
            
            ps.executeUpdate();
        }
    }
    
    public static void adicionarTurma(String nome, String email, String senha) throws SQLException{

        int cd = ProfessorDAO.encontrarCdProfessor(senha, email);
        
        String sql = "INSERT INTO turma (nome_turma, cd_professor) VALUES (?, ?)";
        
        try (Connection conn = Conexao_banco.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, nome);
            ps.setInt(2, cd);
            
            ps.executeUpdate();
        }
    }
    
    public static boolean verificarTurmaCadastrada(String nome, int cd_professor) throws SQLException{
        
        String sql = "SELECT 1 FROM turma WHERE nome_turma = ? AND cd_professor = ?";
        
        try(Connection conn = Conexao_banco.conectar();
            PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, nome);
            ps.setInt(2, cd_professor);
            
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()){

                    return true;  
                }
            }
            return false;
        }
    }
}
