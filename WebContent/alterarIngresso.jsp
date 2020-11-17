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
<title>Alterar de Ingresso</title>
<link href="css/estilo.css" rel="stylesheet"></link>
</head>
<body class="body9">
	<f:view>
		<jsp:include page="/menu.jsp" />
		<rich:panel>
			<center>
				<h1 align="center" class="titulo8">Alterar de Ingresso</h1>
				<h:form id="formAlterarIngresso">

					<h:panelGrid columns="1">
						<h:messages />
					</h:panelGrid>

					<h:panelGrid columns="2">
						<h:outputText value="Tipo:" />
						<h:selectOneRadio value="#{ingressoBacking.tipo}"  disabled="true">
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

					<h:commandButton action="#{ingressoBacking.salvarAlterar}" value="Salvar" styleClass="botoes8"/>
					&nbsp; &nbsp;
					<h:commandButton action="#{navegacaoBacking.voltar}" value="Voltar" styleClass="botoes8"/>
					&nbsp; &nbsp;
					
				</h:form>
			</center>
		</rich:panel>
	</f:view>


</body>
</html>