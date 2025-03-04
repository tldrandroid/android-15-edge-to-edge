package com.oliverspryn.android.edgetoedge.details

import com.oliverspryn.android.edgetoedge.mvc.ObservableViewMvc

interface DetailsViewMvc : ObservableViewMvc<DetailsViewMvc.Listener> {
    interface Listener {
        fun onPreviewTap(uri: String)
    }

    fun setPhoto(uri: String)
    fun setTitle(titleText: String)
}
