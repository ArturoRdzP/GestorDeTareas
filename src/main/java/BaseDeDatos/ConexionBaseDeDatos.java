package BaseDeDatos;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.primefaces.model.diagram.Connection;

import AccionesprimeFaces.CalendarBean;
import AccionesprimeFaces.VistaProfesores;
import AccionesprimeFaces.vistaAsignacion;
import Logica.Asignacion;
import Logica.Grupo;
import Logica.Materia;
import Logica.Usuario;
import java.time.LocalDateTime;

public class ConexionBaseDeDatos {
	// Información de la base de datos
	private static final String URL = "jdbc:mysql://edutaskmanager.cgi6egpm9ayl.us-west-1.rds.amazonaws.com:3306/tareas2?serverTimezone=UTC";
	private static final String USUARIO = "admin";
	private static final String CONTRASEÑA = "Limoncillos";

	public static List<Usuario> obtenerDatosUsuario() {
		List<Usuario> usuarios = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try (java.sql.Connection conexion = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA)) {
				String query = "SELECT * FROM usuario";
				try (PreparedStatement preparedStatement = conexion.prepareStatement(query);
						ResultSet resultSet = preparedStatement.executeQuery()) {
					while (resultSet.next()) {
						String clave_usuario = resultSet.getString("id");
						String nombre = resultSet.getString("nombre");						
						String correo = resultSet.getString("correo");
						String rol = resultSet.getString("rol");
						String contraseña = resultSet.getString("contraseña");
						Usuario usuario = new Usuario(clave_usuario,nombre,correo,rol,contraseña);
						// String clave_usuario, String contraseña, String rol, String correo
						//Usuario usuario = new Usuario(clave_usuario, contraseña, rol, correo);
						System.out.println(correo + " " + contraseña);
						usuarios.add(usuario);
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return usuarios;
	}
	public static List<Materia> obtenermateria(String claveProfesor) {
		List<Materia> materia = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try (java.sql.Connection conexion = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA)) {
				String query = "SELECT nombre, imagen FROM materias WHERE clave_materia = ?";
				try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
					preparedStatement.setString(1, claveProfesor);
					try (ResultSet resultSet = preparedStatement.executeQuery()) {
						while (resultSet.next()) {
							String imagen = resultSet.getString("imagen");
							String nombre = resultSet.getString("nombre");
							Materia ma = new Materia(imagen, nombre);
							materia.add(ma);
						}
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return materia;
	}
	public static Materia materia(String claveProfesor) {
		Materia materia = null ;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try (java.sql.Connection conexion = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA)) {
				String query = "SELECT nombre, imagen FROM materias WHERE clave_materia = ?";
				try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
					preparedStatement.setString(1, claveProfesor);
					try (ResultSet resultSet = preparedStatement.executeQuery()) {
						while (resultSet.next()) {
							String imagen = resultSet.getString("imagen");
							String nombre = resultSet.getString("nombre");
							materia = new Materia(imagen, nombre);
							
						}
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return materia;
	}
	public static List<Grupo> obtenerGruposPorClaveProfesor(String claveProfesor) {
		List<Grupo> grupos = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try (java.sql.Connection conexion = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA)) {
				String query = "SELECT clave_grupo, clave_profesor, clave_materia FROM grupos WHERE clave_profesor = ?";
				try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
					preparedStatement.setString(1, claveProfesor);
					try (ResultSet resultSet = preparedStatement.executeQuery()) {
						while (resultSet.next()) {
							String claveGrupo = resultSet.getString("clave_grupo");
							String claveMateria = resultSet.getString("clave_materia");
							Materia mat=materia(claveMateria);
							Grupo grupo = new Grupo(claveGrupo, claveProfesor, mat);
							grupos.add(grupo);
						}
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return grupos;
	}

	public static String obtenerProfesorPorClaveUsuario(String claveUsuario) {

		String clave = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try (java.sql.Connection conexion = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA)) {
				String query = "SELECT clave_profesor, nombre FROM profesors WHERE clave_usuario = ?";
				try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
					preparedStatement.setString(1, claveUsuario);
					try (ResultSet resultSet = preparedStatement.executeQuery()) {
						if (resultSet.next()) {
							String claveProfesor = resultSet.getString("clave_profesor");
							String nombre = resultSet.getString("nombre");
							clave = claveProfesor;
						}
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return clave;
	}

	public static String obtenerProfesorNOmbrePorClaveUsuario(String claveUsuario) {

		String clave = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try (java.sql.Connection conexion = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA)) {
				String query = "SELECT clave_profesor, nombre FROM profesors WHERE clave_usuario = ?";
				try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
					preparedStatement.setString(1, claveUsuario);
					try (ResultSet resultSet = preparedStatement.executeQuery()) {
						if (resultSet.next()) {

							String nombre = resultSet.getString("nombre");
							clave = nombre;
						}
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return clave;
	}
	
	public static List<VistaProfesores> consultarDatos(String claveUsuario) {
	    List<VistaProfesores> resultados = new ArrayList<>();

	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");

	        try (java.sql.Connection conexion = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA)) {
	            String sql = "SELECT usuario.nombre AS nombre_usuario, profesor.no_profesor, grupo.clave, materia.clave, materia.nombre AS nombre_materia, materia.imagen AS imagen_materia " +
	                         "FROM usuario " +
	                         "JOIN profesor ON usuario.id = profesor.id_usuario " +
	                         "JOIN grupo ON profesor.id_usuario = grupo.profesor_id " +
	                         "JOIN materia ON grupo.materia_id = materia.id " +
	                         "WHERE usuario.id = ?";

	            try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
	                preparedStatement.setString(1, claveUsuario);

	                try (ResultSet resultSet = preparedStatement.executeQuery()) {
	                    while (resultSet.next()) {
	                        String nombreUsuario = resultSet.getString("nombre_usuario");
	                        String no_profesor = resultSet.getString("no_profesor");
	                        String clave_grupo = resultSet.getString("clave");
	                        String clave_materia = resultSet.getString("clave");
	                        String nombre_materia = resultSet.getString("nombre_materia");
	                        String imagen_materia = resultSet.getString("imagen_materia");
	                        System.out.println("Nombre de usuario obtenido de la base de datos: " + nombreUsuario);
	                        VistaProfesores vis = new VistaProfesores(nombre_materia, clave_grupo, imagen_materia, clave_materia, no_profesor,nombreUsuario);
	                        vis.setNombreUsuario(nombreUsuario);
	                        resultados.add(vis);
	                    }
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    }
	    System.out.println("Lista de resultados antes de devolver: " + resultados);
	    return resultados;
	}

	public static List<vistaAsignacion> obtenerAsignacionesPorClaveGrupo(String claveGrupo) throws SQLException{
	    List<vistaAsignacion> asignaciones = new ArrayList<>();
		
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        try (java.sql.Connection conexion = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA)) {
	            String sqlGrupo = "SELECT id FROM grupo WHERE clave = ?";
	            try (PreparedStatement psGrupo = conexion.prepareStatement(sqlGrupo)) {
	                psGrupo.setString(1, claveGrupo);
	                try (ResultSet rsGrupo = psGrupo.executeQuery()) {
	                	if (rsGrupo.next()) {
	                		int idGrupo = rsGrupo.getInt("id");
	                        String sqlAsignacion = "SELECT * FROM asignacion WHERE grupo_id = ?";
	                        try (PreparedStatement psAsignacion = conexion.prepareStatement(sqlAsignacion)) {
	                        	psAsignacion.setInt(1, idGrupo);
	                        	 try (ResultSet rsAsignacion = psAsignacion.executeQuery()) {
	                        		 while (rsAsignacion.next()) {
	                        			 int idAsignacion = rsAsignacion.getInt("id");
	                        			 String titulo= rsAsignacion.getString("titulo");
	                        			 String descripcion= rsAsignacion.getString("descripcion");
	                        			 int grupo=rsAsignacion.getInt("grupo_id");
	                        			 Date fecha_creacion=rsAsignacion.getDate("fecha_creacion");
	                        			 Date vencimiento=rsAsignacion.getDate("fechaVencimiento");
	                        			 
	                        			 vistaAsignacion asignacion = new vistaAsignacion(idAsignacion, titulo,descripcion,grupo,fecha_creacion,vencimiento);
	                        			 asignaciones.add(asignacion);
	                        			 
	                        		 }
	                        	 }
	                        }
	                	}
	                }
	            }
	        }
	    
	    }
	    catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    }
	    return asignaciones;
		
	}
	
	public static List<CalendarBean> consultarDatosFechas(String claveUsuario) {
	    List<CalendarBean> resultados = new ArrayList<>();

	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");

	        try (java.sql.Connection conexion = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA)) {
	            // Assuming usuario.id is the correct ID column for users
	            // Retrieve the professor's ID based on the user's ID
	            String sqlProfesorId = "SELECT profesor.id_usuario FROM usuario JOIN profesor ON usuario.id = profesor.id_usuario WHERE usuario.id = ?";

	            try (PreparedStatement preparedStatementProfesorId = conexion.prepareStatement(sqlProfesorId)) {
	                preparedStatementProfesorId.setString(1, claveUsuario);

	                try (ResultSet resultSetProfesorId = preparedStatementProfesorId.executeQuery()) {
	                    if (resultSetProfesorId.next()) {
	                        int idProfesor = resultSetProfesorId.getInt("id_usuario");

	                        // Now retrieve assignments based on the professor's ID
	                        String sqlAsignacion = "SELECT asignacion.titulo, asignacion.fecha_creacion, asignacion.fechaVencimiento " +
	                                "FROM asignacion " +
	                                "WHERE asignacion.grupo_id IN (SELECT grupo.id FROM grupo WHERE grupo.profesor_id = ?)";

	                        try (PreparedStatement preparedStatementAsignacion = conexion.prepareStatement(sqlAsignacion)) {
	                            preparedStatementAsignacion.setInt(1, idProfesor);

	                            try (ResultSet resultSetAsignacion = preparedStatementAsignacion.executeQuery()) {
	                                while (resultSetAsignacion.next()) {
	                                    String titulo = resultSetAsignacion.getString("titulo");
	                                    Date fechaCreacion = resultSetAsignacion.getDate("fecha_creacion");
	                                    Date fechaVencimiento = resultSetAsignacion.getDate("fechaVencimiento");
	                                    System.out.println("SQL Asignacion: " + sqlAsignacion);
	                                    System.out.println("SQL RESULTADO: " + titulo+fechaCreacion+fechaVencimiento);
	                                    CalendarBean vis = new CalendarBean(titulo, fechaCreacion, fechaVencimiento);
	                                    resultados.add(vis);
	                                }
	                            }
	                        }
	                    }
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    }

	    return resultados;
	}
	
	public static void insertarUsuario(Usuario usuario) {
        try (java.sql.Connection conexion = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA)) {
            String query = "INSERT INTO usuario (nombre, correo, rol, contraseña) VALUES (?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
                preparedStatement.setString(1, usuario.getNombre());
                preparedStatement.setString(2, usuario.getCorreo());
                preparedStatement.setString(3, usuario.getRol());
                preparedStatement.setString(4, usuario.getContraseña());
                preparedStatement.executeUpdate();

                System.out.println("Datos insertados en la tabla Usuario");

                if (usuario.getRol().equals("profesor")) {
                    String num_p = JOptionPane.showInputDialog("Ingrese el numero de profesor");
                    String query2 = "INSERT INTO profesor (id_usuario, no_profesor) VALUES (LAST_INSERT_ID(), ?);";
                    PreparedStatement preparedStatement2 = conexion.prepareStatement(query2);
                    preparedStatement2.setString(1, num_p);
                    preparedStatement2.executeUpdate();
                    System.out.println("Datos insertados en la tabla profesor");
                }
                if (usuario.getRol().equals("alumno")) {
                    String num_c = JOptionPane.showInputDialog("Ingrese el numero de control");
                    String query2 = "INSERT INTO alumno (id_usuario, numero_control) VALUES (LAST_INSERT_ID(), ?);";
                    PreparedStatement preparedStatement2 = conexion.prepareStatement(query2);
                    preparedStatement2.setString(1, num_c);
                    preparedStatement2.executeUpdate();
                    System.out.println("Datos insertados en la tabla alumno");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	public static List<Asignacion> mostrarAsignaciones(String id_usuario) {
        List<Asignacion> asignaciones = new ArrayList<>();
        try (java.sql.Connection conexion = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA)) {
            String query = "SELECT asignacion.* FROM asignacion JOIN alumno_asignacion ON asignacion.id = alumno_asignacion.asignacion_id WHERE alumno_asignacion.alumno_id = ?";
            try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
                // Agregar el valor del ID del alumno
                preparedStatement.setString(1, id_usuario);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        String titulo = resultSet.getString("titulo");
                        String descripcion = resultSet.getString("descripcion");
                        String estado = resultSet.getString("estado");
                        String grupoID = resultSet.getString("grupo_id");
                        String actividadID = resultSet.getString("actividad_id");
                        String calificacion = resultSet.getString("calificacion");
                        Date fechaCreacion = resultSet.getDate("fecha_creacion");
                        Date fechaVencimiento = resultSet.getDate("fecha_vencimiento");

                        Asignacion asignacion = new Asignacion(titulo, descripcion, estado, grupoID, actividadID, calificacion, fechaCreacion, fechaVencimiento);
                        asignaciones.add(asignacion);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return asignaciones;
    }
	
	public static void crearMateria(Materia materia) {
        try (java.sql.Connection conexion = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA)) {
            String query = "INSERT INTO materia (clave, nombre, unidades) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
                preparedStatement.setString(1, materia.getClave());
                preparedStatement.setString(2, materia.getNombre());
                preparedStatement.setInt(3, materia.getUnidades());
                preparedStatement.executeUpdate();

                System.out.println("Datos insertados en la tabla Materia");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void eliminarMateria(Materia materia) {
        try (java.sql.Connection conexion = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA)) {
            String query = "DELETE FROM materia WHERE clave = ?";
            try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
                preparedStatement.setString(1, materia.getClave());
                int filasAfectadas = preparedStatement.executeUpdate();

                if (filasAfectadas > 0) {
                    System.out.println("Materia eliminada con clave: " + materia.getClave());
                } else {
                    System.out.println("No se encontró ninguna materia con la clave: " + materia.getClave());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	

	
}
