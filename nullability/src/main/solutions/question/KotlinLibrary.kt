package question

import library.Author
import library.Authors
import library.Catalogue
import library.Loan
import library.Loans
import library.Members

class KotlinLibrary(private val members: Members, private val catalogue: Catalogue, private val authors: Authors, private val loans: Loans) {

    fun borrow(membershipNumber: Int, isbn: String): Loan? =
        members.lookup(membershipNumber)
            ?.let(loans::lentTo)
            ?.let { current -> catalogue.lookup(isbn)?.let { it to current } }
            ?.let { (book, current) -> if (current.size > 1) null else loans.lend(membershipNumber, book) }

    fun popularYoungAuthors(): Set<Author> = members
        .flatMap { loans.lentTo(it) }
        .mapNotNull { authors.lookup(it.book.author.id) }
        .filter { it.birthYear > 1995 }
        .toSet()
}
