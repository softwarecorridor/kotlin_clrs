package ch_12

import kotlin.collections.ArrayDeque

fun main(args: Array<String>) {
    val tree = Node()
    tree.value = 6
    tree.left = Node()
    tree.left!!.value = 5
    tree.right = Node()
    tree.right!!.value = 7
    tree.left!!.left = Node()
    tree.left!!.left!!.value = 2
    tree.left!!.right = Node()
    tree.left!!.right!!.value = 5
    tree.right!!.right = Node()
    tree.right!!.right!!.value = 8
//    recursiveTreeWalkInorder(tree)
    iterativeTreeWalkInorder(tree)
}


fun treeSearch(node: Node?, searchValue: Int): Node? {
    if (node == null || searchValue == node.value) {
        return node
    }
    return if (searchValue < node.value!!) {
        treeSearch(node.left, searchValue)
    } else {
        treeSearch(node.right, searchValue)
    }

}

fun recursiveTreeWalkInorder(node: Node?) {
    if (node != null) {
        recursiveTreeWalkInorder(node.left)
        print(node.value)
        recursiveTreeWalkInorder(node.right)
    }
}

// 12.1-3 - stack
fun iterativeTreeWalkInorder(node: Node?) {
    if (node != null) {
        val stack = ArrayDeque<Node>()
        stack.addFirst(node)
        while (stack.first().hasLeft()) {
            stack.addFirst(stack.first().left!!)
        }

        while (!stack.isEmpty()) {
            val currentNode = stack.removeFirst()
            print(currentNode.value)
            if (currentNode.hasRight()) {
                stack.addFirst(currentNode.right!!)
                while (stack.first().hasLeft()) {
                    stack.addFirst(stack.first().left!!)
                }
            }
        }
    }
}
