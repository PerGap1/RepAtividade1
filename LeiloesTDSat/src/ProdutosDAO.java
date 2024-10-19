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

        JOptionPane.showMessageDialog(null, listagem.size());
        
        conn = new conectaDAO().connectDB();
    }
    
    public static ArrayList<ProdutosDTO> listarProdutos(){
        
        return listagem;
    }    
}

