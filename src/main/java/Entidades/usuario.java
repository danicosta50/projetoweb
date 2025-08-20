/**
     *classe usuario , define tabela usuario
     * 
     * 
     */

package Entidades;
 import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
     private String nome;
    private String login;
    private String senha;
    private String tipo;

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public String getTipo() {
        return tipo;
    }
    
}
