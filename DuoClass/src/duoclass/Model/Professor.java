
package duoclass.Model;

public class Professor {
    
    private int cd_professor;
    private String nm_professor;
    private String email_professor;
    private String senha_professor;

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
