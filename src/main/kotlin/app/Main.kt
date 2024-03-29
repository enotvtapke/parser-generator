package app

import generator.Generator
import java.io.File
import java.math.BigDecimal
import java.nio.file.Path

fun main() {
//    generateVarDeclarationParser()
//    parserVarDeclaration()

    generateExpressionParser()
    parseExpression()
}

private fun generateVarDeclarationParser() {
    val parserGenerator = Generator(
        grammarFile = Path.of("src/main/resources/VarDeclaration.g4"),
        outputDir = Path.of("src/main/kotlin"),
        basePackage = "varDeclaration",
    )
    parserGenerator.generate()
}

private fun generateExpressionParser() {
    val parserGenerator = Generator(
        grammarFile = Path.of("src/main/resources/Expression.g4"),
        outputDir = Path.of("src/main/kotlin"),
        basePackage = "expressionParser",
        imports = listOf(BigDecimal::class),
        contextClass = Context::class,
        contextName = "context"
    )
    parserGenerator.generate()
}

private fun parserVarDeclaration() {
    val parser = varDeclaration.Parser("var arrayOfMaps: Array<Map<Int, String>>;")
    val res = parser.varDeclaration()
    File("./varDeclaration.dot").writeText(res.toString())
}

private fun parseExpression() {
    val input = "99 / 8 // (2 * 2) // 2 + (9 // 3 - 21 / 3)"
    val parser = expressionParser.Parser(input)
    val res = parser.bin_expr(0)
    println(res.label.res)
    File("./expression.dot").writeText(res.toString())
}
