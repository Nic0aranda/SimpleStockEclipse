Feature: Buscar Usuarios.

Scenario: Buscar a un usuario por su nombre.
Given ya que estoy autenticado
And estoy en la pagina usuarios "http://localhost/control/usuarios.php"
And existen usuarios registrados
When el usuario ingresa un "<nombre>" en el buscador "//*[@id=\"q\"]"
And presione el boton buscar
Then el sistema debe mostrar a los usuarios con ese nombre

Examples:
| nombre  |
| Duoc |