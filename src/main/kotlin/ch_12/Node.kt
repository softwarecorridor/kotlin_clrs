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
        return (other is Node) && (other.left == left) && (other.right == right) && (other.parent == parent)
    }
}