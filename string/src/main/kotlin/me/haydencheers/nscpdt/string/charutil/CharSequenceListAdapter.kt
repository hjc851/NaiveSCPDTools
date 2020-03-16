package me.haydencheers.nscpdt.string.charutil

class CharSequenceListAdapter(val cs: CharSequence) : List<Char> {
    override val size: Int
        get() = cs.length

    override fun contains(element: Char): Boolean {
        return cs.contains(element)
    }

    override fun containsAll(elements: Collection<Char>): Boolean {
        for (element in elements) {
            if (!cs.contains(element)) return false
        }
        return true
    }

    override fun get(index: Int): Char {
        return cs.get(index)
    }

    override fun indexOf(element: Char): Int {
        return cs.indexOf(element)
    }

    override fun isEmpty(): Boolean {
        return cs.isEmpty()
    }

    override fun iterator(): Iterator<Char> {
        return cs.iterator()
    }

    override fun lastIndexOf(element: Char): Int {
        return cs.lastIndexOf(element)
    }

    override fun listIterator(): ListIterator<Char> {
        throw NotImplementedError()
    }

    override fun listIterator(index: Int): ListIterator<Char> {
        throw NotImplementedError()
    }

    override fun subList(fromIndex: Int, toIndex: Int): List<Char> {
        return cs.substring(fromIndex, toIndex).toList()
    }
}