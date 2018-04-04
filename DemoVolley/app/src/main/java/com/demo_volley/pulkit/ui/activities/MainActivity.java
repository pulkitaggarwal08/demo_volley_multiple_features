package com.demo_volley.pulkit.ui.activities;

import android.app.Dialog;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.demo_volley.pulkit.R;
import com.demo_volley.pulkit.config.App;
import com.demo_volley.pulkit.config.AppConstant;
import com.demo_volley.pulkit.receiver.ConnectivityReceiver;
import com.demo_volley.pulkit.util.CommonUtil;
import com.demo_volley.pulkit.util.RequestParameterUtil;
import com.demo_volley.pulkit.util.SnackbarUtil;
import com.demo_volley.pulkit.util.StringUtil;

import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.et_email)
    EditText etEmail;
    @BindView(R.id.et_password)
    EditText etPassword;

    private String email, password;

    private ConnectivityReceiver connectionReciever;
    IntentFilter intentFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

    }

    @OnClick(R.id.btn_login)
    public void onClickLogin() {

        email = etEmail.getText().toString().trim();
        password = etPassword.getText().toString().trim();
        hitLoginService();

        checkInternetConnection();


    }

    private void checkInternetConnection() {

        connectionReciever = new ConnectivityReceiver();

        intentFilter = new IntentFilter();
        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(connectionReciever, intentFilter);

        Log.v("receiver", "service started");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        unregisterReceiver(connectionReciever);
        Log.v("receiver", "service stopped");
    }

    private void hitLoginService() {

        if (validate()) {
            CommonUtil.showProgressDilaog(MainActivity.this);
            JSONObject loginRequestObject = RequestParameterUtil.prepareLoginObject(email, password,
                    "dkjdsk29289m", "2029387392", "2.60", "6.01", "6.01", "31",
                    "ANDROID", "20-12-17 09:36:21", "test", "36.132215", "79.2566356", "test", "test");

            final JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, AppConstant.BASE_URL +
                    AppConstant.SIGN_IN, loginRequestObject, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    CommonUtil.dismissProgressDilaog();
                    if (response != null) {
                        String status, message;
                        try {
                            status = response.getString("status");
                            message = response.getString("message");

                            if (status.equalsIgnoreCase("0")) {
                                //Todo: Logged in Failure
                                Toast.makeText(getApplicationContext(), "Login Failed", Toast.LENGTH_SHORT).show();

                            } else if (status.equalsIgnoreCase("1")) {
                                //Todo: Logged in Successfully
                            } else if (status.equalsIgnoreCase("2")) {
                                //Todo: Logged in Already
                                final Dialog dialog = new Dialog(MainActivity.this);
                                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                                dialog.setContentView(R.layout.dialog_force_logout);
                                dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                                dialog.setCanceledOnTouchOutside(false);
                                dialog.setCancelable(true);
                                Button btnNo = (Button) dialog.findViewById(R.id.btn_no);
                                Button btnYes = (Button) dialog.findViewById(R.id.btn_yes);

                                btnNo.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        dialog.dismiss();
                                    }
                                });

                                btnYes.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        //Todo: call signout
                                        dialog.dismiss();
                                    }
                                });

                                dialog.show();
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    error.printStackTrace();
                    CommonUtil.dismissProgressDilaog();
                }
            });

            App.getRequestQueue().add(jsonObjectRequest);
        }
    }

    private boolean validate() {
        if (StringUtil.isEmpty(email)) {
            SnackbarUtil.showWarningLongSnackbar(MainActivity.this, getResources().getString(R.string.empty_email));
            return false;
        } else if (StringUtil.isEmpty(password)) {
            SnackbarUtil.showWarningLongSnackbar(MainActivity.this, getResources().getString(R.string.empty_password));
            return false;
        }
        return true;
    }


}
