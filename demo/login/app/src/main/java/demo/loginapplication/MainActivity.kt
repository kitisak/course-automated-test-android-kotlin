package demo.loginapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity(), View.OnClickListener, LoginView {

    lateinit var loginPresenter: LoginPresenter

    override fun showResult(message: String) {
        Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        email_sign_in_button.setOnClickListener(this)

        init()
    }

    private fun init() {
        val okHttpClient = OkHttpClient.Builder().build()

        val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()

        val loginService = retrofit.create(LoginService::class.java)
        loginPresenter = LoginPresenter(LoginRepository(loginService), this)
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.email_sign_in_button -> {
                loginPresenter.tryToLogin(email.text.toString(), password.text.toString())
//                processLogin()
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

    override fun onDestroy() {
        DisposableManager.clear()
        super.onDestroy()
    }
}
