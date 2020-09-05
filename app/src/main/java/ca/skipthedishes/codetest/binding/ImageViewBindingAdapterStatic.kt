package ca.skipthedishes.codetest.binding

import androidx.databinding.BindingAdapter
import com.facebook.drawee.view.SimpleDraweeView

object ImageViewBindingAdapterStatic {

    @JvmStatic @BindingAdapter("android:imageResource")
    fun setImageResource(view: SimpleDraweeView, resId: Int) = view.setImageResource(resId)
}