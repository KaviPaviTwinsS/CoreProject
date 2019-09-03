package developer.coreproject.widgets

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Typeface
import android.util.AttributeSet
import androidx.core.content.ContextCompat
import com.google.android.material.textfield.TextInputEditText
import developer.coreproject.R

/**
 * To change Cursor color(we can set a text color as cursor color after set android:textCursorDrawable="@null" in XML
 */
class CustomEditText : TextInputEditText {
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
            context.obtainStyledAttributes(attrs, R.styleable.CustomEditTextStyle, defStyle, 0)
        val face = Typeface.createFromAsset(context.assets, "Roboto_Regular.ttf")
        typeface = face
        try {
            val textColor = typedArray.getColor(
                R.styleable.CustomEditTextStyle_editText_textColor,
                ContextCompat.getColor(context, R.color.app_color)
            )
            val textSize: Float = typedArray.getDimension(
                R.styleable.CustomTextViewStyle_textSize,
                context.resources.getDimension(R.dimen.sp_18)
            )
            val backgroundType = typedArray.getString(
                R.styleable.CustomEditTextStyle_editText_background
            )
            this.setTextColor(textColor)
            this.textSize = textSize
            if (backgroundType == "search") {
                this.background = ContextCompat.getDrawable(context, R.drawable.border_bg)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}