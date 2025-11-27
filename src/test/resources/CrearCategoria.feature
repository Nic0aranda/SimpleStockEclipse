Feature: Registro de categoria.

Scenario: Registro de categoria solo descripcion.
Given dado el usuario en la cuenta admin
And presiona el boton categorias "//*[@id=\"bs-example-navbar-collapse-1\"]/ul[1]/li[2]"
And presiona el boton nueva categoria "/html/body/div[1]/div/div[1]/div/button"
When coloca solo descripcion de categoria "/html/body/div[1]/div/div[2]/div[1]/div/div/div[2]/form/div[3]/div/textarea" 
And apreta el boton guardar categoria "/html/body/div[1]/div/div[2]/div[1]/div/div/div[3]/button[2]"
And cierra la ventana de agregar categoria "/html/body/div[1]/div/div[2]/div[1]/div/div/div[3]/button[1]"
Then categoria no esta en la lista

Scenario: Registro de categoria de manera exitosa.
Given dado el usuario en la cuenta admin
And presiona el boton categorias "//*[@id=\"bs-example-navbar-collapse-1\"]/ul[1]/li[2]"
And presiona el boton nueva categoria "/html/body/div[1]/div/div[1]/div/button"
When coloca un nombre de categoria "//*[@id=\"nombre\"]"
And coloca una descripcion de categoria "/html/body/div[1]/div/div[2]/div[1]/div/div/div[2]/form/div[3]/div/textarea" 
And apreta el boton guardar categoria "/html/body/div[1]/div/div[2]/div[1]/div/div/div[3]/button[2]"
And cierra la ventana de agregar categoria "/html/body/div[1]/div/div[2]/div[1]/div/div/div[3]/button[1]"
Then la categoria deberia verse en la tabla categorias

Scenario: Registro de categoria de solo nombre.
Given dado el usuario en la cuenta admin
And presiona el boton categorias "//*[@id=\"bs-example-navbar-collapse-1\"]/ul[1]/li[2]"
And presiona el boton nueva categoria "/html/body/div[1]/div/div[1]/div/button"
When coloca solo un nombre de categoria "//*[@id=\"nombre\"]"
And apreta el boton guardar categoria "/html/body/div[1]/div/div[2]/div[1]/div/div/div[3]/button[2]"
And cierra la ventana de agregar categoria "/html/body/div[1]/div/div[2]/div[1]/div/div/div[3]/button[1]"
Then la categoria solo nombre deberia verse en la tabla categorias

