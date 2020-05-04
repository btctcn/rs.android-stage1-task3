package subtask6

import java.util.HashMap

class FullBinaryTrees {
    private class Node {
        private fun ArrayList<Node?>.enqueue(node: Node?): Unit {
            add(node)
        }

        private fun ArrayList<Node?>.dequeue(): Node? {
            return removeAt(0)
        }

        var left: Node? = null
        var right: Node? = null

        override fun toString(): String {
            var sb = StringBuilder()
            sb.append("[")
            var array = ArrayList<Node?>()
            array.enqueue(this)
            var curr: Node? = null

            while (array.count() > 0) {
                curr = array.dequeue()
                if (sb.length > 1) {
                    sb.append(",")
                }
                sb.append(if (curr != null) "0" else "null")

                if (curr != null) {
                    array.enqueue(curr.left)
                    array.enqueue(curr.right)
                }
            }
            var lastZeroIndex = sb.lastIndexOf("0")
            var result = sb.substring(0, lastZeroIndex+1)
            sb = StringBuilder(result)
            sb.append("]")
            return sb.toString();
        }
    }

    // TODO: Complete the following function
    fun stringForNodeCount(count: Int): String {
        if (count % 2 == 0) return "[]"

        var trees = buildTrees(count)
        var result = StringBuilder("[")
        for (tree in trees) {
            result.append(tree.toString())
        }
        result.append("]")
        return result.toString()
    }

    private fun buildTrees(count: Int): ArrayList<Node> {
        var treeCache = HashMap<Int, ArrayList<Node>>()
        if (treeCache[count] == null) {
            var trees = ArrayList<Node>()
            if (count == 1) {
                trees.add(Node())
            } else if (count % 2 == 1) {
                for (i in 0..count - 1) {
                    var j = count - 1 - i
                    for (left in buildTrees(i)) {
                        for (right in buildTrees(j)) {
                            var node = Node()
                            node.left = left
                            node.right = right
                            trees.add(node)
                        }
                    }
                }
            }
            treeCache[count] = trees
        }
        return treeCache[count]!!
    }
}
