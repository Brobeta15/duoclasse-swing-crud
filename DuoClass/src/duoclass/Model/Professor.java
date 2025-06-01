
package duoclass.Model;

public class Professor {
    
    private int cd_professor;
    private String nm_professor;
    private String email_professor;
    private String senha_professor;
    
    public static boolean validarCadastro(Professor professor){
        
        boolean[] status = new boolean[3];
       
        boolean statusNome = validarNome(professor.getNm_professor());
        status[0] = statusNome;
        boolean statusEmail = validarEmail(professor.getEmail_professor());
        status[1] = statusEmail;
        boolean statusSenha = validarSenha(professor.getSenha_professor());
        status[2] = statusSenha;
        
        for (int i = 0; i < 3; i++) {
            
            if(status[i] == false){
                return false;
            }
        }
        return true;
    }
    
    private static boolean validarNome(String nome){
        
        if (nome == null || nome.isEmpty()) {
            return false;
            
        }else if(nome.matches("^[a-zA-ZáéíóúàèìòùãõâêîôûçÇ]+$")){
            return true;
            
        }
        return false;
    }
    
    private static boolean validarEmail(String email){
        if (email == null || email.isEmpty()) {
            return false;
            
        }else if(email.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")){
            return true;
        }
        return false;
        
    }
    private static boolean validarSenha(String senha){
        
        if (senha == null || senha.isEmpty()) {
            return false;
        }
        return true;
    }
    
    public Professor() {
  
    }

    public Professor(String email_professor, String senha_professor) {
        this.email_professor = email_professor;
        this.senha_professor = senha_professor;
    }
    
    public Professor(String nm_professor, String email_professor, String senha_professor) {
        this.nm_professor = nm_professor;
        this.email_professor = email_professor;
        this.senha_professor = senha_professor;
    }

    public int getCd_professor() {
        return cd_professor;
    }

    public String getNm_professor() {
        return nm_professor;
    }

    public String getEmail_professor() {
        return email_professor;
    }

    public String getSenha_professor() {
        return senha_professor;
    }

    public void setCd_professor(int cd_professor) {
        this.cd_professor = cd_professor;
    }

    public void setNm_professor(String nm_professor) {
        this.nm_professor = nm_professor;
    }

    public void setEmail_professor(String email_professor) {
        this.email_professor = email_professor;
    }

    public void setSenha_professor(String senha_professor) {
        this.senha_professor = senha_professor;
    }
    
    
}
