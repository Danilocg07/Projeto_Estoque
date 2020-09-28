package utilitarios;
import java.sql.*;
import javax.swing.*;

public class conexao
{
    
final private String driver = "jdbc:ucanaccess://";
final private String url = "\\Estoque\\bancoDados\\Estoque.accdb";
final private String usuario = "";
final private String senha = "";
private Connection conexao;
public Statement statement;
public ResultSet resultset;

         public boolean conecta()
         {
      
         boolean result = true;
         try
         {
                        conexao = DriverManager.getConnection(driver + url, usuario, senha);
            //JOptionPane.showMessageDialog(null," Conectou!");
         }
        
         catch(SQLException Fonte)
         {
             JOptionPane.showMessageDialog(null,"Deu erro na conexão: "+
                           "com a fonte de dados: "+Fonte);
          result = false;
        }
        return result;  
         }
    
    public void desconecta()
    {
        boolean result = true;
            try
            {
                conexao.close();
                JOptionPane.showMessageDialog(null,"banco fechado");
            }
            catch(SQLException erroSQL)
            {
                JOptionPane.showMessageDialog(null,"Não foi possivel "+
                        "fechar o banco de dados: "+erroSQL.getMessage());
                result = false;
            } 
    }
           
         
        public void executeSQL(String sql)
        {
            try
            {
                statement = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
                resultset = statement.executeQuery(sql);
            }
            catch(SQLException sqlex)
            {
                JOptionPane.showMessageDialog(null,"Não foi possivel conectar "+sqlex+
                        "o sql passado foi "+sqlex);
            }
                    
        }
}
