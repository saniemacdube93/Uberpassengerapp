package uberube.user.example.com.androidriderapp.Service;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import uberube.user.example.com.androidriderapp.Common.Common;
import uberube.user.example.com.androidriderapp.Model.Token;

/**
 * Created by User on 3/3/2018.
 */

public class MyFirebaseIdService extends FirebaseInstanceIdService{
    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();
        String refreshToken = FirebaseInstanceId.getInstance().getToken();
        updateTokenToServer(refreshToken);
    }

    private void updateTokenToServer(String refreshToken) {
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        DatabaseReference tokens = db.getReference(Common.token_tb1);

        Token token = new Token(refreshToken);
        if (FirebaseAuth.getInstance().getCurrentUser() != null) // if already login , must update Token
            tokens.child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                    .setValue(token);



    }

}
