package demo.loginapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        email_sign_in_button.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.email_sign_in_button -> {
                processLogin()
            }
        }
    }

    private fun processLogin() {
        if(email.text.toString().equals("somkiat@xxx.com")) {
            Toast.makeText(this@MainActivity, "Success", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this@MainActivity, "Fail", Toast.LENGTH_SHORT).show()
        }
    }
}
