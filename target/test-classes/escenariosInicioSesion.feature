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

#La siguiente prueba no es posible de testear en este caso de uso ya que necesita de una cuenta creada previamente en el caso de uso registro de usuario
#Scenario: Inicio de sesion con usuario creado.
#Given al navegar a la pagina de inicio de sesion "http://localhost/control/login.php?logout"
#And el usuario tiene una cuenta existente
#When coloca en el campo Usuario "<usuario>" y en campo contraseña "<password>"
#And hacer click en el boton Iniciar sesion
#Then te rediriges a la pagina "http://localhost/control/login.php?logout"

#Examples:
#| usuario | password|
#| 	  	   | 		 |

Scenario: Inicio de sesión con un usuario no existente.
Given al navegar a la pagina de inicio de sesion "http://localhost/control/login.php"
And el usuario tiene una cuenta existente
When coloca en el campo Usuario "<usuario>" y en campo contraseña "<password>"
And hacer click en el boton Iniciar sesion
Then te rediriges a la pagina "http://localhost/control/stock.php"	

Examples:
| usuario | password|
| pepito  | admin	|
