package TudoGostoso;

public class Usuario {

    private int IdUsuario;
    private String Nome;
    private String Email;
    private String Data_nascimento;
    private int Cep;
    private String Genero;
    private String Senha;
    private String Salt;
    private String Inscrito;
    private String Uuid;

    public Usuario(int IdUsuario, String nome,String email, String data_nascimento, int cep, String genero,String senha, String salt, String inscrito,String uuid){
        this.IdUsuario = IdUsuario;
        this.Nome = nome;
        this.Email = email;
        this.Data_nascimento = data_nascimento;
        this.Cep = cep;
        this.Genero = genero;
        this.Senha = senha;
        this.Salt = salt;
        this.Inscrito = inscrito;
        this.Uuid = uuid;

    }

    public void setIdUsuario(int IdUsuario){
        this.IdUsuario = IdUsuario;
    }

    public int getIdUsuario(){
        return IdUsuario;
    }

    public void setNome(String nome){
        this.Nome = nome;
    }

    public String getNome(){
        return Nome;
    }

    public void setEmail(String email){
        this.Email = email;
    }

    public String getEmail(){
        return Email;
    }

    public void setData_nascimento(String data_nascimento){
        this.Data_nascimento = data_nascimento;
    }

    public String getData_nascimento(){
        return Data_nascimento;
    }

    public void setCep(int cep){
        this.Cep = cep;
    }

    public int getCep(){
        return Cep;
    }

    public void setGenero(String genero){
        this.Genero = genero;
    }

    public String getGenero(){
        return Genero;
    }

    public void setSenha(String senha){
        this.Senha = senha;
    }

    public String getSenha(){
        return Senha;
    }

    public void setSalt(String salt){
        this.Salt = salt;
    }

    public String getSalt(){
        return Salt;
    }

    public void setInscrito(String inscrito){
        this.Inscrito = inscrito;
    }

    public String getInscrito(){
        return Inscrito;
    }

    public void setUuid(String uuid){
        this.Uuid = uuid;
    }

    public String getUuid(){
        return Uuid;
    }

    @Override
    public String toString(){
        return "Usuário { IdUsuário: " + IdUsuario + 
                        ", Nome: " + Nome +
                        ", Email: " + Email + 
                        ", Data de nascimento: " + Data_nascimento +
                        ", CEP: " + Cep +
                        ", Gênero: " + Genero +
                        ", Senha: " + Senha +
                        ", Salt: " + Salt +
                        ", Inscrito" + Inscrito +
                        ", UUID: " + Uuid ;
    }

    
}
