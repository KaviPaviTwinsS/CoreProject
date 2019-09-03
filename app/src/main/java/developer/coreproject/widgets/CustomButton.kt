package developer.coreproject.widgets

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Typeface
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import com.google.android.material.button.MaterialButton
import developer.coreproject.R

class CustomButton : AppCompatButton {
    private lateinit var typedArray: TypedArray

    constructor(context: Context) : super(context) {
        initSetViewAttribute(context, null, 0)
    }

    constructor(context: Context, attrs: AttributeSet? = null) : super(context, attrs) {
        initSetViewAttribute(context, attrs, 0)
    }

    constructor(context: Context, attrs: AttributeSet? = null, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    ) {
        initSetViewAttribute(context, attrs, defStyle)
    }

    private fun initSetViewAttribute(context: Context, attrs: AttributeSet?, defStyle: Int) {
        typedArray =
            context.obtainStyledAttributes(attrs, R.styleable.CustomButtonStyle, defStyle, 0)
        val face = Typeface.createFromAsset(context.assets, "Roboto_Regular.ttf")
        typeface = face

        try {
            val textColor = typedArray.getColor(
                R.styleable.CustomButtonStyle_button_textColor,
                ContextCompat.getColor(context, R.color.app_color)
            )
            val backgroundColor = typedArray.getColor(
                R.styleable.CustomButtonStyle_background_color,
                ContextCompat.getColor(context, R.color.app_color)
            )
            val textSize: Float = typedArray.getDimension(
                R.styleable.CustomButtonStyle_button_textSize,
                context.resources.getDimension(R.dimen.sp_18)
            )
            val backgroundType = typedArray.getString(
                R.styleable.CustomButtonStyle_button_background
            )
            this.setTextColor(textColor)
            this.setBackgroundColor(backgroundColor)
            if (backgroundType == "search") {
                this.background = ContextCompat.getDrawable(context, R.drawable.border_bg)
            }
            this.textSize = textSize
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}