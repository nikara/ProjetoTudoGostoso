package TudoGostoso.model;

public class Administrador extends Usuario {

    //#region Construtor
        public Administrador(int idUsuario, String nome, String email, String data_nascimento, int cep, String genero, String senha, String salt, String inscrito, String uuid){
            super(idUsuario, nome, email, data_nascimento, cep, genero, senha, salt, inscrito, uuid);

        }
    //#endregion

    //#region Metódos

    public void gerenciarUsuarios(){
        System.out.println("Administrador"+getNome()+" está gerenciando usuários.");
    };

    @Override
    public void exibirMenu(){
        System.out.println("Menu do Administrador:");
        System.out.println("1 - Gerenciar usuários");
        System.out.println("2 - Aprovar receitas");
        System.out.println("3 - Visualizar relatórios");
    }
    //#endregion

    //#region Metódos sobrecarragados
    @Override
    public String toString(){
        return "Administrador { ID: " + getIdUsuario() +
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