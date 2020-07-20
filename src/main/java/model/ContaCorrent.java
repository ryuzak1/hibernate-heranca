package model;


import javax.persistence.Entity;

@Entity
public class ContaCorrent extends Conta{

    private String apelido;


    public void deposito(Conta origin,Conta destino, double valor){
        if (origin.getSaldo()>=valor){
            destino.setSaldo(origin.getSaldo()+valor);
            origin.setSaldo(origin.getSaldo()-valor);
            System.out.println("deposito feito com sucesso");
        }else{
            System.out.println("saldo indisponivel");
        }
    }


}
