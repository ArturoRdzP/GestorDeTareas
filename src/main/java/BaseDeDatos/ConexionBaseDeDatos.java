package BaseDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Logica.Usuario;

public class ConexionBaseDeDatos {
	// Información de la base de datos
	private static final String URL = "jdbc:mysql://edutaskmanager.cgi6egpm9ayl.us-west-1.rds.amazonaws.com:3306/EduTaskManager?serverTimezone=UTC";
	private static final String USUARIO = "admin";
	private static final String CONTRASEÑA = "Limoncillos";

	private ConexionBaseDeDatos() {
	}

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Error al inicializar la conexión de la base de datos");
		}
	}

	public static void insertarUsuario(Usuario usuario) {
		try (Connection conexion = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA)) {
			String query = "INSERT INTO usuario (id, nombre, correo, rol, contraseña) VALUES (?, ?, ?, ?, ?)";
			try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
				preparedStatement.setString(2, usuario.getNombre());
				preparedStatement.setString(3, usuario.getCorreo());
				preparedStatement.setString(4, usuario.getRol());
				preparedStatement.setString(5, usuario.getContraseña());
				preparedStatement.executeUpdate();
				System.out.println("Datos insertados en la tabla Usuario");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static List<Usuario> obtenerDatosUsuario() {
		List<Usuario> usuarios = new ArrayList<>();
		try (Connection conexion = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA)) {
			String query = "SELECT * FROM usuario";
			try (PreparedStatement preparedStatement = conexion.prepareStatement(query);
					ResultSet resultSet = preparedStatement.executeQuery()) {
				while (resultSet.next()) {
					String nombre = resultSet.getString("nombre");
					String correo = resultSet.getString("correo");
					String rol = resultSet.getString("rol");
					String contraseña = resultSet.getString("contraseña");
					
					Usuario usuario = new Usuario(nombre, correo, rol, contraseña);
					usuarios.add(usuario);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuarios;
	}
}
