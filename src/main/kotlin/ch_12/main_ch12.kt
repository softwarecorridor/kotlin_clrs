package ch_12

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

    tree.left!!.parent = tree
    tree.right!!.parent = tree
    tree.right!!.right!!.parent = tree.right
    tree.left!!.left!!.parent = tree.left
    tree.left!!.right!!.parent = tree.left

    val result = findSuccessor(tree.left!!.left!!)
    print(result)
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

fun iterativeTreeSearch(node: Node?, searchValue: Int): Node? {
    var currentNode = node
    while (currentNode != null && searchValue != currentNode.value) {
        currentNode = if (searchValue < currentNode.value!!) {
            currentNode.left
        } else {
            currentNode.right
        }
    }
    return currentNode
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

// 12.1-4
fun recursiveTreeWalkPreorder(node: Node?) {
    if (node != null) {
        print(node.value)
        recursiveTreeWalkPreorder(node.left)
        recursiveTreeWalkPreorder(node.right)
    }
}

fun recursiveTreeWalkPostorder(node: Node?) {
    if (node != null) {
        recursiveTreeWalkPostorder(node.left)
        recursiveTreeWalkPostorder(node.right)
        print(node.value)
    }
}

fun treeMin(node: Node): Node {
    var currentNode = node
    while (currentNode.left != null) {
        currentNode = currentNode.left!!
    }
    return currentNode
}

fun treeMax(node: Node): Node {
    var currentNode = node
    while (currentNode.right != null) {
        currentNode = currentNode.right!!
    }
    return currentNode
}

fun findSuccessor(node: Node) : Node? {
    if (node.hasRight()) {
        return treeMin(node.right!!)
    } else {
//        go up tree  until we encounter a node that is the left child of its parent
        var currentNode = node.parent
        var prevNode = node


        while (currentNode != null && prevNode == currentNode.right) {
            prevNode = currentNode
            currentNode = currentNode.parent
        }
        return currentNode
    }
}