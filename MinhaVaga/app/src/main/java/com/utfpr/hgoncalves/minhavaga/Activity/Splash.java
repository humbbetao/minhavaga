package com.utfpr.hgoncalves.minhavaga.Activity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.utfpr.hgoncalves.minhavaga.Model.Usuario;
import com.utfpr.hgoncalves.minhavaga.R;
//com.facebook.FacebookSdk

public class Splash extends AppCompatActivity {
    private static final String TAG = "NOVA";
    private TextView info;
    private LoginButton loginButton;
    private Usuario user;
    private CallbackManager callbackManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Intent intent = new Intent(this, Main2Activity.class);


        FacebookSdk.sdkInitialize(getApplicationContext());
        if (com.facebook.BuildConfig.DEBUG) {
            FacebookSdk.setIsDebugEnabled(true);
            FacebookSdk.addLoggingBehavior(LoggingBehavior.INCLUDE_ACCESS_TOKENS);
        }

        setContentView(R.layout.activity_splash);
        AccessToken accessToken = AccessToken.getCurrentAccessToken();

        if (verificaConexao()) {

            if (accessToken != null) {
                startActivity(intent);
            } else {

                callbackManager = CallbackManager.Factory.create();
                info = (TextView) findViewById(R.id.info);
                loginButton = (LoginButton) findViewById(R.id.login_button);
                //loginButton.setReadPermissions(Arrays.asList("public_profile, email, user_birthday, user_friends"));
                loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {


                        // App code
//                    GraphRequest request = GraphRequest.newMeRequest(
//                            loginResult.getAccessToken(),
//                            new GraphRequest.GraphJSONObjectCallback() {
//                                @Override
//                                public void onCompleted(
//                                        JSONObject object,
//                                        GraphResponse response) {
//                                    // Application code
//                                    Log.v("LoginActivity", response.toString());
//                                }
//                            });
                        startActivity(intent);

                    }

                    @Override
                    public void onCancel() {
                        // App code
                        Log.v("LoginActivity", "cancel");
                    }

                    @Override
                    public void onError(FacebookException exception) {
                        // App code
                        Log.v("LoginActivity", exception.getCause().toString());
                    }
                });

            }
        } else {
            loginButton = (LoginButton) findViewById(R.id.login_button);
            loginButton.setVisibility(View.VISIBLE);

            info = (TextView) findViewById(R.id.info);
//            info.setEnabled(false);
            info.setVisibility(View.VISIBLE);
            info.setText("Sem conexão com a internet");
//            info.setVisibility();

            //Toast.makeText(this, "SEM CONEXÂO COM A INTERNET", Toast.LENGTH_LONG).show();

        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }


    public boolean verificaConexao() {
        ConnectivityManager conectivtyManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (conectivtyManager.getActiveNetworkInfo() != null
                && conectivtyManager.getActiveNetworkInfo().isAvailable()
                && conectivtyManager.getActiveNetworkInfo().isConnected()) {
            return true;
        } else {
            return false;
        }
    }
}

