package ch_12

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class TreeTest {

    private lateinit var tree: Tree

    @BeforeEach
    fun setUp() {
        tree = initTree()
    }

    private fun initTree(): Tree {
        val result = Tree()
        val input = intArrayOf(6, 5, 7, 2, 5, 8)
        for (value in input) {
            val nodeToInsert = Node()
            nodeToInsert.value = value
            result.insertRecursive(nodeToInsert)
        }
        return result
    }

    @Test
    fun searchRecursive_Present() {
        val result = tree.searchRecursive(5)!!.value
        val expected = 5
        assertEquals(expected, result)
    }

    @Test
    fun searchRecursive_NotPresent() {
        val result = tree.searchRecursive(10)
        assertNull(result)
    }

    @Test
    fun searchIterative_Present() {
        val result = tree.searchRecursive(5)!!.value
        val expected = 5
        assertEquals(expected, result)
    }

    @Test
    fun searchIterative_NotPresent() {
        val result = tree.searchRecursive(10)
        assertNull(result)
    }

    @Test
    fun getMinIterative() {
        val result = tree.getMinIterative()
        val expected = Node()
        expected.value = 2
        expected.parent = Node()
        expected.parent!!.value = 5

        assertEquals(expected, result)
    }

    @Test
    fun getMaxIterative() {
        val result = tree.getMaxIterative()
        val expected = Node()
        expected.value = 8
        expected.parent = Node()
        expected.parent!!.value = 7

        assertEquals(expected, result)
    }

    @Test
    fun getMinRecursive() {
        val result = tree.getMinRecursive()
        val expected = Node()
        expected.value = 2
        expected.parent = Node()
        expected.parent!!.value = 5

        assertEquals(expected, result)
    }

    @Test
    fun getMaxRecursive() {
        val result = tree.getMaxRecursive()
        val expected = Node()
        expected.value = 8
        expected.parent = Node()
        expected.parent!!.value = 7

        assertEquals(expected, result)
    }

    @Test
    fun findSuccessor() {
        val result = tree.findSuccessor(tree.root!!)
        val expected = Node()
        expected.value = 7
        expected.parent = Node()
        expected.parent!!.value = 6
        expected.right = Node()
        expected.right!!.value = 8

        assertEquals(expected, result)
    }

    @Test
    fun findPredecessor() {
        val node = tree.searchIterative(2)
        val result = tree.findSuccessor(node!!)
        val expected = node.parent
        expected!!.value = 7
        expected.parent = Node()
        expected.parent!!.value = 6
        expected.right = Node()
        expected.right!!.value = 8

        assertEquals(expected, result)
    }

    @Test
    fun delete() {
        val node = tree.searchIterative(2)
        tree.delete(node!!)
        val result = tree.searchRecursive(2)
        assertNull(result)

    }
}