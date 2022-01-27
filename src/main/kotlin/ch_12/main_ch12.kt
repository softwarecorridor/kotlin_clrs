package ch_12

fun main(args: Array<String>) {
    val tree = initTree()
    tree.inorderWalkIterative()

    val nodeToDelete = tree.searchIterative(2)
    if (nodeToDelete != null) {
        tree.delete(nodeToDelete)
        println("delete")
        tree.inorderWalkIterative()
    }
}

private fun initTree(): Tree {
    val result = Tree()
    val input = intArrayOf(6, 5, 7, 2, 5, 8)
    for (value in input) {
        val nodeToInsert = Node()
        nodeToInsert.value = value
        result.insert(nodeToInsert)
    }
    return result
}
