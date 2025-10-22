Feature: BuscarInventario

Scenario: Buscar producto por Nombre
Given ya autenticado
And hay productos existentes
When hago click en el buscador "//*[@id=\"q\"]"
And escribo el nombre del producto
Then aparecen productos en la lista "//*[@id=\"datos\"]/div[3]/div/div[1]/span[1]/strong"

Scenario: Buscar producto por parte del Nombre
Given ya autenticado
And hay productos existentes
When hago click en el buscador "//*[@id=\"q\"]"
And escribo parte del nombre del producto
Then aparecen productos en la lista "//*[@id=\"datos\"]/div[3]/div/div[1]/span[1]/strong"

Scenario: Buscar producto por ID
Given ya autenticado
And hay productos existentes
When hago click en el buscador "//*[@id=\"q\"]"
And escribo el ID del producto
Then aparecen productos en la lista "//*[@id=\"datos\"]/div[3]/div/div[1]/span[1]/strong"

Scenario: Buscar producto por Nombre en categoria correcta
Given ya autenticado
And hay productos existentes
When presiono el boton categoria "//*[@id=\"id_categoria\"]"
And selecciono una de las opciones disponibles "//*[@id=\"id_categoria\"]/option[3]"
And hago click en el buscador "//*[@id=\"q\"]"
And escribo el nombre del producto
Then aparecen productos en la lista "//*[@id=\"datos\"]/div[3]/div/div[1]/span[1]/strong"

Scenario: Buscar producto por Nombre en categoria incorrecta
Given ya autenticado
And hay productos existentes
When presiono el boton categoria "//*[@id=\"id_categoria\"]"
And selecciono una de las opciones disponibles incorrecta "//*[@id=\"id_categoria\"]/option[2]"
And hago click en el buscador "//*[@id=\"q\"]"
And escribo el nombre del producto
Then no aparecen productos en lista "//*[@id=\"datos\"]/div[3]/div/div[1]/span[1]/strong"


