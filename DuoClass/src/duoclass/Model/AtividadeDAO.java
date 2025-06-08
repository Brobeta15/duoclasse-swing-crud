
package duoclass.Model;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AtividadeDAO {
    
    public static List<Atividade> selecionarTurma(int cdTurma) throws SQLException{
        
        List<Atividade> listaAtividades = new ArrayList<Atividade>();
        
        String sql = "SELECT nome_atividade, ds_atividade FROM Atividade WHERE cd_turma = ?";
        
        try(Connection conn = Conexao_banco.conectar();
            PreparedStatement ps = conn.prepareStatement(sql)){
            
            ps.setInt(1, cdTurma);
            
            try(ResultSet rs = ps.executeQuery()){
                while(rs.next()){

                    Atividade atividade = new Atividade();
                
                    atividade.setNome_atividade(rs.getString("nome_atividade"));
                    atividade.setDs_atividade(rs.getString("ds_atividade"));
                
                    listaAtividades.add(atividade); 
                }
            }
        }
        return listaAtividades;
    }
    
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
