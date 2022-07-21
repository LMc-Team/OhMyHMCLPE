package com.lmcteam.ohmyhmclpe

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import java.nio.charset.Charset

class M : AppCompatActivity() {
    lateinit var input: TextInputEditText;
    lateinit var generateButton: MaterialButton
    lateinit var result: TextView;
    lateinit var copyBtn: MaterialButton;

    init {
        print("M")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        input = findViewById(R.id.input_device_code)
        generateButton = findViewById(R.id.generate_button)
        result = findViewById(R.id.result)
        copyBtn = findViewById(R.id.copy_button)
        generateButton.setOnClickListener(View.OnClickListener {

            if (it == generateButton) {
                var deviceCode = input.text.toString()
                var k = A.a(deviceCode)
                result.text = toMD5(k).uppercase()
                result.visibility = View.VISIBLE
                copyBtn.visibility = View.VISIBLE
            } else if (it == copyBtn) {
                var text = result.text.toString()
                var clipboard = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
                clipboard.setPrimaryClip(ClipData.newPlainText("label", text))
            }


        })
        copyBtn.setOnClickListener(View.OnClickListener {
            if (it == generateButton) {

            } else if (it == copyBtn) {
                var text = result.text.toString()
                var clipboard = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
                clipboard.setPrimaryClip(ClipData.newPlainText("label", text))
            }

        })
    }


    fun toMD5(text: String): String {
        val md5 = java.security.MessageDigest.getInstance("MD5")
        val digest = md5.digest(text.toByteArray(Charset.forName("UTF-8")))
        val hexString = StringBuilder()
        for (i in digest.indices) {
            var hex = Integer.toHexString(0xFF and digest[i].toInt())
            if (hex.length < 2) {
                hex=StringBuilder(java.lang.String.valueOf(0)).append(hex).toString()
            }
            hexString.append(hex)
        }
        return hexString.toString()
    }

}