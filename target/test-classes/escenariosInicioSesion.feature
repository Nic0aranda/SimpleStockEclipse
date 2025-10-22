Feature: Inicio de sesión.

Scenario: Inicio de sesión funciona correctamente.
Given al navegar a la pagina de inicio de sesion "http://localhost/control/login.php?logout"
And el usuario tiene una cuenta existente
When coloca en el campo Usuario "<usuario>" y en campo contraseña "<password>"
And hacer click en el boton Iniciar sesion
Then te rediriges a la pagina "http://localhost/control/stock.php"

Examples:
| usuario | password|
| admin	  | admin   |
