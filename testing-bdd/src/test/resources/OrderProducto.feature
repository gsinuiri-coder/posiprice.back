Feature: COMO usuario
	QUIERO ver el plazo máximo de pago de un producto
	PARA realizar la transacción a tiempo

	Scenario: Ver plazo de pago de producto
		Given el producto ha alcanzado los votos mínimos requeridos
		And el sistema envía una notificacón y correo a los usuarios involucrados
		When el usaurio selecciona la notificación o el correo recibido
		Then el sistema muestra la pantalla "Detalle del producto"
		And el sistema muestra el plazo de pago del producto
		And el sistema habilita el botón de "Comprar"

	Scenario: Pagar producto
		Given el sistema redirige al usuario al formulario de pagar hacia el sistema externo de la aplicación
		And el usuario llena correctamente los campos requeridos
		When el usuario selecciona el botón "Realizar Pago"
		Then el sistema muestra el mensaje "Pago realizado con éxito"
		And el sistema redirige al usuario a la pantalla de detalle de pago
		And el sistema agrega el producto a la lista de "Productos Comprados" del usuario

	Scenario: Ver tracking
		Given el sistema muesta el botón "Ver Tracking" en el card del producto comprado
		When el usuario selecciona el botón "Ver tracking"
		Then el sistema muestra la pantalla con los detalles del tracking del producto

	Scenario: Enviar un reclamo de producto
		Given el producto se encuentra en mal estado o no es el solicitado
		And el sistema muestra la lista de productos comprados
		When el usuario selecciona el botón "Realizar Reclamo"
		And el usuario llena el campo "Reclamo "
		And el usuario selecciona el botón "Enviar Reclamo"
		Then el sistema muestra el mensaje "Reclamo enviado con éxito"

	Scenario: Notificar llegada de producto
		Given el producto comprado a llegado a su destino
		And el sistema envía una notificación o correo al usuario
		When el usuario selecciona el icono de notificación o correo
		And el sistema redirige al usuario a la pantalla de detalle de tracking del producto
		Then el sistema muestra información de llegada del producto comprado