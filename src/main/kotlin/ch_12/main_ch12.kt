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
    treeWalkInorder(tree)
    val returnNode = treeSearch(tree, 8)
    print(returnNode!!.value == 8)
}


fun treeSearch(node : Node?, searchValue: Int): Node? {
    if(node == null || searchValue == node.value){
        return node
    }
    return if ( searchValue < node.value!!) {
        treeSearch(node.left, searchValue)
    } else {
        treeSearch(node.right, searchValue)
    }

}

fun treeWalkInorder(node: Node?) {
    if (node != null ) {
        treeWalkInorder(node.left)
        print(node.value)
        treeWalkInorder(node.right)
    }
}
