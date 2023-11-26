package Model;


public class Usuario {
    
    private int IdUsuario;
    private String NomeUsuario;
    private String EmailUsuario;
    private String LoginUsuario;
    private String SenhaUsuario;
    
    public Usuario(int IdUsuario, String NomeUsuario, String EmailUsuario,
            String LoginUsuario, String SenhaUsuario){
        
        this.IdUsuario = IdUsuario;
        this.NomeUsuario = NomeUsuario;
        this.EmailUsuario = EmailUsuario;
        this.LoginUsuario = LoginUsuario;
        this.SenhaUsuario = SenhaUsuario;
        
}   
    
    public Usuario(){}
    
    public int getIdUsuario(){
        return IdUsuario;
    }
    public void setIdUsuario(){
        this.IdUsuario = IdUsuario;
    }
    public String getNomeUsuario(){
        return NomeUsuario;
    }
    public void setNomeUsuario(){
        this.NomeUsuario = NomeUsuario;
    }
    public String getEmailUsuario(){
        return EmailUsuario;
    }
    public void SetEmailUsuario(){
        this.EmailUsuario = EmailUsuario;
    }
    public String getLoginUsuario(){
        return LoginUsuario;
    }
    public void setLoginUsuario(){
        this.LoginUsuario = LoginUsuario;
    }
    public String getSenhaUsuario(){
        return SenhaUsuario;
    }
    public void setSenhaUsuario(){
        this.SenhaUsuario = SenhaUsuario;
    }
}