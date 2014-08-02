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
</head>
<body>
	<c:if test="${exception != null}">
		<div>${exception}</div>
	</c:if>

	<div>
		<fieldset>
			<legend> Ajouter/Modifier Produits</legend>

			<f:form modelAttribute="produit" action="saveProd"
				enctype="multipart/form-data">

				<table class="tabStyle1">
					<tr>
						<td>ID Produit</td>
						<td>${produit.id}<f:input type="hidden" path="id" /></td>
						<td><f:errors path="id" cssClass="errors"></f:errors></td>
					</tr>
					<tr>
						<td>Designation Produit</td>
						<td><f:input path="designation" /></td>
						<td><f:errors path="designation" cssClass="errors"></f:errors></td>
					</tr>
					<tr>
						<td>Description Produit</td>
						<td><f:textarea path="description" /></td>
						<td><f:errors path="description" cssClass="errors"></f:errors></td>
					</tr>
					<tr>
						<td>Catégorie Produit</td>
						<td><f:select path="categorie.id" items="${categories}"
								itemValue="id" itemLabel="nomCategorie" /></td>
						<td><f:errors path="categorie" cssClass="errors"></f:errors></td>
					</tr>
					<tr>
						<td>Prix Produit</td>
						<td><f:input path="prix" /></td>
						<td><f:errors path="prix" cssClass="errors"></f:errors></td>
					</tr>
					<tr>
						<td>Quantité Produit</td>
						<td><f:input path="quantite" /></td>
						<td><f:errors path="quantite" cssClass="errors"></f:errors></td>
					</tr>
					<tr>
						<td>Produit Selectionné</td>
						<td><f:checkbox  path="selectionne" /></td>
						<td><f:errors path="selectionne" cssClass="errors"></f:errors></td>
					</tr>

					<tr>
						<td>Image</td>
						<c:if test="${produit.id != null}">
							<td><img src="photoProd?idProd=${produit.id}"></td>
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
			<legend> Liste des Produits</legend>

			<table class="tabStyle1">
				<tr>
					<th>ID</th>
					<th>designation</th>
					<th>Catégorie</th>
					<th>Prix</th>
					<th>Quantite</th>
					<th>Selectionne</th>
					<th>Image</th>
				</tr>
				<c:forEach items="${produits}" var="p">
					<tr>
						<td>${p.id}</td>
						<td>${p.designation}</td>
						<td>${p.categorie.nomCategorie}</td>
						<td>${p.prix}</td>
						<td>${p.quantite}</td>
						<td>${p.selectionne}</td>
						<td><img src="photoProd?idProd=${p.id}"></td>
						<td><a href="suppProd?idProd=${p.id}">Supprimer</a></td>
						<td><a href="editProd?idProd=${p.id}">Edit</a></td>
					</tr>
				</c:forEach>

			</table>


		</fieldset>

	</div>

</body>
</html>
