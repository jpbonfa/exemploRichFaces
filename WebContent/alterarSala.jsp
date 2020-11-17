<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@ taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/estilo.css" rel="stylesheet"></link>s
<title>Alterar de Sala</title>
</head>
<body class="body8">
	<f:view>
		<jsp:include page="/menu.jsp" />
		<rich:panel>
			<center>
				<h1 class="titulo9">Alterar de Sala</h1>
				<h:form id="formAlterarSala">
					<h:panelGrid columns="3">
						<rich:messages />
					</h:panelGrid>

					<h:panelGrid columns="2">
						<h:outputText value="Tipo:" />
						<h:selectOneMenu value="#{salaBacking.tipo}" disabled="true">
							<f:selectItem itemValue="" itemLabel="-Selecione um tipo" />
							<f:selectItem itemValue="IMAX" itemLabel="IMAX" />
							<f:selectItem itemValue="XD" itemLabel="XD" />
							<f:selectItem itemValue="Macro XE" itemLabel="Macro XE" />
							<f:selectItem itemValue="4DX" itemLabel="4DX" />
						</h:selectOneMenu>
					</h:panelGrid>

					<h:panelGrid columns="2">
						<h:outputText value="Quantidade de Lugares:" />
						<rich:inputNumberSpinner value="#{salaBacking.lugares}"></rich:inputNumberSpinner>
					</h:panelGrid>

					<h:panelGrid columns="3">
						<h:commandButton action="#{salaBacking.salvarAlterar}" value="Salvar"  styleClass="botoes9" />
						<h:commandButton action="#{navegacaoBacking.voltar}"
							value="Voltar"  styleClass="botoes9"/>
						
					</h:panelGrid>
				</h:form>
			</center>
		</rich:panel>
	</f:view>
</body>
</html>
