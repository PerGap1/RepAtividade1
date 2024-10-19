import java.util.List;
import javax.swing.table.DefaultTableModel;

public class Tabela {
    private String[] colunas = {"ID", "Nome", "Valor", "Status"};
    private DefaultTableModel tabelaModelo;
    
    public Tabela() {
        tabelaModelo = new DefaultTableModel(colunas, 0);

        //ProdutosDAO produtosDAO = new ProdutosDAO();
        List<ProdutosDTO> lista = ProdutosDAO.listarProdutos();

        for (int i = 0; i < lista.size(); i++) {
            ProdutosDTO produtoAtual = lista.get(i);

            String[] linha = {
                String.valueOf(produtoAtual.getId()),
                produtoAtual.getNome(),
                String.valueOf(produtoAtual.getValor()),
                produtoAtual.getStatus()
            };
            
            tabelaModelo.addRow(linha);
        }
    }
    
    public DefaultTableModel getTabelaModelo() {
        return tabelaModelo;
    }
}
