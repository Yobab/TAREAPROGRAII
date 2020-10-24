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
    
    public StringBuffer OpcionesMarcas(){       
         StringBuffer respuesta = new StringBuffer();
         conn= new Conexion();
         cn = conn.conectar();
       
        String sql="select * from tarea.marca";
       
        try{
        prstmt = cn.prepareStatement(sql);                        
        result = prstmt.executeQuery();    
            if (result!=null){
                while (result.next()){  
                    respuesta.append("<option value=\"").append(result.getString("id_marca")).append("\">").append(result.getString("nombre")).append("</option>");              
                }
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return respuesta;
    }
    public StringBuffer OpcionesCategorias(){       
         StringBuffer respuesta = new StringBuffer();
         conn= new Conexion();
         cn = conn.conectar();
       
        String sql="select * from tarea.categoria";
       
        try{
        prstmt = cn.prepareStatement(sql);                        
        result = prstmt.executeQuery();    
            if (result!=null){
                while (result.next()){  
                    respuesta.append("<option value=").append(result.getString("id_categoria")).append(">").append(result.getString("nombre")).append("</option>");              
                }
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return respuesta;
    }
    
    public StringBuffer obtenerCategorias(){       
         StringBuffer respuesta = new StringBuffer();
         conn= new Conexion();
         cn = conn.conectar();
       
        String sql="select * from tarea.categoria";
       
        try{
        prstmt = cn.prepareStatement(sql);                        
        result = prstmt.executeQuery();    
            if (result!=null){
                while (result.next()){  
                    respuesta.append("<tr>");
                    respuesta.append("<td>").append(result.getString("id_categoria")).append("</td>");
                    respuesta.append("<td>").append(result.getString("nombre")).append("</td>");
                    respuesta.append("<td>").append(result.getString("descripcion")).append("</td>");
                    respuesta.append("</tr>");
                }
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return respuesta;
    }
    public StringBuffer obtenerMarcas(){       
         StringBuffer respuesta = new StringBuffer();
         conn= new Conexion();
         cn = conn.conectar();
       
        String sql="select * from tarea.marca";
       
        try{
        prstmt = cn.prepareStatement(sql);                        
        result = prstmt.executeQuery();    
            if (result!=null){
                while (result.next()){  
                    respuesta.append("<tr>");
                    respuesta.append("<td>").append(result.getString("id_marca")).append("</td>");
                    respuesta.append("<td>").append(result.getString("nombre")).append("</td>");
                    respuesta.append("<td>").append(result.getString("descripcion")).append("</td>");
                    respuesta.append("</tr>");
                }
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return respuesta;
    }
    
    public StringBuffer obtenerProductos(){       
         StringBuffer respuesta = new StringBuffer();
         conn= new Conexion();
         cn = conn.conectar();
       
        String sql="select tarea.producto.*,tarea.marca.nombre as marca, tarea.categoria.nombre as categoria from tarea.producto left join tarea.marca using (id_marca) left join tarea.categoria using (id_categoria) ";
       
        try{
        prstmt = cn.prepareStatement(sql);                        
        result = prstmt.executeQuery();    
            if (result!=null){
                while (result.next()){  
                    respuesta.append("<tr>");
                    respuesta.append("<td>").append(result.getString("codigo")).append("</td>");
                    respuesta.append("<td>").append(result.getString("nombre")).append("</td>");
                    respuesta.append("<td>").append(result.getString("descripcion")).append("</td>");
                    respuesta.append("<td>").append(result.getString("precio")).append("</td>");
                    respuesta.append("<td>").append(result.getString("marca")).append("</td>");
                    respuesta.append("<td>").append(result.getString("categoria")).append("</td>");
                    respuesta.append("</tr>");
                }
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return respuesta;
    }
    
    public void registrarMarca(String nombre, String descripcion){
        conn= new Conexion();
         cn = conn.conectar();
       
        String sql="INSERT INTO tarea.marca (nombre, descripcion) VALUES (?,?)";
       
        try{
        prstmt = cn.prepareStatement(sql);      
        prstmt.setString(1, nombre);
        prstmt.setString(2, descripcion);
        prstmt.executeUpdate();     
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    public void registrarProducto(String codigo,String nombre, String descripcion, double precio,int id_marca, int id_categoria){
        conn= new Conexion();
         cn = conn.conectar();
       
        String sql="INSERT INTO tarea.producto (codigo,nombre, descripcion,precio,id_marca,id_categoria) VALUES (?,?,?,?,?,?)";
       
        try{
        prstmt = cn.prepareStatement(sql);      
        prstmt.setString(1, codigo);
        prstmt.setString(2, nombre);
        prstmt.setString(3, descripcion);
        prstmt.setDouble(4, precio);
        prstmt.setInt(5, id_marca);
        prstmt.setInt(6, id_categoria);
        prstmt.executeUpdate();     
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
     public void registrarCategoria(String nombre, String descripcion){
        conn= new Conexion();
         cn = conn.conectar();
       
        String sql="INSERT INTO tarea.categoria (nombre, descripcion) VALUES (?,?)";
       
        try{
        prstmt = cn.prepareStatement(sql);      
        prstmt.setString(1, nombre);
        prstmt.setString(2, descripcion);
        prstmt.executeUpdate();    
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
}