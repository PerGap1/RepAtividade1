package pacote;

import br.com.senac.leiloestdsat1.conexao;
import javax.swing.table.DefaultTableModel;

public class Tabela {
    private String[] colunas = {"Id", "Nome", "Valor (R$)", "Status"};
    private DefaultTableModel tabelaModelo;
    
    public Tabela() {
        tabelaModelo = new DefaultTableModel(colunas, 0);

        for (int i = 0; i <= conexao.retornaIdMaxUsuario(); i++) {
            try{
                ProdutosDTO produtoAtual = AuxComandos.ConsultaProdutos(i);

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

        for (int i = 0; i <= conexao.retornaIdMaxUsuario(); i++) {
            try{
                ProdutosDTO produtoAtual = AuxComandos.ConsultaProdutos(i);

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
            catch(NullPointerException e){}
        }
    }
    
    public DefaultTableModel getTabelaModelo() {
        return tabelaModelo;
    }
}
