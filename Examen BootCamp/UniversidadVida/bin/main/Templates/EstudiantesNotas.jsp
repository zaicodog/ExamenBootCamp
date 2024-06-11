<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Notas del Estudiante</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
    <div class="container">
        <h1>Notas del Estudiante</h1>
        <%
            String studentId = request.getParameter("studentId");
            // Simulación de datos de notas
            java.util.Map<String, java.util.Map<String, String>> studentGrades = new java.util.HashMap<>();
            java.util.Map<String, String> grades = new java.util.HashMap<>();
            grades.put("Matemáticas", "A");
            grades.put("Historia", "B+");
            grades.put("Ciencias", "A-");
            studentGrades.put("12345", grades);

            if(studentGrades.containsKey(studentId)) {
                out.println("<h2>ID del Estudiante: " + studentId + "</h2>");
                out.println("<table><tr><th>Materia</th><th>Nota</th></tr>");
                java.util.Map<String, String> studentSpecificGrades = studentGrades.get(studentId);
                for (java.util.Map.Entry<String, String> entry : studentSpecificGrades.entrySet()) {
                    out.println("<tr><td>" + entry.getKey() + "</td><td>" + entry.getValue() + "</td></tr>");
                }
                out.println("</table>");
            } else {
                out.println("<p>No se encontraron notas para el ID del estudiante: " + studentId + "</p>");
            }
        %>
        <a href="index.jsp">Volver</a>
    </div>
</body>
</html>
