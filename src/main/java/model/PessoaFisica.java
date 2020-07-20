package model;

import javax.persistence.*;

@Entity
public class PessoaFisica extends Pessoa {

    private String cpf;

    public PessoaFisica() {
    }


    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


    @Override
    public String toString() {
        return "PessoaFisica{" +
                "cpf='" + cpf + '\'' +
                '}';
    }
}
