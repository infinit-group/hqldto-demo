package com.infinit.hqldto.demo

import com.infinit.hqldto.HqlDtoService
import com.infinit.hqldto.demo.commands.BookQueryCommand
import com.infinit.hqldto.dtos.HqlDto

class BookService {

	HqlDtoService hqlDtoService

	List<HqlDto> getBooks() {
		return this.getBooks(null)
	}

	List<HqlDto> getBooks(BookQueryCommand bookQueryCommand) {
		// initialize query variables
		Map queryParams = [:]
		String whereClause = ""

		// setup clauses
		if (bookQueryCommand) {
			whereClause = "where lower(a.name) like :authorName"
			queryParams["authorName"] = "%${bookQueryCommand.author}%"
		}

		// setup query string
		String queryString = """\
			select a.name, b.title, b.year
			from Author a
			inner join a.books b
			$whereClause
		"""

		// execute the query
		return hqlDtoService.executeDtoQuery(queryString, queryParams)
	}
}
