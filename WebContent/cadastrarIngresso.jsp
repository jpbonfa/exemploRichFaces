<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@ taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<!DOCTYPE html>
<html>
<head>
<link href="css/estilo.css" rel="stylesheet"></link>
<meta charset="ISO-8859-1">
<title>Cadastro de Ingresso</title>
</head>
<body class="body2">
	<f:view>
		<jsp:include page="/menu.jsp" />
		<rich:panel>
			<center>
				<h1 align="center" class="titulo2">Cadastro de Ingresso</h1>
				<h:form id="formCadastrarIngresso">

					<h:panelGrid columns="1">
						<h:messages />
					</h:panelGrid>

					<h:panelGrid columns="2">
						<h:outputText value="Tipo:" />
						<h:selectOneRadio value="#{ingressoBacking.tipo}">
							<f:selectItem itemValue="Inteira" itemLabel="Inteira" />
							<f:selectItem itemValue="Meia" itemLabel="Meia" />
							<f:selectItem itemValue="Bradesco" itemLabel="Bradesco" />
							<f:selectItem itemValue="Vivo" itemLabel="Vivo" />
						</h:selectOneRadio>
					</h:panelGrid>
					<h:panelGrid columns="2">
						<h:outputText value="Valor" />
						<rich:inputNumberSlider value="#{ingressoBacking.valor}"></rich:inputNumberSlider>

					</h:panelGrid>
					<rich:spacer height="13px" />
<br/>
					<h:commandButton action="#{ingressoBacking.salvar}" value="Salvar"  styleClass="botoes2"/>
					&nbsp; &nbsp;
					<h:commandButton action="#{navegacaoBacking.voltar}" value="Voltar" styleClass="botoes2" />
					&nbsp; &nbsp;
					<h:commandButton action="#{ingressoBacking.cancelar}"
						value="Cancelar" styleClass="botoes2"/>
				</h:form>
			</center>
		</rich:panel>
	</f:view>


</body>
</html>