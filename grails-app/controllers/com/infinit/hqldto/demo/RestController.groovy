package com.infinit.hqldto.demo

import com.infinit.hqldto.demo.commands.BookQueryCommand
import grails.converters.JSON

import javax.servlet.http.HttpServletResponse

class RestController {

	BookService bookService

    def index() {
	    redirect action: "list"
    }

	def list() {
		String
		render bookService.getBooks() as JSON
	}

	def show(BookQueryCommand cmd) {
		if (cmd.hasErrors()) {
			log.debug('Unable to validate request: ' + cmd.errors)
			render(contentType:'text/json', status: HttpServletResponse.SC_BAD_REQUEST) { cmd.errors }
			return
		}
		render bookService.getBooks(cmd) as JSON
	}

}
