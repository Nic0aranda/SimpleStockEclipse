Feature: BuscarCategoria

Scenario: Buscar Categoria por Nombre
Given una vez autenticado
And hay categorias existentes
When presiono el boton "//*[@id=\"id_categoria\"]"
And selecciono una de las opciones disponibles en "//*[@id=\"id_categoria\"]/option[3]"
Then aparece un producto en la lista "/html/body/div[1]"

Scenario: Buscar Categoria por Descripcion
Given una vez autenticado
And hay categorias existentes
When presiono el buscador "//*[@id=\"q\"]"
And escribo la descripcion de la categoria
Then no aparecen productos "//*[@id=\"datos\"]/div[3]/div/div[3]"

Scenario: Buscar Categoria por fecha de agregado
Given una vez autenticado
And hay categorias existentes
When presiono el buscador "//*[@id=\"q\"]"
And escribo la fecha de agregado de un producto
Then no aparecen productos "//*[@id=\"datos\"]/div[3]/div/div[3]"