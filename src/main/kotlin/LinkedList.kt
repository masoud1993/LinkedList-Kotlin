class LinkedList<T> {
    private var head : Node<T>? = null
    private var tail : Node<T>? = null
    private var size = 0

    fun isEmpty() : Boolean = size == 0

    override fun toString(): String {
        return if (isEmpty()) "Empty"
        else head.toString()
    }

}