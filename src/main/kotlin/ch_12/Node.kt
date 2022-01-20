package ch_12

class Node {
    var left: Node? = null
    var right: Node? = null
    var parent: Node? = null
    var value: Int? = null

    fun hasRight(): Boolean {
        return right != null
    }

    fun hasLeft(): Boolean {
        return left != null
    }

    fun hasParent(): Boolean {
        return parent != null
    }

    override fun equals(other: Any?): Boolean {
        val isNode = other is Node
        if (isNode) {
            val node = other as Node
            val isLeftEqual = if (!hasLeft() && !node.hasLeft()) {
                true
            } else if (hasLeft() && node.hasLeft()) {
                left!!.value == node.left!!.value
            } else {
                false
            }
            val isRightEqual = if (!hasRight() && !node.hasRight()) {
                true
            } else if (hasRight() && node.hasRight()) {
                right!!.value == node.right!!.value
            } else {
                false
            }
            val isParentEqual = if (!hasParent() && !node.hasParent()) {
                true
            } else if (hasParent() && node.hasParent()) {
                parent!!.value == node.parent!!.value
            } else {
                false
            }
            return isLeftEqual && isRightEqual && isParentEqual
        }

        return false

    }
}