package TudoGostoso.model;

public class Consumidor extends Usuario {

    // #region Construtor
    public Consumidor(int idUsuario, String nome, String email, String data_nascimento, int cep, String genero,
            String senha, String salt, String inscrito, String uuid) {
        super(idUsuario, nome, email, data_nascimento, cep, genero, senha, salt, inscrito, uuid);

    }
    // #endregion

    // #region Métodos
    public void visualizarReceitasFavoritas() {
        System.out.println("Consumidor" + getNome() + "está visualizando receitas favoritas.");
    };

    @Override
    public void exibirMenu(){
        System.out.println("Menu do Consumidor:");
        System.out.println("1 - Buscar receitas");
        System.out.println("2 - Favoritar receitas");
        System.out.println("3 - Comentar em receitas");
    }


    // #endregion

    // #region Métodos Sobrecarregados
    public String toString() {
        return "Consumidor { ID: " + getIdUsuario() +
                ", Nome: " + getNome() +
                ", Email: " + getEmail() +
                ", Data de Nascimento: " + getdataNascimento() +
                ", CEP: " + getCep() +
                ", Gênero: " + getGenero() +
                ", Inscrito: " + getInscrito() +
                ", UUID: " + getUuid() +
                "}";
    }
}
