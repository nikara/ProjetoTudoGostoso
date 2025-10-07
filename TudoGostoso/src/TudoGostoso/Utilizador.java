package TudoGostoso;

public class Utilizador extends Usuario {
    
    public Utilizador(){
        super(getIdUsuario(), getNome(), getEmail(), getData_nascimento(), getCep(), getGenero(), getSenha(), getSalt(), getInscrito(), getUuid())
    }
}
