package com.lucky.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.graphics.Bitmap
import android.graphics.Canvas
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import android.view.View.MeasureSpec
import android.view.LayoutInflater
import android.widget.*
import androidx.core.widget.NestedScrollView


class MainActivity : AppCompatActivity() {
    var rootView : ViewGroup? = null
    var textView : TextView? = null
    var button : Button? = null
    var imageView: ImageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rootView = findViewById(R.id.root_view)
        button = findViewById(R.id.button)
        imageView = findViewById(R.id.image_view)
        val inflatedFrame: View = layoutInflater.inflate(R.layout.item_two, null)
        button?.setOnClickListener {
            imageView?.setImageBitmap(generateBitmapFromView(inflatedFrame))
        }
    }

    private fun generateBitmapFromView(view: View): Bitmap {
        view.measure(
            MeasureSpec.makeMeasureSpec(rootView?.width ?: 0, MeasureSpec.EXACTLY),
            MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED)
        )
        view.layout(0, 0, view.measuredWidth, view.measuredHeight)
        val width = view.measuredWidth
        val height = view.measuredHeight
        val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        view.layout(view.left, view.top, view.right, view.bottom)
        view.draw(canvas)
        return bitmap
    }
}