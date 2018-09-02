package com.californiadreamshostel.firebaseclient

import com.google.firebase.database.DataSnapshot

class ReferenceItemAdapter(private val group: String?, var itemFactory: ((String, String, String) -> ReferenceItem)? = null) {

    companion object {
        const val ROOT = "Root"
    }

    fun getData(data: DataSnapshot): ReferenceItem?{

        if(!data.exists())
            return null

        val parentRef = (data.ref.parent?.key) ?: group
        val key = data.key!!
        val value = data.value

        val item = getItem((parentRef) ?: ROOT, key, "" )

        for(child in data.children) {
            val childItem = getData(child)
            if(childItem != null)
                item.addChild(childItem)
        }

        if(item.getChildren().isEmpty() && value != null) //Is a raw reference
            item.value = value.toString()

        return item
    }

    fun getItem(pK: String, k: String, v: String): ReferenceItem{
        return (itemFactory?.invoke(pK, k, v)) ?: ReferenceItem(pK, k, v)
    }

}
