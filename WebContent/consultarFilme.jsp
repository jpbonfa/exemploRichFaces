<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<link href="css/estilo.css" rel="stylesheet"></link>
<meta charset="ISO-8859-1">
<title>Consulta de Filme</title>
</head>
<body class="body4">
	<f:view>

		<jsp:include page="/menu.jsp" />
		<rich:panel>
			<h1 align="center" class="titulo4">Consulta de Filmes</h1>
			<h:form id="formConsultarFilme">
				<center>
					<h:panelGrid columns="1">
						<h:messages />
					</h:panelGrid>

					<h:panelGrid columns="3">
						<h:outputText value="Nome:" />
						<h:inputText value="#{filmeBacking.nome}" maxlength="45" size="40" />
						<h:commandButton action="#{filmeBacking.pesquisar}"
							value="Pesquisar Filme" />
					</h:panelGrid>

					<h:panelGrid columns="1" width="450">
						<rich:dataTable id="listaFilme" value="#{filmeBacking.listaFilme}"
							var="filme" width="100%">
							<f:facet name="caption">
								<h:outputText value="Lista de Filmes" />
							</f:facet>
							<f:facet name="header">
								<rich:columnGroup>
									<rich:column>
										<h:outputText value="Nome" />
									</rich:column>
									<rich:column>
										<h:outputText value="Gênero" />
									</rich:column>
									<rich:column>
										<h:outputText value="Diretor" />
									</rich:column>
									<rich:column colspan="2">
										<h:outputText value="Ações" />
									</rich:column>

								</rich:columnGroup>
							</f:facet>
							<rich:column>
								<h:outputText value="#{filme.nome}" />
							</rich:column>
							<rich:column>
								<h:outputText value="#{filme.genero }" />
							</rich:column>
							<rich:column>
								<h:outputText value="#{filme.diretor}" />
							</rich:column>
							<rich:column>
								<h:commandLink action="#{filmeBacking.alterar}" value="Alterar">
									<f:setPropertyActionListener value="#{filme}"
										target="#{filmeBacking.filmeSelecionado }" />
								</h:commandLink>
							</rich:column>
							<rich:column>
								<h:commandLink action="#{filmeBacking.excluir}" value="Excluir">
									<f:setPropertyActionListener value="#{filme}"
										target="#{filmeBacking.filmeSelecionado }" />
								</h:commandLink>
							</rich:column>


						</rich:dataTable>
					</h:panelGrid>
					<br/>
					<h:panelGrid>
						<h:commandButton action="#{navegacaoBacking.voltar}"
							value="Voltar" styleClass="botoes4"/>
					&nbsp; &nbsp;
					</h:panelGrid>
				</center>
			</h:form>
		</rich:panel>
	</f:view>
</body>
</html>