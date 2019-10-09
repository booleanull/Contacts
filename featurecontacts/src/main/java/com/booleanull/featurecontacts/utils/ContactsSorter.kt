package com.booleanull.featurecontacts.utils

import com.booleanull.core.data.Contact

object ContactsSorter {

    fun sortListAscending(list: MutableList<Contact>): List<Contact> {
        list.sortBy { it.name }
        return list
    }

    fun sortListDescending(list: MutableList<Contact>): List<Contact> {
        return sortListAscending(list).reversed()
    }
}