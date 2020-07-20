import dao.DaoGerenic;
import dao.DaoPessoa;
import dao.HibernateUtil;
import model.ContaPolpanca;
import model.PessoaFisica;
import org.junit.Test;

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
}
