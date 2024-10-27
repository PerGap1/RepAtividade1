package pacote;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class Tabela {
    private String[] colunas = {"Id", "Nome", "Valor (R$)", "Status"};
    private DefaultTableModel tabelaModelo;
    
    public Tabela() {
        tabelaModelo = new DefaultTableModel(colunas, 0);
        
        ArrayList<ProdutosDTO> listaProdutos = produtosDAO.listarProdutos();

        for (ProdutosDTO produtoAtual : listaProdutos) {
            try{
                String[] linha = {
                    String.valueOf(produtoAtual.getId()),
                    produtoAtual.getNome(),
                    String.valueOf(produtoAtual.getValor()),
                    produtoAtual.getStatus()
                };

                tabelaModelo.addRow(linha);
            }
            catch(NullPointerException e){}
        }
    }
    
    public Tabela(int diferencial) {
        tabelaModelo = new DefaultTableModel(colunas, 0);
        
        ArrayList<ProdutosDTO> listaProdutos = produtosDAO.listarProdutosVendidos();

        for (ProdutosDTO produtoAtual : listaProdutos) {
            try{
                String[] linha = {
                    String.valueOf(produtoAtual.getId()),
                    produtoAtual.getNome(),
                    String.valueOf(produtoAtual.getValor()),
                    produtoAtual.getStatus()
                };

                tabelaModelo.addRow(linha);
            }
            catch(NullPointerException e){}
        }
    }
    
    public DefaultTableModel getTabelaModelo() {
        return tabelaModelo;
    }
}
