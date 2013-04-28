package com.infinit.hqldto.demo

class Book {

	String title
	Integer year

	static belongsTo = [author: Author]

	static constraints = {
		title nullable: false, blank: false
		year nullable: false
	}

}
