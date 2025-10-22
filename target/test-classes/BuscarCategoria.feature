Feature: BuscarCategoria

Scenario: Buscar Categoria por Nombre
Given dado que ya estoy autenticado navego a la pagina Inventario "http://localhost/control/stock.php"
And hay categorias existentes
When presiono el boton "//*[@id=\"id_categoria\"]"
And selecciono una de las opciones disponibles en "//*[@id=\"id_categoria\"]"
Then aparece un producto en la lista "//*[@id=\"datos\"]/div[3]/div/div[1]"

