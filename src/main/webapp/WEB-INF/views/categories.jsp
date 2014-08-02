<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<!-- CSS -->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/style.css">
<!-- JS -->
<%-- <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/script.js"></script> --%>
</head>
<body>
	<c:if test="${exception != null}">
		<div>${exception}</div>
	</c:if>

	<div>
		<fieldset>
			<legend> Ajouter/Modifier Catégorie</legend>

			<f:form modelAttribute="categorie" action="saveCat"
				enctype="multipart/form-data">

				<table class="tabStyle1">
					<tr>
						<td>ID Catégorie</td>
						<td>${categorie.id}<f:input type="hidden" path="id" /></td>
						<td><f:errors path="id" cssClass="errors"></f:errors></td>
					</tr>
					<tr>
						<td>Nom Catégorie</td>
						<td><f:input path="nomCategorie" /></td>
						<td><f:errors path="nomCategorie" cssClass="errors"></f:errors></td>
					</tr>
					<tr>
						<td>Description Catégorie</td>
						<td><f:textarea path="description" /></td>
						<td><f:errors path="description" cssClass="errors"></f:errors></td>
					</tr>
					<tr>
						<td>Image</td>
						<c:if test="${categorie.id != null}">
							<td><img src="photoCat?idCat=${categorie.id}"></td>
						</c:if>
						<td><input type="file" name="file" /></td>
					</tr>
					<tr>
						<td><input type="submit" value="Save"></td>
					</tr>

				</table>
			</f:form>

		</fieldset>

	</div>

	<!--  end of  form  : save/edit  -->

	<div>

		<fieldset>
			<legend> Liste des Catégories</legend>

			<table class="tabStyle1">
				<tr>
					<th>ID</th>
					<th>Nom</th>
					<th>Description</th>
					<th>Image</th>
				</tr>
				<c:forEach items="${categories}" var="c">
					<tr>
						<td>${c.id}</td>
						<td>${c.nomCategorie}</td>
						<td>${c.description}</td>
						<td><img alt="pas de photo" src="photoCat?idCat=${c.id}"></td>
						<td><a href="suppCat?idCat=${c.id}">Supprimer</a></td>
						<td><a href="editCat?idCat=${c.id}">Edit</a></td>
					</tr>
				</c:forEach>

			</table>


		</fieldset>

	</div>

</body>
</html>
