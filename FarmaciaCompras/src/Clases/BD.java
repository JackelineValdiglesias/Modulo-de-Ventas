package Clases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Clases.Response;

public class BD {
	private static String User, DBName = "dbcompras", DBDir = "C:/Users/ripley/Desktop/ProyectoAlgoritmos/Testing/FarmaciaCompras/src/Data/", BDScript="src/Data/dbcompras.db", DBdefdata="src/Data/bddefaultdata.sql"; 
	private static String[] Tablas = {"Compras","ComprasItems"};
	private static Connection connectDB() throws SQLException {
		File DbUrl = new File(DBDir); //Dirección de la BD
		if(!DbUrl.exists()) //Si no existe la URL
			DbUrl.mkdirs(); //Crear los directorios
		Connection con = null;
		try{
			Class.forName("org.sqlite.JDBC");
			boolean b = !(new File(DBDir+DBName+".db").exists()); 
			if (b) {
				System.out.println("No se tiene una base de datos");
				throw new SQLException();
			}
			System.out.println("dir: jdbc:sqlite:" + DBDir + DBName + ".db");
			con =(Connection) DriverManager.getConnection("jdbc:sqlite:" + DBDir + DBName + ".db");
		} catch(Exception e) {
			e.printStackTrace();
		}
		return (con==null)?null:con;
	}
	public static void closeBD(Connection c, Statement st) {
		try {
			st.close();
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void closeBD(Connection c, Statement st,ResultSet rs) {
		try {
			rs.close();
			st.close();
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static Vector<Compra> listCompra(JTable jt) {
		Vector<Compra> vv = new Vector<Compra>();
		try {
			Connection c = connectDB(); Statement st = c.createStatement();
			ResultSet rs = st.executeQuery("select * from Compras");
			while(rs.next()) {
				Compra v = new Compra(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7),
						rs.getString(8),
						rs.getString(9),
						rs.getDouble(10),
						rs.getInt(11),
						rs.getInt(12));
				vv.add(v);				
			}
			closeBD(c, st, rs);
			Utilidades.removeAllTable(jt);
			DefaultTableModel tb = (DefaultTableModel) jt.getModel();
			for (Compra aux :vv) {
				System.out.println(aux);
				tb.addRow(new String[] {
					String.valueOf(aux.id),
					String.valueOf(aux.fechaEmision),			
					String.valueOf(aux.nombre),	
					String.valueOf(aux.nomproveedor),
					String.valueOf(aux.totalImporte),
					String.valueOf(aux.estado),				
				});
			}
			System.out.println("RESULT:" + vv.toArray() + " s>" + vv.size());
		} catch (Exception e) {
			System.out.println("Error:" + e.getMessage());
		}
		return vv;
	}
	
	public static Compra getCompra(int id) {
		try {
			Connection c = connectDB(); Statement st = c.createStatement();
			ResultSet rs = st.executeQuery("select c.*,SUM(ci.importe) as total from Compras c join ComprasItems ci ON ci.idCompra = c.id where c.id="+id);
			rs.next();
			Compra v = new Compra(
							rs.getInt(1),
							rs.getString(2),
							rs.getString(3),
							rs.getString(4),
							rs.getString(5),
							rs.getString(6),
							rs.getString(7),
							rs.getString(8),
							rs.getString(9),
							rs.getDouble(13),
							rs.getInt(11),
							rs.getInt(12));
			closeBD(c, st, rs);
			return v;
		} catch (Exception e) {
			System.out.println("Error:" + e.getMessage());
			return null;
		}
	}
	
	public static Response nuevaCompra(Compra v) {
		try {
			String sql = "insert into Compras(fechaEmision,fechaEntregaEstimada,fechaEntrega,nombre,DNI,nomproveedor,rucProv,numFactura,totalImporte,estado, moneda) "
					+ "values('"+v.fechaEmision+"','"+v.fechaEntregaEstimada+"','"+v.fechaEntrega+"','"+v.nombre+"','"+v.DNI+"','"+v.nomproveedor+"','"+v.rucProv+"','"+v.numFactura+"',"+v.totalImporte+","+v.estado+","+v.moneda+");";
			System.out.println(sql);
			Connection c = connectDB(); Statement st = c.createStatement(); st.execute(sql); closeBD(c, st);
			return (new Response(null, 1, "Exitosa"));
		} catch (Exception e) {
			System.out.println("Error:" + e.getMessage());
			return (new Response(null, 0, "Error"));
		}
	}
	
	public static Response editCompra(Compra v) {
		try {
			String sql = "update Compras set fechaEmision='"+v.fechaEmision+"',fechaEntregaEstimada='"+v.fechaEntregaEstimada+"',fechaEntrega='"+v.fechaEntrega+ "',nombre='"+v.nombre+"',DNI='"+v.DNI+ "',nomproveedor='"+v.nomproveedor+ "',rucProv='"+v.rucProv+ "',numFactura='"+v.numFactura+ "',totalImporte="+v.totalImporte+ ",estado="+v. estado+ ",moneda="+v.moneda +" where id="+v.id+";";
			System.out.println(sql);
			Connection c = connectDB(); Statement st = c.createStatement(); st.executeUpdate(sql); closeBD(c, st);
			return (new Response(null, 1, "Exitosa"));
		} catch (Exception e) {
			System.out.println("Error:" + e.getMessage());
			return (new Response(null, 0, "Error: " + e.getMessage()));
		}
	}
	
	//Editado
	public static Response deleteCompra(int id) {
		try {
			String sql = "delete from Compras where id="+id+";";
			System.out.println(sql);
			Connection c = connectDB(); Statement st = c.createStatement(); st.execute(sql); closeBD(c, st);
			return (new Response(null, 1, "Exitosa"));
		} catch (Exception e) {
			System.out.println("Error:" + e.getMessage());
			return (new Response(null, 0, "Error"));
		}
	}
	//Editar
	public static int intVal(TableModel tm,int row,int col) {
		return Integer.parseInt((String) tm.getValueAt(row, col));
	}
	public static Vector<CompraItem> listCompraItem(JTable jt, int idCompra) {
		Vector<CompraItem> vv = new Vector<CompraItem>();
		try {
			System.out.println("IDC: "+idCompra);
			Connection c = connectDB(); Statement st = c.createStatement();
			ResultSet rs = st.executeQuery("select * from ComprasItems where idCompra="+idCompra);
			while(rs.next()) {
				CompraItem v = new CompraItem(
						rs.getInt(1), //id
						rs.getString(2), //nombre						
						rs.getDouble(3), //precio
						rs.getInt(4), //cantidad
						rs.getDouble(5), //importe
						rs.getInt(6) //idCompra
					);
				vv.add(v);				
			}
			closeBD(c, st, rs);
			Utilidades.removeAllTable(jt);
			DefaultTableModel tb = (DefaultTableModel) jt.getModel();
			for (CompraItem aux :vv) {
				System.out.println(aux);
				tb.addRow(new String[] {
					String.valueOf(aux.id), //id
					String.valueOf(aux.nombre), //nombre					 
					String.valueOf(aux.precio), //precio
					String.valueOf(aux.cantidad), //cantidad
					String.valueOf(aux.importe), //importe
					String.valueOf(aux.idCompra),//idCompra
				});
			}
			System.out.println("RESULT:" + vv.toArray() + " s>" + vv.size());
		} catch (Exception e) {
			System.out.println("Error:" + e.getMessage());
		}
		return vv;
	}
	public static CompraItem getCompraItem(int id) {
		try {
			Connection c = connectDB(); Statement st = c.createStatement();
			ResultSet rs = st.executeQuery("select * from ComprasItems where id="+id);
			rs.next();
			CompraItem v = new CompraItem(
					rs.getInt(1), //id
					rs.getString(2), //nombre					
					rs.getDouble(3), //precio
					rs.getInt(4), //cantidad
					rs.getDouble(5), //importe
					rs.getInt(6) //idCompra
				);
			closeBD(c, st, rs);
			return v;
		} catch (Exception e) {
			System.out.println("Error:" + e.getMessage());
			return null;
		}
	}
	public static Response newCompraItem(CompraItem v) {
		try {
			String sql = "insert into ComprasItems(nombre,precio,cantidad,importe,idCompra) values('"+v.nombre+"',"+v.precio+","+v.cantidad+","+v.importe+","+v.idCompra+");";
			System.out.println(sql);
			Connection c = connectDB(); Statement st = c.createStatement(); st.execute(sql); closeBD(c, st);
			return (new Response(null, 1, "Exitosa"));
		} catch (Exception e) {
			System.out.println("Error:" + e.getMessage());
			return (new Response(null, 0, "Error"));
		}
	}
	public static Response editCompraItem(CompraItem v) {
		try {
			String sql = "update ComprasItems set nombre='"+v.nombre+"',precio="+v.precio+",cantidad="+v.cantidad+",importe="+v.importe+",idCompra="+v.idCompra+" where id="+v.id+";";
			System.out.println(sql);
			Connection c = connectDB(); Statement st = c.createStatement(); st.executeUpdate(sql); closeBD(c, st);
			return (new Response(null, 1, "Exitosa"));
		} catch (Exception e) {
			System.out.println("Error:" + e.getMessage());
			return (new Response(null, 0, "Error"));
		}
	}
	public static Response deleteCompraItem(int id) {
		try {
			String sql = "delete from ComprasItems where id="+id+";";
			System.out.println(sql);
			Connection c = connectDB(); Statement st = c.createStatement(); st.execute(sql); closeBD(c, st);
			return (new Response(null, 1, "Exitosa"));
		} catch (Exception e) {
			System.out.println("Error:" + e.getMessage());
			return (new Response(null, 0, "Error"));
		}
	}

};
