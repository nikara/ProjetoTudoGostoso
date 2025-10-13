package TudoGostoso;

public class Consumidor extends Usuario {
    
    public Consumidor(){
        super(getIdUsuario(), getNome(), getEmail(), getData_nascimento(), getCep(), getGenero(), getSenha(), getSalt(), getInscrito(), getUuid())
    }
}
