package com.bs.kotlin.playground.entities

import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.math.BigDecimal

@Entity
class BookEntity(@Id var id: String = "", var name: String = "", var pageCount: Int = 0, var authorId: String = "") {
}