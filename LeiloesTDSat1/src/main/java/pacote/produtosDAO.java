package pacote;

import br.com.senac.leiloestdsat1.conexao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;

public class produtosDAO {

    PreparedStatement prep;
    ResultSet resultset;
    static ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public static void preencherLista(){
        for (int i = 0; i <= conexao.retornaIdMaxUsuario(); i++) {
            try{
                ProdutosDTO produtoAtual = ConsultaProdutos(i);
                
                listagem.add(produtoAtual);
            }
            catch(NullPointerException e){}
        }
    }

    public static void cadastrarProduto (ProdutosDTO produto){
        EntityManager manager = conexao.getManager();

        manager.getTransaction().begin();
        manager.persist(produto);
        manager.getTransaction().commit();

        JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
    }
    
    public static void venderProduto(ProdutosDTO produto){
        conexao.getManager().getTransaction().begin();
        produto.setStatus("Vendido");
        conexao.getManager().getTransaction().commit();
        
        JOptionPane.showMessageDialog(null, "Produto vendido com sucesso!");
    }
    
    public static ProdutosDTO ConsultaProdutos(int id){
        TypedQuery<ProdutosDTO> consulta = conexao.getManager().createQuery("SELECT p FROM ProdutosDTO p WHERE p.id = :id", ProdutosDTO.class);
        consulta.setParameter("id", id);
        
        try{
            ProdutosDTO produtoAtual = consulta.getSingleResult();

            return produtoAtual;
        }
        catch(NoResultException | NullPointerException e){
            return null;
        }
    }
    
    public static ArrayList<ProdutosDTO> listarProdutos(){
        return listagem;
    }  
    
    public static ArrayList<ProdutosDTO> listarProdutosVendidos(){
        ArrayList<ProdutosDTO> lista = new ArrayList<>();
        
        for (int i = 0; i <= conexao.retornaIdMaxUsuario(); i++) {
            try{
                ProdutosDTO produtoAtual = ConsultaProdutos(i);
                
                if(produtoAtual.getStatus().equals("Vendido")){
                   listagem.add(produtoAtual); 
                }
            }
            catch(NullPointerException e){}
        }
        
        return lista;
    }
}

