//package com.utfpr.hgoncalves.minhavaga.Activity;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.support.v4.app.FragmentActivity;
//import android.widget.TextView;
//
//import com.facebook.BuildConfig;
//import com.facebook.CallbackManager;
//import com.facebook.FacebookCallback;
//import com.facebook.FacebookException;
//import com.facebook.FacebookSdk;
//import com.facebook.LoggingBehavior;
//import com.facebook.login.LoginResult;
//import com.facebook.login.widget.LoginButton;
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//import com.utfpr.hgoncalves.minhavaga.Model.Usuario;
//import com.utfpr.hgoncalves.minhavaga.R;
//
//public class loginfacebook extends FragmentActivity {
//    private TextView info;
//    private LoginButton loginButton;
//    private Usuario  user;
////
////    private Facebook facebook;
////    private AsyncFacebookRunner mAsyncRunner;
//    private CallbackManager callbackManager;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        FacebookSdk.sdkInitialize(getApplicationContext());
//        if (BuildConfig.DEBUG) {
//            FacebookSdk.setIsDebugEnabled(true);
//            FacebookSdk.addLoggingBehavior(LoggingBehavior.INCLUDE_ACCESS_TOKENS);
//        }
//        callbackManager = CallbackManager.Factory.create();
//        setContentView(R.layout.activity_splash);
////        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
////        setSupportActionBar(toolbar);
//        final Intent intent = new Intent(this, Main2Activity.class);
//        info = (TextView) findViewById(R.id.info);
//        loginButton = (LoginButton) findViewById(R.id.login_button);
//
//
//
//        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
//            @Override
//            public void onSuccess(LoginResult loginResult) {
//
//                Usuario user = new Usuario();
//                Gson gson = new GsonBuilder().create();
//                gson.getAdapter(Usuario.class);
//
//
////                new GraphRequest(
////                        AccessToken.getCurrentAccessToken(),
////                        "/me/fields=id,name,picture",
////                        null,
////                        HttpMethod.GET,
////                        new GraphRequest.Callback() {
////                            public void onCompleted(GraphResponse response) {
////            /* handle the result */
//////                                info.setText(response.getJSONObject().toString());
////                            }
////                        }
////                ).executeAsync();
//
////
////                AccessToken accessToken = loginResult.getAccessToken();
////
////                Log.e("FB", String.valueOf(accessToken));
////                Profile profile = Profile.getCurrentProfile();
//
////                if (profile != null) {
////                    info.setText("Witam +"+ profile.getFirstName());
//////                    name.setText("Witam " + profile.getName());
////                    Log.e("FB", "w");
////                }
////
//
//        }
//
//
////                startActivity(intent);
//
////            }
//
//            @Override
//            public void onCancel() {
//
//            }
//
//            @Override
//            public void onError(FacebookException e) {
//                info.setText("Login attempt failed.");
//            }
//        });
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        callbackManager.onActivityResult(requestCode, resultCode, data);
//    }
//
//
//}
