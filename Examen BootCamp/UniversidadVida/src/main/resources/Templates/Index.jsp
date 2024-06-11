<!DOCTYPE html>
<html>
<head>
    <title>Acceso a Notas</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
    <div class="container">
        <h1>Acceso a Notas de la Universidad</h1>
        <form action="student_grades.jsp" method="get">
            <label for="studentId">ID del Estudiante:</label>
            <input type="text" id="studentId" name="studentId" required>
            <button type="submit">Ver Notas</button>
        </form>
    </div>
</body>
</html>
