import com.infinit.hqldto.demo.Author
import com.infinit.hqldto.demo.Book

class BootStrap {

	def init = { servletContext ->
		configureForDevelopment()
	}

	def destroy = {
	}

	private void configureForDevelopment() {
		// Harry Potter
		Author rowling = new Author(name: "J. K. Rowling")
		rowling.save(failOnError: true, flush: true)
		List<Book> potters = []
		potters << new Book(title: "Harry Potter and the Philosopher's Stone", year: 2001)
		potters << new Book(title: "Harry Potter and the Chamber of Secrets", year: 2002)
		potters << new Book(title: "Harry Potter and the Prisoner of Azkaban", year: 2004)
		potters << new Book(title: "Harry Potter and the Goblet of Fire", year: 2005)
		potters << new Book(title: "Harry Potter and the Order of the Phoenix", year: 2007)
		potters << new Book(title: "Harry Potter and the Half-Blood Prince", year: 2009)
		potters.each { Book potter ->
			rowling.addToBooks(potter)
			potter.save(failOnError: true, flush: true)
		}

		// Mord im Orientexpress
		Author christie = new Author(name: "Agatha Christie")
		christie.save(failOnError: true, flush: true)
		Book orientexpress = new Book(title: "Mord im Orientexpress", year: 1934)
		christie.addToBooks(orientexpress)
		orientexpress.save(failOnError: true, flush: true)
	}
}
