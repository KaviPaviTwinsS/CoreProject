package developer.coreproject.widgets

import android.content.Context
import android.content.res.ColorStateList
import android.content.res.TypedArray
import android.graphics.Typeface
import android.util.AttributeSet
import androidx.core.content.ContextCompat
import com.google.android.material.textfield.TextInputLayout
import developer.coreproject.R

class CustomTextInputLayout : TextInputLayout {
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
            context.obtainStyledAttributes(
                attrs,
                R.styleable.CustomTextInputLayoutStyle,
                defStyle,
                0
            )
        val face = Typeface.createFromAsset(context.assets, "Roboto_Regular.ttf")
        typeface = face
        try {
            val backgroundColor = typedArray.getColor(
                R.styleable.CustomTextInputLayoutStyle_text_background_color,
                ContextCompat.getColor(context, R.color.app_color)
            )
            val hintColor = typedArray.getColor(
                R.styleable.CustomTextInputLayoutStyle_text_hintColor,
                ContextCompat.getColor(context, R.color.app_color)
            )
            val backgroundType = typedArray.getString(
                R.styleable.CustomTextInputLayoutStyle_text_background
            )
            if (backgroundType == "search") {
                this.background = ContextCompat.getDrawable(context, R.drawable.border_bg)
            }
            val textColorHint: ColorStateList =
                ColorStateList.valueOf(hintColor)
            this.defaultHintTextColor = textColorHint
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}