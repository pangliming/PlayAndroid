package com.liming.playandroid.util

import android.text.Html

/**
 * @author pangliming
 *
 */
fun getHtml(text: String): String {
    return if (AndroidVersion.hasNougat()) {
        Html.fromHtml(text, Html.FROM_HTML_MODE_LEGACY).toString()
    } else {
        text
    }
}