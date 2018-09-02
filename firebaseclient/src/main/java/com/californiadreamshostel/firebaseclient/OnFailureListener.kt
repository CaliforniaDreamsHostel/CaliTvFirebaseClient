package com.californiadreamshostel.firebaseclient


interface OnFailureListener {
    fun onFailure(item: Reference, exception: Exception)
}