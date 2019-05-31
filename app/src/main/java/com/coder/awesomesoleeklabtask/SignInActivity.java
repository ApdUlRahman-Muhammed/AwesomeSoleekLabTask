package com.coder.awesomesoleeklabtask;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class SignInActivity extends AppCompatActivity {
    public static final int RC_SIGN_IN = 1;
    private FirebaseAuth mAuth;
    private ImageView logoIm;
    private EditText emilET;
    private EditText passwordET;
    private Button signIn;
    private Button signUp;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    GoogleApiClient mGoogleSignInClient;
    FirebaseAuth.AuthStateListener mlistner;
    /* @BindView(R.id.loginIv)
     ImageView logo;
     @BindView(R.id.emilET)
     EditText emilET;
     @BindView(R.id.PasswordET)
     EditText passwordET;
     @BindView(R.id.signInBut)
     Button signIn;
     @BindView(R.id.signUpBut)
     Button signUp;*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        //  ButterKnife.bind(this);
        logoIm = findViewById(R.id.iv_logo);
        emilET = findViewById(R.id.et_email);
        passwordET = findViewById(R.id.et_password);
        signIn = findViewById(R.id.btn_signIn);
        signUp = findViewById(R.id.btn_signUp);
        signIn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String emil = emilET.getText().toString();
                String password = passwordET.getText().toString();
                Intent b = new Intent(SignInActivity.this, MainActivity.class);
                startActivity(b);
            }
        });
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SignInActivity.this, SignUpActivity.class);
                startActivity(i);
            }
        });

       /* GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        mAuth = FirebaseAuth.getInstance();
        mGoogleSignInClient = new GoogleApiClient.Builder(getApplicationContext()).enableAutoManage(this, new GoogleApiClient.OnConnectionFailedListener() {
            @Override
            public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
              //  Toast.makeText(Login.this, "error", Toast.LENGTH_SHORT).show();
            }
        }).addApi(Auth.GOOGLE_SIGN_IN_API, gso).build();*/


    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
      //  FirebaseUser currentUser = mAuth.getCurrentUser();
        // updateUI(currentUser);
        //TODO create updateUI to navigate user to home screen as he all ready signed in
    }

    @Override
    protected void onPause() {
        super.onPause();
     //   mAuth.removeAuthStateListener(mAuthStateListener);
    }

    @Override
    protected void onResume() {
        super.onResume();
     //   mAuth.addAuthStateListener(mAuthStateListener);
    }
}
