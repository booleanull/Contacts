package com.booleanull.featurecontacts

import com.booleanull.core.data.Contact
import com.booleanull.featurecontacts.utils.ContactsSorter
import org.junit.Assert.assertEquals
import org.junit.Test

class ContactsSortTest {

    private val list = listOf(
        Contact(0, "BAC", "", "", null, "", "", null),
        Contact(0, "ABC", "", "", null, "", "", null),
        Contact(0, "CAB", "", "", null, "", "", null)
    )

    @Test
    fun testSortDescending() {
        val listSorted = ContactsSorter.sortListDescending(list.toMutableList())

        assertEquals(list[2], listSorted[0])
        assertEquals(list[1], listSorted[2])
        assertEquals(list[0], listSorted[1])
    }

    @Test
    fun testSortAscending() {
        val listSorted = ContactsSorter.sortListAscending(list.toMutableList())

        assertEquals(list[2], listSorted[2])
        assertEquals(list[1], listSorted[0])
        assertEquals(list[0], listSorted[1])
    }
}