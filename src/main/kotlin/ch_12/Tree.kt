package ch_12

class Tree {
    private var root: Node? = null
    
    fun searchRecursive(value: Int): Node? {
        return recursiveTreeSearch(root, value)
    }

    private fun recursiveTreeSearch(node: Node?, searchValue: Int): Node? {
        if (node == null || searchValue == node.value) {
            return node
        }
        return if (searchValue < node.value!!) {
            recursiveTreeSearch(node.left, searchValue)
        } else {
            recursiveTreeSearch(node.right, searchValue)
        }
    }

    fun searchIterative(value: Int): Node? {
        return iterativeTreeSearch(root, value)
    }

    private fun iterativeTreeSearch(node: Node?, searchValue: Int): Node? {
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

    fun inorderWalkRecursive() {
        recursiveTreeWalkInorder(root)
    }

    private fun recursiveTreeWalkInorder(node: Node?) {
        if (node != null) {
            recursiveTreeWalkInorder(node.left)
            print(node.value)
            recursiveTreeWalkInorder(node.right)
        }
    }

    fun inorderWalkIterative() {
        iterativeTreeWalkInorder(root)
    }

    // 12.1-3 - stack
    private fun iterativeTreeWalkInorder(node: Node?) {
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

    fun preorderWalkRecursive() {
        recursiveTreeWalkPreorder(root)
    }

    // 12.1-4
    private fun recursiveTreeWalkPreorder(node: Node?) {
        if (node != null) {
            print(node.value)
            recursiveTreeWalkPreorder(node.left)
            recursiveTreeWalkPreorder(node.right)
        }
    }

    fun postorderWalkRecursive() {
        recursiveTreeWalkPostorder(root)
    }

    private fun recursiveTreeWalkPostorder(node: Node?) {
        if (node != null) {
            recursiveTreeWalkPostorder(node.left)
            recursiveTreeWalkPostorder(node.right)
            print(node.value)
        }
    }

    fun getMinIterative(): Node? {
        return minIterative(root)
    }

    private fun minIterative(node: Node?): Node? {
        var currentNode = node
        if (currentNode != null) {
            while (currentNode!!.left != null) {
                currentNode = currentNode.left!!
            }
        }
        return currentNode
    }

    fun getMaxIterative(): Node? {
        return maxIterative(root)
    }

    private fun maxIterative(node: Node?): Node? {
        var currentNode = node
        if (currentNode != null) {
            while (currentNode!!.right != null) {
                currentNode = currentNode.right!!
            }
        }
        return currentNode
    }

    fun getMinRecursive(): Node? {
        return minRecursive(root)
    }

    // 12.2-2
    private fun minRecursive(node: Node?): Node? {
        if (node != null) {
            if (node.left != null) {
                return minRecursive(node.left!!)
            }
        }
        return node
    }

    fun getMaxRecursive(): Node? {
        return maxRecursive(root)
    }

    private fun maxRecursive(node: Node?): Node? {
        if (node != null) {
            if (node.right != null) {
                return maxRecursive(node.right!!)
            }
        }
        return node
    }

    fun findSuccessor(node: Node): Node? {
        if (node.hasRight()) {
            return minIterative(node.right!!)
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

    // 12.2-3
    fun findPredecessor(node: Node): Node? {
        if (node.hasLeft()) {
            return maxIterative(node.left!!)
        } else {
            var currentNode = node.parent
            var prevNode = node

            while (currentNode != null && prevNode == currentNode.left) {
                prevNode = currentNode
                currentNode = currentNode.parent
            }
            return currentNode
        }
    }

    fun insert(node: Node) {
        var prevNode: Node? = null
        var currentNode: Node? = root
        while (currentNode != null) {
            prevNode = currentNode
            if (currentNode.value!! <= node.value!!) {
                currentNode = currentNode.right
            } else {
                currentNode = currentNode.left
            }
        }
        node.parent = prevNode
        if (prevNode == null) {
            root = node
        } else if (prevNode.value!! <= node.value!!) {
            prevNode.right = node
        } else {
            prevNode.left = node
        }
    }


}