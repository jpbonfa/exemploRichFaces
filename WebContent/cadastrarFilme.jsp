
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="rich" uri="http://richfaces.org/rich"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Filme</title>
<link href="css/estilo.css" rel="stylesheet"></link>
</head>
<body class="body1">
	<f:view>
		<jsp:include page="/menu.jsp" />
		<rich:panel>

			<center>
				<h1 align="center" class="titulo1">Cadastro de Filme</h1>
				<h:form id="formCadastrarIngresso">

					<h:panelGrid columns="3">
						<rich:messages />
					</h:panelGrid>

					<h:panelGrid columns="2">
						<h:outputText value="Nome:" />
						<h:inputText value="#{filmeBacking.nome}" />
					</h:panelGrid>

					<h:panelGrid columns="2">
						<h:outputText value="Gênero:" />
						<h:selectOneMenu value="#{filmeBacking.genero}">
							<f:selectItem itemValue="" itemLabel="-Selecione um tipo" />
							<f:selectItem itemValue="Ação" itemLabel="Ação" />
							<f:selectItem itemValue="Suspense" itemLabel="Suspense" />
							<f:selectItem itemValue="Terror" itemLabel="Terror" />
							<f:selectItem itemValue="Infantil" itemLabel="Infantil" />
							<f:selectItem itemValue="Comédia" itemLabel="Comédia" />
							<f:selectItem itemValue="Animação" itemLabel="Animação" />
							<f:selectItem itemValue="Outros" itemLabel="Outros" />
						</h:selectOneMenu>

					</h:panelGrid>
					<h:panelGrid columns="2">
						<h:outputText value="Diretor:" />
						<h:inputText value="#{filmeBacking.diretor}" />
					</h:panelGrid>
<br/>
					<h:panelGrid columns="3">
						
							<h:commandButton id="btnSalvar" action="#{filmeBacking.salvar}"
								value="Salvar" styleClass="botoes1" />
						

						<h:commandButton id="btnVoltar"
							action="#{navegacaoBacking.voltar}" value="Voltar" styleClass="botoes1"/>

						<h:commandButton id="btnCancelar"
							action="#{filmeBacking.cancelar()}" value="Cancelar" styleClass="botoes1" />

					</h:panelGrid>
				</h:form>
			</center>
		</rich:panel>
	</f:view>
</body>
</html>