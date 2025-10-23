Feature: Registro de Usuarios.

Scenario: Registro de usuario con contraseña no valida.
Given dado que el usuario se encuentra en la cuenta admin
And se encuentra en la pagina usuarios "http://localhost/control/usuarios.php"
And presiona el boton "/html/body/div[1]/div/div[1]/div/button"
When coloca un nombre valido en "//*[@id=\"firstname\"]"
And coloca un apellido valido en "//*[@id=\"lastname\"]"
And coloca un usuario valido en "//*[@id=\"user_name\"]"
And coloca un email valido en "//*[@id=\"user_email\"]"
And coloca una contraseña no valida "//*[@id=\"user_password_new\"]"
And coloca denuevo la contraseña equivocada"//*[@id=\"user_password_repeat\"]"
And apreta el boton "//*[@id=\"guardar_datos\"]"
And apreta el boton "//*[@id=\"myModal\"]/div/div/div[3]/button[1]"
Then el usuario nuevo no se veria en la tabla de usuarios

Scenario: Registro de usuario de manera exitosa.
Given dado que el usuario se encuentra en la cuenta admin
And se encuentra en la pagina usuarios "http://localhost/control/usuarios.php"
And presiona el boton "/html/body/div[1]/div/div[1]/div/button"
When coloca un nombre valido en "//*[@id=\"firstname\"]"
And coloca un apellido valido en "//*[@id=\"lastname\"]"
And coloca un usuario valido en "//*[@id=\"user_name\"]"
And coloca un email valido en "//*[@id=\"user_email\"]"	
And coloca una contraseña valida "//*[@id=\"user_password_new\"]"
And coloca denuevo la contraseña "//*[@id=\"user_password_repeat\"]"
And apreta el boton "//*[@id=\"guardar_datos\"]"
Then el usuario nuevo se veria en la tabla de usuarios

Scenario: Registro de usuario campos en blanco.
Given dado que el usuario se encuentra en la cuenta admin
And se encuentra en la pagina usuarios "http://localhost/control/usuarios.php"
And presiona el boton "/html/body/div[1]/div/div[1]/div/button"
And apreta el boton "//*[@id=\"guardar_datos\"]"
#no logramos localizar el pop-up generado
Then el sistma muestra un mensaje indicando que no deben existir datos vacios
