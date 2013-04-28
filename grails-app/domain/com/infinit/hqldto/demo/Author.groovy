package com.infinit.hqldto.demo

class Author {

	String name

	static hasMany = [books: Book]

	static constraints = {
		name nullable: false, blank:false
	}

	String toString() {
		return name
	}
}
