class LinkedList<T> {
    private var head : Node<T>? = null
    private var tail : Node<T>? = null
    private var size = 0

    fun isEmpty() : Boolean = size == 0

    override fun toString(): String {
        return if (isEmpty()) "Empty"
        else head.toString()
    }

    fun push(value : T): LinkedList<T> {
        head = Node(value,head)
        if (tail == null)
            tail = head
        size++
        return this
    }

    fun append(value: T): LinkedList<T> {
        if (isEmpty()){
            push(value)
            return this
        }

        tail?.next = Node(value)
        tail = tail?.next
        size++
        return this
    }

}