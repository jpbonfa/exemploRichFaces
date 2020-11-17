<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="rich" uri="http://richfaces.org/rich"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cinema</title>
</head>
<body>
	<f:subview id="view">

		<h:form id="menu">

			<rich:toolBar>
				<rich:dropDownMenu value="Cadastro">
					<rich:menuItem id="menu1" value="Filme"
						action="#{filmeBacking.cadastrarFilme}" />
					<rich:menuItem id="menu2" value="Ingresso"
						action="#{ingressoBacking.cadastrarIngresso}" />
					<rich:menuItem id="menu3" value="Sala"
						action="#{salaBacking.cadastrarSala}" />

				</rich:dropDownMenu>

				<rich:dropDownMenu value="Consulta">
					<rich:menuItem id="menu4" value="Filme"
						action="#{filmeBacking.consultarFilme}" />
					<rich:menuItem id="menu5" value="Ingresso"
						action="#{ingressoBacking.consultarIngresso}" />
					<rich:menuItem id="menu6" value="Sala"
						action="#{salaBacking.consultarSala}" />

				</rich:dropDownMenu>

			</rich:toolBar>

		</h:form>

	</f:subview>

</body>
</html>