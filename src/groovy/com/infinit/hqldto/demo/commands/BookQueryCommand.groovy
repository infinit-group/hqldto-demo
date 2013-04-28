package com.infinit.hqldto.demo.commands

import grails.validation.Validateable

/**
 * Command Object used to query books
 */
@Validateable
class BookQueryCommand {

	String author

	static constraints = {
		author nullable: false, blank: false
	}
}
