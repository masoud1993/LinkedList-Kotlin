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

    fun nodeAt(index : Int): Node<T>?{
        var currentNode = head
        var currentIndex = 0

        while (currentNode != null && currentIndex < index){
            currentNode = currentNode.next
            currentIndex++
        }

        return currentNode
    }

    fun insert(value: T, afterNode: Node<T>) : Node<T> {
        if (tail == afterNode){
            append(value)
            return tail!!
        }

        val newNode = Node(value,afterNode.next)
        afterNode.next = newNode
        size++
        return newNode
    }

    fun pop() : T?{
        if (!isEmpty())
            size--
        val result = head?.value
        head = head?.next

        if (isEmpty())
            tail = null
        return result
    }

    fun removeLast() : T? {
        val head = head ?: return null

        if (head.next == null) return pop()
        size--

        var current = head

        while (current.next != tail){
            current = current.next!!
        }

        val last = current.next

        current.next = null
        tail = current

        return last!!.value
    }

}