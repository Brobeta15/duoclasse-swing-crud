 
package duoclass.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.SwingConstants;

public class Conexao_banco {
    
    private static final String URL = "jdbc:mysql://localhost:3306/banco_duoclass";
    private static final String USUARIO = "root";
    private static final String SENHA = "JC629@!c";
    
    public static Connection conectar() throws SQLException {

       return DriverManager.getConnection(URL, USUARIO, SENHA);
    }
    
    public static void main(String[] args) {
        try{
            Connection conn = Conexao_banco.conectar();
            System.out.println("Conexão estabelcida com sucesso!");
            conn.close();
        }catch (SQLException e){
            System.out.println("Erro ao conectar: "+e.getMessage());
        }
    }
}

