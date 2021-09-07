package com.hsikkk.glassmorphism

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.util.TypedValue
import androidx.constraintlayout.widget.ConstraintLayout
import com.github.mmin18.widget.RealtimeBlurView
import com.google.android.material.card.MaterialCardView


class GlassLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) :
    ConstraintLayout(context, attrs, defStyleAttr) {

    private val TRANSPARENT = "#00000000"
    private val STROKECOLOR = "#FFFFFF"
    private val OVERLAYCOLOR = "#50FFFFFF"

    private var cardView: MaterialCardView
    private var backgroundBlurView: RealtimeBlurView

    init {
        cardView = MaterialCardView(context).apply {
            layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
            setCardBackgroundColor(Color.parseColor(TRANSPARENT))
            radius = getPxFromDp(15)
            strokeWidth = Math.round(getPxFromDp(1))
            strokeColor = Color.parseColor(STROKECOLOR)
            setPadding(0,0,0,0)
            elevation = 0f
        }

        backgroundBlurView = RealtimeBlurView(context, attrs).apply {
            layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
            setBlurRadius(getPxFromDp(15))
            setOverlayColor(Color.parseColor(OVERLAYCOLOR))
        }

        this.addView(cardView)
        cardView.addView(backgroundBlurView)
    }

    private fun getPxFromDp(dp: Int) : Float{
        val r = context.resources
        val px = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            dp.toFloat(),
            r.displayMetrics
        ).toInt()

        return px.toFloat()
    }
}