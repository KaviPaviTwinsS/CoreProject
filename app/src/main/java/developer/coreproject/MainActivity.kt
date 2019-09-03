package developer.coreproject

import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import developer.coreproject.widgets.CustomTextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val ll = LinearLayout(this)
        ll.orientation = LinearLayout.VERTICAL
        ll.id = 1
        val textView = CustomTextView(this)
        textView.setTypeFace("")
        textView.text = "NANDHINI"
        textView.setCustomTextColor(ContextCompat.getColor(this, R.color.colorAccent))
        textView.setCustomTextSize(resources.getDimension(R.dimen.sp_18))
        textView.setTextType("")
        ll.addView(textView)
//        main_ll.addView(ll)
    }
}
