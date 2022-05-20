package com.folioreader.util

object ReadLocatorHelper {

    /**
     * add 2 paragraphs to cfi, temporarily fix locator not right
     * cpi example: epubcfi(/0!/4/2/2[chapter_458]/4/14/1:0)
     */
    fun getTempFixedCfi(originCfi: String): String {
        val temp = originCfi.split("/").toList()
        val paragraph = temp.getOrNull(temp.size - 2)?.toInt() ?: -1
        val res = if (paragraph > 0) {
            val tempList = ArrayList<String>()
            tempList.addAll(temp)
            tempList[tempList.size - 2] = "${paragraph + 2}"
            tempList.joinToString("/")
        } else {
            originCfi
        }
        return res
    }
}