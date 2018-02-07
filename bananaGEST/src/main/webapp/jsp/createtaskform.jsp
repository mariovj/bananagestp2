<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- <jsp:useBean id="#" class="#" scope="request"></jsp:useBean> --%>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Banana Gest | Crear tarea</title>
		<link rel=stylesheet href="css/createtaskform.css" type="text/css">
	</head>
	<body>
		<header>
		    <p class="bananagest">BANANA GEST
            <a href="user_home.jsp"><img src="images/bananas.png" class="logo" /></a>
            </p>
            <form action="logout">
            	<div id="enviar">
					<p><input type="submit" value="Logout" /></p>
				</div>
            </form>	
		</header>
		<main>
		  <section class="seccion1">
			<form action="taskServlet" method="post">
			<label for="titulo">Título:</label>
			<input type="text" id="titulo" name="titulo" required><br />			
			<label for="fecha_inicio">Fecha inicio:</label>
			<input type="date" id="fecha_inicio" name="fecha_inicio" required><br />
			<label for="fecha_final">Fecha final:</label>
			<input type="date" id="fecha_final" name="fecha_final" required><br />
			<label for="estado">Estado:</label>	
			<select name="estado" id="estado" required>
				<option value="to do">to do</option>
				<option value="on going">on going</option>
				<option value="done">done</option>
			</select><br />
			<!-- <label for="file">Adjuntar archivo:</label><br />
			<input type="file" id="file" name="file"><br /> -->
			<label for="descripcion">Descripcion:</label><br>
			<textarea name="descripcion" id="descripcion" cols="30" rows="10"></textarea><br />
			<label for="notas">Notas:</label><br>
			<textarea name="notas" id="notas" cols="30" rows="5"></textarea><br />
			<input type="submit" value="Crear">
		   </form>	
		  </section>
		</main>
	</body>
<%@ include file="footer.jsp"%>	