package Modelos;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class BaseDatos {
    private Conexion conn;
    private Connection cn;
    private PreparedStatement prstmt = null;
    private ResultSet result = null;
    
    public StringBuffer prueba(){       
         StringBuffer respuesta = new StringBuffer();
         conn= new Conexion();
         cn = conn.conectar();
       
        String sql="select * from tarea.marca";
       
        try{
        prstmt = cn.prepareStatement(sql);                        
        result = prstmt.executeQuery();    
            if (result!=null){
                while (result.next()){  
                    respuesta.append(result.getString("nombre"));              
                }
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return respuesta;
    }
    
    
}