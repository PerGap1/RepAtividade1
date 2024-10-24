import javax.management.Query;
import javax.swing.table.DefaultTableModel;

public class Tabela {
    private String[] colunas = {"ID", "Nome", "Valor", "Status"};
    private DefaultTableModel tabelaModelo;
    
    public Tabela() {
        tabelaModelo = new DefaultTableModel(colunas, 0);
        
        TypedQuery<ProdutosDTO> produto = manager.createQuery("SELECT j FROM Jogos j WHERE j.id = :id AND j.:tipo = :filtro", Jogos.class);
        
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
    
    public Tabela(int diferencial) {
        tabelaModelo = new DefaultTableModel(colunas, 0);
        
        List<ProdutosDTO> lista = ProdutosDAO.listarProdutos();

        for (int i = 0; i < lista.size(); i++) {
            ProdutosDTO produtoAtual = lista.get(i);

            if(produtoAtual.getStatus().equals("Vendido")){
                String[] linha = {
                String.valueOf(produtoAtual.getId()),
                produtoAtual.getNome(),
                String.valueOf(produtoAtual.getValor()),
                produtoAtual.getStatus()
                };
                
                tabelaModelo.addRow(linha);
            }
        }
    }
    
    public DefaultTableModel getTabelaModelo() {
        return tabelaModelo;
    }
}
