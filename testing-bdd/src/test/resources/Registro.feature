Feature: COMO usuario
	QUIERO crear una cuenta
	PARA que mis datos sean guardados en la aplicación.

	Scenario: Registrar Usuario
		Given el sistema muestra el formulario registrar usuario
		And el usuario rellena correctamente los campos
		When el usuario hace click en el boton "Registrar"
		Then el sistema registra al usuario
		And el sistema muestra el mensaje "Usuario registrado correctamente"

	Scenario: Registrar usuario con facebook o google
		Given el usuario tiene cuentas en facebook o google
		When el usuario hace click en la opción registar con facebook o google
		Then el sistema registra al usuario
		And el sistema muestra el mensaje "Usuario registrado correctamente"

	Scenario: Usuario inica sesión
		Given el usuario no se encuentra autenticado
		And el usuario ingresa a la pantalla "Iniciar Sesión"
		When el usuario rellena los campos "Usuario" y "Contraseña" con sus credenciales de autentificación
		And el usuario selecciona el botón "Iniciar Sesión"
		Then el sistema asigna una sesión al usuario