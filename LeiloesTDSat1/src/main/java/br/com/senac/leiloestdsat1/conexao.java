package br.com.senac.leiloestdsat1;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import javax.swing.JOptionPane;
import pacote.cadastroVIEW;

public class conexao {
    public static EntityManagerFactory fabricaEntidade = Persistence.createEntityManagerFactory("unidade");
    public static EntityManager manager = fabricaEntidade.createEntityManager();
    
    public static void main(String[] args) {
        cadastroVIEW cadastroVIEW = new cadastroVIEW();
        cadastroVIEW.setVisible(true);
    }
    
    public static EntityManager getManager(){
        return manager;
    }
    
    public static int retornaIdMaxUsuario(){
        try{
            TypedQuery<Integer> consulta = manager.createQuery("SELECT MAX(id) AS idMaximo from ProdutosDTO", Integer.class);
            Integer resultado = consulta.getSingleResult();

            return resultado;
        }
        catch(NullPointerException e){
            return 0;
        }
    }  
}
