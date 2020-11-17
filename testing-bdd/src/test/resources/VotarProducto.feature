Feature: COMO usuario
	QUIERO votar por un producto
	PARA comprarlo cuando llegue al puntaje requerido

	Scenario: Ingresar voto a un producto
		Given el sistema muestra en el card del producto y en el perfil un icono votar
		And el usuario se encuentra autenticado en la aplicación
		When el usuario hace click en el icono "Votar"
		Then el sistema valida mi voto
		And el sistema muestra el mensaje "Producto votado con éxito"
		And el sistema cambia a color verde el marco del card del producto votado

	Scenario: Eliminar voto de un producto
		Given el sistema muestra en el card del producto y en el perfil un icono votar
		And el usuario se encuentra autenticado en la aplicación
		When el usuario hace click en el icono "Eliminar Voto"
		Then el sistema valida mi petición
		And el sistema muestra el mensaje "Voto eliminado con éxito"
		And el sistema cambia a color predeterminado el marco del card del producto votado

	Scenario: Ver productos votados
		Given el sistema muestra la sección de "Productos Votados" en el perfil del usuario
		When el usuario hace click en la sección "Productos votados"
		Then el sistema muestra una lista de productos votados y los iconos "Ver detalle" y "Quitar Voto"

	Scenario: Notificar producto votado
		Given el sistema muestra las notificaciones en la seccion "Notificaciones
		And el usuario se encuentra autenticado en la aplicación
		And el sistema muestra notificaciones sin leer en la sección de "Notificaciones"
		When el usuario selecciona las notificaciones
		Then el sistema muestra las notificaciones
		And el usuario revisa las notificaciones acerca del producto que obtuvo los votos requeridos