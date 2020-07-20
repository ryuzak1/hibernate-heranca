package model;

import javax.persistence.Entity;

@Entity
public class ContaPolpanca extends Conta {


    private int preco;

    public void deposito(Conta destino, double valor){
        destino.setSaldo(destino.getSaldo()+valor);
    }

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }
}
