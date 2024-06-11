import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            // Conexión a la base de datos
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/tu_base_de_datos", "usuario", "contraseña");

            // Creación de un statement
            Statement stmt = con.createStatement();

            // Ejecución de una consulta SQL
            ResultSet rs = stmt.executeQuery("SELECT * FROM Alumnos");

            // Procesamiento de los resultados
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                List<Curso> cursos = obtenerCursos(id, con);

                Alumno alumno = new Alumno(id, nombre, cursos);
                ValidacionNotas validacionNotas = new ValidacionNotasImpl();
                ValidacionCupos validacionCupos = new ValidacionCuposImpl();

                for (Curso curso : cursos) {
                    if (validacionNotas.aproboCurso(alumno, curso)) {
                        System.out.println("El alumno " + nombre + " aprobó el curso " + curso.getNombre());
                    }

                    if (validacionCupos.necesitaNuevaSeccion(curso)) {
                        System.out.println("El curso " + curso.getNombre() + " necesita una nueva sección");
                    }
                }
            }

            // Cierre de la conexión
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static List<Curso> obtenerCursos(int alumnoId, Connection con) throws Exception {
        List<Curso> cursos = new ArrayList<>();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Cursos WHERE alumno_id = " + alumnoId);

        while (rs.next()) {
            int id = rs.getInt("id");
            String nombre = rs.getString("nombre");
            double nota = rs.getDouble("nota");
            cursos.add(new Curso(id, nombre, nota));
        }

        return cursos;
    }
}
