package model;
import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pessoa  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPessoa;
    private String nome;
    private String email;



    public void setIdPessoa(Long id) {
        this.idPessoa = id;
    }

    public Long getIdPessoa() {
        return idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + idPessoa +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

