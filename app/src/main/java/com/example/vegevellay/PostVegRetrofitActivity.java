package com.example.vegevellay;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostVegRetrofitActivity extends AppCompatActivity {
    String TAG = "Retrofit";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.posting);

        //Retrofit 인스턴스 생성
        retrofit2.Retrofit retrofit = new retrofit2.Retrofit.Builder()
                .baseUrl(" http://101.101.217.206/")    // baseUrl 등록
                .addConverterFactory(GsonConverterFactory.create())  // Gson 변환기 등록
                .build();

        PostVegBoard service = retrofit.create(PostVegBoard.class);   // 레트로핏 인터페이스 객체 구현

        Button btn_sendIdx = findViewById(R.id.postingSubmit);    // 전송 버튼
        btn_sendIdx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.e(TAG, "버튼 클릭");

                // edittext로부터 유저가 입력한 idx값을 가져온다
                EditText editText_title = findViewById(R.id.postingTitle);
                EditText editText_vegKing = findViewById(R.id.vegKindEditTxt);
                EditText editText_vegFresh = findViewById(R.id.vegFreshEditTxt);
                EditText editText_vegSell = findViewById(R.id.vegSellEditTxt);
                EditText editText_content = findViewById(R.id.postingContent);

                String idx1 = editText_title.getText().toString(); // 서버로 보낼 idx
                String idx2 = editText_vegKing.getText().toString();
                String idx3 = editText_vegFresh.getText().toString();
                String idx4 = editText_vegSell.getText().toString();
                String idx5 = editText_content.getText().toString();


                Call<PostDataClass> call = service.getPosts(idx1);
                call = service.getPosts(idx2);
                call = service.getPosts(idx3);
                call = service.getPosts(idx4);
                call = service.getPosts(idx5);

                call.enqueue(new Callback<PostDataClass>() {
                    @Override
                    public void onResponse(Call<PostDataClass> call, Response<PostDataClass> response) {
                        Log.e(TAG, "onResponse");
                        if(response.isSuccessful()){
                            Log.e(TAG, "onResponse success");
                            PostDataClass result = response.body();

                            // 서버에서 응답받은 데이터를 TextView에 넣어준다.
                            TextView sellTitle = findViewById(R.id.sellTitle);
                            TextView vegKindTxt = findViewById(R.id.vegKindTxt);
                            TextView vegFreshTxt = findViewById(R.id.vegFreshTxt);
                            TextView vegSellTxt = findViewById(R.id.vegSellTxt);
                            TextView sellContentTxt = findViewById(R.id.sellContentTxt);
                            long i=1;
                            i++;
                            long VEGE_CONTENT_ID=12;
                            long AUTHOR_ID=i;
                            String DATE_CREATED="2022-06-24";
                            String LAST_UPDATED="2022-06-24";
                            long LOCAL_ID=10;

                            String DATE_BUY;

                            sellTitle.setText(result.TITLE);
                            vegKindTxt.setText(result.VEGE);
                            vegFreshTxt.setText(result.DATE_BUY);
                            vegSellTxt.setText(String.valueOf(result.SELL_CHECK));
                            sellContentTxt.setText(result.MAIN_TEXT);


                        }
                        else{
                            // 실패
                            Log.e(TAG, "onResponse fail");
                        }
                    }

                    @Override
                    public void onFailure(Call<PostDataClass> call, Throwable t) {
                        // 통신 실패
                        Log.e(TAG, "onFailure: " + t.getMessage());
                    }
                });
            }
        });
    }
}
