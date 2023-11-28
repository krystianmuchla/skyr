package com.example.skyr.pagination

import com.example.skyr.pagination.api.PaginationRequest

class Pagination(pageNumber: Int = DEFAULT_PAGE_NUMBER, pageSize: Int = DEFAULT_PAGE_SIZE) {

    companion object {
        const val MIN_PAGE_NUMBER = 1
        const val DEFAULT_PAGE_NUMBER = 1
        const val MIN_PAGE_SIZE = 1
        const val MAX_PAGE_SIZE = 1000
        const val DEFAULT_PAGE_SIZE = 20
    }

    val pageNumber: Int
    val pageSize: Int

    init {
        if (pageNumber < MIN_PAGE_NUMBER) {
            throw IllegalArgumentException("Page number exceeded min length of $MIN_PAGE_NUMBER")
        }
        if (pageSize < MIN_PAGE_SIZE) {
            throw IllegalArgumentException("Page size exceeded min length of $MIN_PAGE_SIZE")
        }
        if (pageSize > MAX_PAGE_SIZE) {
            throw IllegalArgumentException("Page size exceeded max length of $MAX_PAGE_SIZE")
        }
        this.pageNumber = pageNumber
        this.pageSize = pageSize
    }
}

fun pagination(paginationRequest: PaginationRequest): Pagination {
    return Pagination(paginationRequest.pageNumber, paginationRequest.pageSize)
}