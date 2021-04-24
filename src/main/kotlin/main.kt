data class Recipe (
    val name: String = "",
    val ingredientes: MutableList<String> = mutableListOf()
)

fun main(args: Array<String>) {
    val title: String = ":: Bienvenidos a Recipe Maker"
    val description: String = "Selecciona la opción deseada"
    val option1: String = "1. Hacer una receta"
    val option2: String = "2. Ver mis recetas"
    val option3: String = "3. Salir"
    val waitForResponse: String = "Ingrese una resupuesta: "
    var recipesList: MutableList<Recipe> = mutableListOf()

    do {
        showProgram(listOf(title, description, option1, option2, option3))
        print(waitForResponse)
        val response: String? = readLine()
        when (response) {
            "1" -> recipesList.add(doRecipe())
            "2" -> showRecipes(recipesList)
            else -> println("Adiós!!!")
        }
    } while (!response.equals("3"))
}

fun showProgram(texts: List<String>) {
    println() // margin
    for (text in texts) {
        println(text)
    }
}

fun doRecipe(): Recipe {
    val message1: String = "Ingres un nombre para la receta: "
    val message2: String = "A continuación se muestran todos los ingredientes disponibles:"
    val message3: String = "Seleccione el número de un ingrediente: "
    val ingredientesAvailables: List<String> = listOf("Agua", "Leche", "Carne", "Verduras", "Frutas", "Cereal", "Huevos", "Aceite")
    val ingredientesList: MutableList<String> = mutableListOf()

    print(message1)
    val name: String = readLine() ?: ""
    println(message2)
    do {
        showIngredientesAvailables(ingredientesAvailables)
        print(message3)
        val ingredienteSelected: String? = readLine()
        if (!ingredienteSelected.equals("0")) {
            val index = ingredienteSelected?.toInt()?.minus(1) ?: 0

            ingredientesList.add(ingredientesAvailables[index])
            println(ingredientesList.size)
        }
    } while (!ingredienteSelected.equals("0"))
    return Recipe(name, ingredientesList)
}

fun showIngredientesAvailables(ingredientes: List<String>) {
    for ((index, ingrediente) in ingredientes.withIndex()) {
        println("${index.plus(1)}. $ingrediente")
    }
    println("0. Salir")
}

fun showRecipes(recipesList: MutableList<Recipe>) {
    val message1: String = "Lista de recetas"
    val padding: String = "---"
    println(message1)

    for (recipe in recipesList) {
        println()// margin
        println("Nombre de la receta: ${recipe.name}")
        for (ingrediente in recipe.ingredientes) {
            println("$padding $ingrediente")
        }
    }
}