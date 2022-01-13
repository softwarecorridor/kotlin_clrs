package ch_12

class Node {
    var left : Node? = null
    var right : Node? = null
    var value : Int? = null

    fun hasRight() : Boolean {
        return right != null
    }

    fun hasLeft(): Boolean {
        return left != null
    }
}