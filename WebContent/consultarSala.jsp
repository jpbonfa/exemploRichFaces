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
<title>Insert title here</title>
</head>
<body class="body6">
	<f:view>

		<jsp:include page="/menu.jsp" />
		<rich:panel>
			<h1 align="center" class="titulo6">Consulta de Salas</h1>
			<h:form id="formConsultarSala">
				<center>
					<h:panelGrid columns="1">
						<h:messages />
					</h:panelGrid>

					<h:panelGrid columns="3">
						<h:outputText value="Tipo:" />
						<h:inputText value="#{salaBacking.tipo}" maxlength="45" size="40" />
						<h:commandButton action="#{salaBacking.pesquisar}"
							value="Pesquisar Sala" />
					</h:panelGrid>

					<h:panelGrid columns="1" width="450">
						<rich:dataTable id="listaSala" value="#{salaBacking.listaSala}"
							var="sala" width="100%">
							<f:facet name="caption">
								<h:outputText value="Lista de Salas" />
							</f:facet>

							<f:facet name="header">
								<rich:columnGroup>
									<rich:column>
										<h:outputText value="Tipo" />
									</rich:column>
									<rich:column>
										<h:outputText value="Lugares" />
									</rich:column>
									<rich:column colspan="2">
										<h:outputText value="Ações" />
									</rich:column>
								</rich:columnGroup>
							</f:facet>

							<rich:column>
								<h:outputText value="#{sala.tipo}" />
							</rich:column>
							<rich:column>
								<h:outputText value="#{sala.lugares}" />
							</rich:column>
							<rich:column>
								<h:commandLink action="#{salaBacking.alterar}" value="Alterar">
									<f:setPropertyActionListener value="#{sala}"
										target="#{salaBacking.salaSelecionada }" />
								</h:commandLink>
							</rich:column>
							<rich:column>
								<h:commandLink action="#{salaBacking.excluir}" value="Excluir">
									<f:setPropertyActionListener value="#{sala}"
										target="#{salaBacking.salaSelecionada }" />
								</h:commandLink>
							</rich:column>


						</rich:dataTable>

					</h:panelGrid>
					<br />
					<h:panelGrid>
						<h:commandButton action="#{navegacaoBacking.voltar}"
							value="Voltar" styleClass="botoes6" />
					&nbsp; &nbsp;
					</h:panelGrid>
				</center>

			</h:form>
		</rich:panel>
	</f:view>

</body>
</html>