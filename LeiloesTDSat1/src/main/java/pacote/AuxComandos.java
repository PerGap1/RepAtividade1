package pacote;

import br.com.senac.leiloestdsat1.conexao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import javax.swing.JOptionPane;

public class AuxComandos {
    static EntityManager manager = conexao.getManager();
    
    public static ProdutosDTO ConsultaProdutos(int id){
        
        
        TypedQuery<ProdutosDTO> consulta = manager.createQuery("SELECT p FROM ProdutosDTO p WHERE p.id = :id", ProdutosDTO.class);
        consulta.setParameter("id", id);
        
        try{
            ProdutosDTO produtoAtual = consulta.getSingleResult();

            return produtoAtual;
        }
        catch(NoResultException | NullPointerException e){
            return null;
        }
    }
    
    public static void Alterar(ProdutosDTO produto){
        produto.setStatus("Vendido");
    }
}
