package com.ruichaoqun.wanandroid.data

import java.lang.StringBuilder

/**
 *
 * @Author:         芮超群
 * @CreateDate:     2021/4/17 15:07
 * @Description:    SystemTreeBean
 * @Version:        1.0
 */
data class SystemTreeBean(
    var children:MutableList<SystemTreeBean>?,
    var courseId:Int?,
    var id:Int?,
    var name:String?,
    var order:Int?,
    var parentChapterId:Int?,
    var userControlSetTop:Boolean?,
    var visible:Int
){
    fun childStrings():String{
        val builder = StringBuilder()
        for (child in children?: mutableListOf()){
            builder.append(child.name)
            builder.append("  ")
        }
        return builder.toString()
    }
}