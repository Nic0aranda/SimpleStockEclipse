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

Scenario: Inicio de sesion utilizando usuario correcto pero contraseña incorrecta.
Given al navegar a la pagina de inicio de sesion "http://localhost/control/login.php?logout"
And el usuario tiene una cuenta existente
When coloca en el campo Usuario "<usuario>" y en campo contraseña "<password>"
And hacer click en el boton Iniciar sesion
Then te rediriges a la pagina "http://localhost/control/login.php"

Examples:
| usuario | password|
| admin	  | admin123|

Scenario: Intento de inicio de sesion con campos en blanco.
Given al navegar a la pagina de inicio de sesion "http://localhost/control/login.php?logout"
And el usuario tiene una cuenta existente
When coloca en el campo Usuario "<usuario>" y en campo contraseña "<password>"
And hacer click en el boton Iniciar sesion
Then te rediriges a la pagina "http://localhost/control/login.php?logout"

Examples:
| usuario | password|
| 	  	  | 		|


#esta prueba resulta fallida
Scenario: Inicio de sesion con usuario creado.
Given dado que el usuario ya se encuentra en la cuenta admin 
And el usuario se dirige a usuarios
And el usuario presiona el boton nuevo usuario
And el usuario llena los campos y presiona el boton guardar datos "<usuario>" "<password>"
And el usuario presiona el boton salir
When coloca en el campo Usuario "<usuario>" y en campo contraseña "<password>"
And hacer click en el boton Iniciar sesion
Then deberias estar en la pagina inicial

Examples:
| usuario | password|
| juanito | administrador |

Scenario: Inicio de sesión con un usuario no existente.
Given al navegar a la pagina de inicio de sesion "http://localhost/control/login.php"
And el usuario tiene una cuenta existente
When coloca en el campo Usuario "<usuario>" y en campo contraseña "<password>"
And hacer click en el boton Iniciar sesion
Then te rediriges a la pagina "http://localhost/control/stock.php"	

Examples:
| usuario | password|
| pepito  | admin	|
