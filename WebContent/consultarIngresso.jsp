<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="rich" uri="http://richfaces.org/rich"%>
<!DOCTYPE html>
<html>
<head>
<link href="css/estilo.css" rel="stylesheet"></link>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body class="body5">

	<f:view>

		<jsp:include page="/menu.jsp" />
		<rich:panel>
			<h1 align="center" class="titulo5">Consulta de Ingresso</h1>
			<h:form id="formConsultarIngresso">
				<center>
					<h:panelGrid columns="1">
						<h:messages />
					</h:panelGrid>

					<h:panelGrid columns="3">
						<h:outputText value="Nome:" />
						<h:inputText value="#{ingressoBacking.tipo}" maxlength="45"
							size="40" />
						<h:commandButton action="#{ingressoBacking.pesquisar}"
							value="Pesquisar Ingresso" />
					</h:panelGrid>

					<h:panelGrid columns="1" width="450">
						<rich:dataTable id="listaIngresso"
							value="#{ingressoBacking.listaIngresso}" var="ingresso"
							width="100%">
							<f:facet name="caption">
								<h:outputText value="Lista de Ingressos" />
							</f:facet>
							<f:facet name="header">
								<rich:columnGroup>
									<rich:column>
										<h:outputText value="Tipo" />
									</rich:column>
									<rich:column>
										<h:outputText value="Valor" />
									</rich:column>

									<rich:column colspan="2">
										<h:outputText value="Ações" />
									</rich:column>

								</rich:columnGroup>
							</f:facet>
							<rich:column>
								<h:outputText value="#{ingresso.tipo}" />
							</rich:column>
							<rich:column>
								<h:outputText value="#{ingresso.valorFormatado }" />
							</rich:column>

							<rich:column>
								<h:commandLink action="#{ingressoBacking.alterar}"
									value="Alterar">
									<f:setPropertyActionListener value="#{ingresso}"
										target="#{ingressoBacking.ingressoSelecionado }" />
								</h:commandLink>
							</rich:column>
							<rich:column>
								<h:commandLink action="#{ingressoBacking.excluir}"
									value="Excluir">
									<f:setPropertyActionListener value="#{ingresso}"
										target="#{ingressoBacking.ingressoSelecionado }" />
								</h:commandLink>
							</rich:column>


						</rich:dataTable>

					</h:panelGrid>
					<br />
					<h:panelGrid>
						<h:commandButton action="#{navegacaoBacking.voltar}"
							value="Voltar" styleClass="botoes5" />
					&nbsp; &nbsp;
					</h:panelGrid>
				</center>

			</h:form>
		</rich:panel>
	</f:view>
</body>
</html>