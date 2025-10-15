package TudoGostoso;

public class Consumidor extends Usuario {
    
    //#region Construtor
        public Consumidor(int idUsuario, String nome, String email, String data_nascimento, int cep, String genero, String senha, String salt, String inscrito, String uuid){
            super(idUsuario, nome, email, data_nascimento, cep, genero, senha, salt, inscrito, uuid);
        
        }
    //#endregion
}
