package com.hiepdt.vpstest.utils

import android.annotation.SuppressLint
import android.app.Activity
import android.app.ProgressDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Handler
import android.provider.Settings
import android.text.TextUtils
import android.view.Gravity
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.google.android.material.snackbar.Snackbar
import com.hiepdt.vpstest.GlobalApp
import com.hiepdt.vpstest.R
import com.hiepdt.vpstest.data.AppDataManager
import java.io.IOException
import java.nio.charset.Charset
import java.text.SimpleDateFormat
import java.util.*
import java.util.regex.Pattern


/**
 * Created by hiepdt on 21/08/2021.
 */

class CommonUtils {

    companion object{
        private const val TAG = "CommonUtils"

        fun showLoadingDialog(context: Context?): ProgressDialog {
            val progressDialog = ProgressDialog(context)
            progressDialog.show()

            Handler().postDelayed({
                progressDialog.dismiss()
            }, AppConstants.DIALOG_TIMEOUT)
            if (progressDialog.window != null) {
                progressDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            }
            progressDialog.setContentView(R.layout.progress_dialog)
            progressDialog.isIndeterminate = true
            progressDialog.setCancelable(false)
            progressDialog.setCanceledOnTouchOutside(false)
            return progressDialog
        }

        @SuppressLint("all")
        fun getDeviceId(context: Context): String {
            return Settings.Secure.getString(context.contentResolver, Settings.Secure.ANDROID_ID)
        }

        fun isValidEmail(email: String?): Boolean {
            val EMAIL_PATTERN = ("^[a-zA-Z0-9_!#\$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+\$")
            val pattern = Pattern.compile(EMAIL_PATTERN)
            val matcher = pattern.matcher(email)
            return matcher.matches()
        }

        @Throws(IOException::class)
        fun loadJSONFromAsset(context: Context, jsonFileName: String?): String {
            val manager = context.assets
            val `is` = manager.open(jsonFileName!!)
            val size = `is`.available()
            val buffer = ByteArray(size)
            `is`.read(buffer)
            `is`.close()
            return String(buffer, Charset.forName("UTF-8"))
        }

        fun isValidPhoneNumber(phoneNumber: String?): Boolean {
            if (TextUtils.isEmpty(phoneNumber)) {
                return false
            }
            return phoneNumber?.matches(Regex("(09|03|01|05|07|08[2|6|8|9])+([0-9]{8})\\b")) == true
        }

        fun isValidPassword(password: String?): Boolean {
            if (TextUtils.isEmpty(password) && password?.length!! < 8) {
                return false
            }
            /**
             *  ^                 # start-of-string
            (?=.*[0-9])       # a digit must occur at least once
            (?=.*[a-z])       # a lower case letter must occur at least once
            (?=.*[A-Z])       # an upper case letter must occur at least once
            (?=.*[@#$%^&+=])  # a special character must occur at least once
            (?=\S+$)          # no whitespace allowed in the entire string
            .{8,}             # anything, at least eight places though
            $                 # end-of-string
             */
            return true
//            return password?.matches(Regex("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+\$).{8,}\$\n")) == true
        }

        fun showSnackBar(activity: Activity?, message: String, isSuccess: Boolean) {
            if (activity == null) return
            val snack = Snackbar.make(activity.findViewById<View>(android.R.id.content), message, Snackbar.LENGTH_SHORT)
            val view = snack.view
            view.setBackgroundResource(if (isSuccess) R.drawable.bg_success_message else R.drawable.bg_fail_message)
            val tv = view.findViewById<TextView>(R.id.snackbar_text)
            tv.setTextColor(ContextCompat.getColor(activity, if (isSuccess) R.color.color_text_success else R.color.color_text_failed))
            val typeface = ResourcesCompat.getFont(activity, R.font.open_sans_semi_bold)
            tv.typeface = typeface
            val params = view.layoutParams as FrameLayout.LayoutParams
            params.gravity = Gravity.TOP
            view.layoutParams = params
            snack.show()
        }

        fun showSnackBar(viewDialog: View?, message: String, isSuccess: Boolean) {
            if (viewDialog == null) return
            val snack = Snackbar.make(viewDialog, message, Snackbar.LENGTH_SHORT)
            val view = snack.view
            view.setBackgroundResource(if (isSuccess) R.drawable.bg_success_message else R.drawable.bg_fail_message)
            val tv = view.findViewById<TextView>(R.id.snackbar_text)
            tv.setTextColor(ContextCompat.getColor(viewDialog.context, if (isSuccess) R.color.color_text_success else R.color.color_text_failed))
            val typeface = ResourcesCompat.getFont(viewDialog.context, R.font.open_sans_semi_bold)
            tv.typeface = typeface
            val params = view.layoutParams as FrameLayout.LayoutParams
            params.gravity = Gravity.TOP
            view.layoutParams = params
            snack.show()
        }
    }

}