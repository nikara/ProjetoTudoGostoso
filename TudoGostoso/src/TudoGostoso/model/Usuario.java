package TudoGostoso.model;

public class Usuario {

//#region Atributos do usuario;
    private int idUsuario;
    private String nome;
    private String Email;
    private String Data_nascimento;
    private int Cep;
    private String Genero;
    private String Senha;
    private String Salt;
    private String Inscrito;
    private String Uuid;
// endregion 

//#region Construtor
    public Usuario(int idUsuario, String nome,String email, String data_nascimento, int cep, String genero,String senha, String salt, String inscrito,String uuid){
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.Email = email;
        this.Data_nascimento = data_nascimento;
        this.Cep = cep;
        this.Genero = genero;
        this.Senha = senha;
        this.Salt = salt;
        this.Inscrito = inscrito;
        this.Uuid = uuid;

    }

// endregion

//#region Set e Gets
    public void setIdUsuario(int idUsuario){
        this.idUsuario = idUsuario;
    }

    public int getIdUsuario(){
        return idUsuario;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return nome;
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

// endregion

//#region Metedos de Usuario

// Construtor que inicia um usuario pre-existente

// Autenticar Usuario

public void autenticarUsuario (String nomeString, String emailString,String senhaString ){

System.err.println("----------------Autenticando Usuario----------------");
System.out.println("Nome  do Usuario:" + nomeString);
System.out.println("Email do Usuario:" + emailString);
System.out.println("Senha do Usuario:" + senhaString);

if(nomeString == getNome() && emailString == getEmail() && senhaString == getSenha() ){
    System.out.println("Usuario reconhecido");
}};

// Cria receita do usuario

// public Receita CrairReceita(Categoria categoria,Custo custo, Preparo preparo, Utensilio utensilio){

//    return Receita();
//}

//#endregion

//#region Metodos alterados
    @Override
    public String toString(){
        return "Usuário { IdUsuário: " + idUsuario + 
                        ", Nome: " + nome +
                        ", Email: " + Email + 
                        ", Data de nascimento: " + Data_nascimento +
                        ", CEP: " + Cep +
                        ", Gênero: " + Genero +
                        ", Senha: " + Senha +
                        ", Salt: " + Salt +
                        ", Inscrito" + Inscrito +
                        ", UUID: " + Uuid ;
    }
//#endregion
}
