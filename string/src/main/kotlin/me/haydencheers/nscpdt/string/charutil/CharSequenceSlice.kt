package me.haydencheers.nscpdt.string.charutil

data class CharSequenceSlice(val src: CharSequence): CharSequence {

    var offset = 0

    override val length: Int
        get() = src.length-offset

    override fun get(index: Int): Char {
        return src.get(index+offset)
    }

    override fun subSequence(startIndex: Int, endIndex: Int): CharSequence {
        return src.subSequence(startIndex+offset, endIndex+offset)
    }
}