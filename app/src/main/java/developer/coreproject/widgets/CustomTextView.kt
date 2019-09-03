package developer.coreproject.widgets

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Typeface
import android.util.AttributeSet
import android.util.TypedValue
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import developer.coreproject.R


class CustomTextView : AppCompatTextView {
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
            context.obtainStyledAttributes(attrs, R.styleable.CustomTextViewStyle, defStyle, 0)
        val face = Typeface.createFromAsset(context.assets, "Roboto_Regular.ttf")
        typeface = face
        try {
            val textType: String? = typedArray.getString(R.styleable.CustomTextViewStyle_textType)
            val textSize: Float = typedArray.getDimension(
                R.styleable.CustomTextViewStyle_textSize,
                context.resources.getDimension(R.dimen.sp_18)
            )
            val textColor = typedArray.getColor(
                R.styleable.CustomTextViewStyle_textColor,
                ContextCompat.getColor(context, R.color.app_color)
            )
            if (textType == context.getString(R.string.textType_header)) {
                this.setTextSize(
                    TypedValue.COMPLEX_UNIT_SP,
                    context.resources.getDimension(R.dimen.sp_100)
                )
            } else {
                this.setTextSize(
                    TypedValue.COMPLEX_UNIT_SP,
                    textSize
                )
                this.setTextColor(textColor)
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }
        typedArray.recycle()
    }

    fun setCustomTextColor(textColor: Int) {
        setTextColor(textColor)
    }

    fun setCustomTextSize(textSize: Float) {
        setTextSize(
            TypedValue.COMPLEX_UNIT_SP,
            textSize
        )
    }

    fun setTextType(textType: String) {
        if (textType == context.getString(R.string.textType_header)) {
            this.setTextSize(
                TypedValue.COMPLEX_UNIT_SP,
                context.resources.getDimension(R.dimen.sp_100)
            )
        }
    }

    fun setTypeFace(typefaceStr: String) {
        val face = Typeface.createFromAsset(context.assets, "Roboto_Regular.ttf")
        typeface = face
    }

}