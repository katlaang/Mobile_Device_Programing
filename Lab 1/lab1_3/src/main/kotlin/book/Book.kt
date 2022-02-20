package book

open class Book(
    var title: String? = null,
    var author: String? = null,
    var price: Double? = null

) {

    open fun read() {
        println("Reading Paper book")
    }


}


class Ebook(title: String?, author: String?, price: Double?, var filetype: String) : Book(
    title, author, price
) {
    override fun read() {
        println("Read from Electronic Device")
    }


}

fun main(args: Array<String>) {
    val b1 = Book("Joe", "Eunice", 10.23)
    val b2 = Ebook("java", "John D.", 200.00, "pdf")
    println("reading $b1 ")

    b1.read()
    println(b1.title)
    println(b2.title)
    b1.author="John"
    b2.read()

}

