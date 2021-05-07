package com.ruichaoqun.wanandroid.data

import android.os.Parcel
import android.os.Parcelable
import java.lang.StringBuilder

/**
 *
 * @Author:         芮超群
 * @CreateDate:     2021/4/17 15:07
 * @Description:    SystemTreeBean
 * @Version:        1.0
 */
data class SystemTreeBean(
    var children:ArrayList<SystemTreeBean>?,
    var courseId:Int?,
    var id:Int?,
    var name:String?,
    var order:Int?,
    var parentChapterId:Int?,
    var userControlSetTop:Boolean?,
    var visible:Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.createTypedArrayList(CREATOR),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readInt()
    ) {
    }

    fun childStrings():String{
        val builder = StringBuilder()
        for (child in children?: mutableListOf()){
            builder.append(child.name)
            builder.append("  ")
        }
        return builder.toString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeTypedList(children)
        parcel.writeValue(courseId)
        parcel.writeValue(id)
        parcel.writeString(name)
        parcel.writeValue(order)
        parcel.writeValue(parentChapterId)
        parcel.writeValue(userControlSetTop)
        parcel.writeInt(visible)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SystemTreeBean> {
        override fun createFromParcel(parcel: Parcel): SystemTreeBean {
            return SystemTreeBean(parcel)
        }

        override fun newArray(size: Int): Array<SystemTreeBean?> {
            return arrayOfNulls(size)
        }
    }
}