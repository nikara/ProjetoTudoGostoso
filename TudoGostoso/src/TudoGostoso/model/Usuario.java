package TudoGostoso.model;

public class Usuario {

    // #region Atributos do usuario;
    private int idUsuario;
    private String nome;
    private String email;
    private String dataNascimento;
    private int cep;
    private String genero;
    private String Senha;
    private String Salt;
    private String Inscrito;
    private String Uuid;
    // endregion

    // #region Construtor
    public Usuario(){};
    
    public Usuario(int idUsuario, String nome, String email, String dataNascimento, int cep, String genero,
            String senha, String salt, String inscrito, String uuid) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.cep = cep;
        this.genero = genero;
        this.Senha = senha;
        this.Salt = salt;
        this.Inscrito = inscrito;
        this.Uuid = uuid;

    }

    // endregion

    // #region Set e Gets
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setdataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getdataNascimento() {
        return dataNascimento;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public int getCep() {
        return cep;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getGenero() {
        return genero;
    }

    public void setSenha(String senha) {
        this.Senha = senha;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSalt(String salt) {
        this.Salt = salt;
    }

    public String getSalt() {
        return Salt;
    }

    public void setInscrito(String inscrito) {
        this.Inscrito = inscrito;
    }

    public String getInscrito() {
        return Inscrito;
    }

    public void setUuid(String uuid) {
        this.Uuid = uuid;
    }

    public String getUuid() {
        return Uuid;
    }

    // endregion

    // #region Metedos de Usuario

    // Exibir Menu
    // Sera usado nas classes filhas
    public void exibirMenu(){};

    // Autenticar Usuario

    public void autenticarUsuario(String nomeString, String emailString, String senhaString) {

        System.err.println("----------------Autenticando Usuario----------------");
        System.out.println("Nome  do Usuario:" + nomeString);
        System.out.println("Email do Usuario:" + emailString);
        System.out.println("Senha do Usuario:" + senhaString);

        if (nomeString.equals(getNome()) && emailString.equals(getEmail()) && senhaString.equals(getSenha())) {
            System.out.println("Usuario reconhecido");
        }else{
            System.out.println("Credencias inválidas.");
        }
    };

    // #endregion

    // #region Metodos alterados
    @Override
    public String toString() {
        return "Usuário { IdUsuário: " + idUsuario +
                ", Nome: " + nome +
                ", Email: " + email +
                ", Data de nascimento: " + dataNascimento +
                ", CEP: " + cep +
                ", Genero: " + genero +
                ", Senha: " + Senha +
                ", Salt: " + Salt +
                ", Inscrito: " + Inscrito +
                ", UUID: " + Uuid +
                ")";
    }
    // #endregion
}
