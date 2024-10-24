import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    static ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public void cadastrarProduto (ProdutosDTO produto){
        listagem.add(produto);

        conn = new conectaDAO().connectDB();
    }
    
    public static ArrayList<ProdutosDTO> listarProdutos(){
        
        return listagem;
    }    
    
    public void venderProduto(int id){
        ProdutosDTO produto = ProdutosDAO.listagem.get(id);
        
        if (!produto.getStatus().equals("Vendido")){
            produto.setStatus("Vendido");
            JOptionPane.showMessageDialog(null, "Produto vendido com sucesso!");
        }
        
        else{
            JOptionPane.showMessageDialog(null, "O produto já foi vendido!");
        }
    }
}

