import dao.DaoGerenic;
import dao.DaoPessoa;
import dao.HibernateUtil;
import model.ContaPolpanca;
import model.PessoaFisica;
import org.junit.Test;

import java.util.List;

public class AppTeste {


    @Test
    public void testarConexao(){
        HibernateUtil.getEntityManager();
    }

    @Test
    public void testeTrasacoes(){

        DaoGerenic<PessoaFisica> daoGerenicPessoa = new DaoGerenic<PessoaFisica>();
        DaoGerenic<ContaPolpanca> contaPolpancaDaoGerenic = new DaoGerenic<ContaPolpanca>();
        PessoaFisica pessoaFisica = new PessoaFisica();

        pessoaFisica.setNome("José");
        pessoaFisica.setCpf("1234");
        pessoaFisica.setEmail("jose@gmail.com");

        ContaPolpanca contaPolpanca = new ContaPolpanca();

        contaPolpanca.setPessoa(pessoaFisica);
        contaPolpanca.setNumero("123");
        contaPolpanca.setSaldo(0D);
        contaPolpanca.setAgencia("460");
        contaPolpanca.setPreco(20);
        
        daoGerenicPessoa.salvar(pessoaFisica);
        contaPolpancaDaoGerenic.salvar(contaPolpanca);

    }
    @Test
    public void pesquisarId(){
        DaoGerenic<PessoaFisica> daoGerenic = new DaoGerenic<PessoaFisica>();
        PessoaFisica pessoaFisica = daoGerenic.pesquisaID(1L,PessoaFisica.class);

        System.out.println(pessoaFisica.getNome());

        DaoGerenic<ContaPolpanca> contaPolpancaDaoGerenic = new DaoGerenic<ContaPolpanca>();
        ContaPolpanca contaPolpanca = contaPolpancaDaoGerenic.pesquisaID(2L,ContaPolpanca.class);

        System.out.println(contaPolpanca.getPessoa().getNome());

    }

    @Test
    public void listar(){
        DaoGerenic<PessoaFisica> daoGerenic = new DaoGerenic<PessoaFisica>();
        List<PessoaFisica> usePessoaFisicas = daoGerenic.listar(PessoaFisica.class);
        for (PessoaFisica f: usePessoaFisicas) {
            System.out.println(f.toString());

        }

    }


}
