Feature: COMO usuario y administrador
	QUIERO ver los productos por categoría
	PARA llegar más rápido hacie el producto a comprar

	Scenario: Ver productos
		Given el sistema muestra las categorías en la sección de productos
		And el usuario selecciona una categoría
		When el usuario el botón "Filtrar"
		Then el sistema muestra los productos filtrados

	Scenario: Buscar productos
		Given el sistema muestra la sección "Buscar" en el dashboard de la aplicación
		And el usuario ingresa el nombre del producto en el campo de busqueda
		When el usuario selecciona el botón "Buscar"
		Then el sistema muestra los productos que coinciden con el nombre del producto ingresado
		And el sistema muestra el número de resultados en la parte inferior de los productos listados

	Scenario: Ver detalle de producto
		Given el sistema muestra los productos en la sección de busqueda
		When el usuario selecciona el botón "Ver detalle" en el card del producto
		Then el sistema abre una ventana modal con los detalles del producto seleccionado

	Scenario: Comentar un producto
		Given el sistema muestra el formulario de comentar al final de los detalles de un producto
		And el usuario se encuentra autenticado en la aplicación
		And el usuario ingresa su comentario en el campo "Comentario"
		When el usuario selecciona el botón "Enviar Comentario"
		Then el sistema envía el comentario
		And el sistema muestra el mensaje "Comentario enviado con éxito"
		And el sistema limpia el formulario de la seccion de "Comentarios"

	Scenario: Promover producto
		Given el sistema muestra un botón de "Promover Producto" en el perfil del usuario
		When el usuario selecciona el botón de "Promover Producto"
		And el sistema muestra el formulario de Promover producto
		And el usuario llena correctamente los campos requeridos
		And el usuario selecciona el botón "Enviar"
		Then el sistema muesta el mensaje "Enviado con éxito"
		And el sistema limpia los campos del formulario de Promover producto
		And el sistema agrega el producto a la lista de Productos promovidos

	Scenario: Editar producto promovido
		Given el sistema muestra la lista de productos promovidos en el perfil del usuario
		When el usuario selecciona el icono de "Editar" al lado del producto
		And el sistema redirige al usuario a la pantalla de detalle de producto promovido
		And el usuario llena los campos editables correctamente
		And el usuario selecciona el botón "Guardar"
		Then el sistema muestra un mensaje "Guardado con éxito"

	Scenario: Eliminar producto promovido
		Given el sistema muestra la lista de productos promovidos en el perfil del usuario
		When el usuario selecciona el icono "Eliminar" al lado del producto promovido
		And el sistema abre un cuadro de diálogo solicitando la confirmación de elimnación
		And el usuario confirma la eliminación
		Then el sistema muestra un mensaje "Eliminado con éxito"

	Scenario: Ver detalle de producto promovido
		Given el sistema muestra la lista de productos promovidos en el perfil del usuario
		When el usuario selecciona el botón del titulo del producto promovido
		Then el sistema redirige al usuario a la pantalla de detalle del producto promovido seleccionado

	Scenario: Notificar producto promovido
		Given el producto promovido a alcanzado los votos mínimos
		And el sistema envía una notificación o correo al usuario
		When el usuario selecciona el icono de notificación o correo
		Then el sistema redirige al usuario a la página de detalle del producto promovido