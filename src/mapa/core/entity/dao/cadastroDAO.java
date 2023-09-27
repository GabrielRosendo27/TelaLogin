
package mapa.core.entity.dao;

import mapa.core.entity.dao.connection.connectionJDBC;
import mapa.core.entity.cadastro;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class cadastroDAO {
    public void cadastrar(cadastro cadastro){
        String sql = "insert into usuario(nome, login, senha, email) values (?,?,?,?)";
       PreparedStatement ps;
       
       try {
       ps = connectionJDBC.getConnection().prepareStatement(sql);
       ps.setString(1, cadastro.getNome());
       ps.setString(2, cadastro.getLogin());
       ps.setString(3, cadastro.getSenha());
       ps.setString(4, cadastro.getEmail());
       ps.execute();
       }
       catch(SQLException e){
       e.printStackTrace();
       }
      }

    public boolean verificarLogin(String login, String senha){
           
        String sql = "SELECT id, nome, login, senha , email from usuario where login = ? and senha = ?";
        
        PreparedStatement ps;
        ResultSet rs;
  
        try {
             ps = connectionJDBC.getConnection().prepareStatement(sql);
             
            ps.setString(1, login);
            ps.setString(2, senha);
             
             rs = ps.executeQuery();
            
             if(rs.next()){
                 return true;
             }
             
        }catch (SQLException e){
           
        }
         return false;
    }
}