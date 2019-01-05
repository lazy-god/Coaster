package me.darshpratap.coaster;

import androidx.appcompat.app.AppCompatActivity;
import me.darshpratap.coaster.api.PageInsightService;
import me.darshpratap.coaster.models.api.Response;
import retrofit2.Call;
import retrofit2.Callback;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class MainActivity extends AppCompatActivity {
    private LinearLayout historyBottomSheet;
    private BottomSheetBehavior sheetBehavior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        historyBottomSheet = findViewById(R.id.history_bottom_sheet);
        sheetBehavior = BottomSheetBehavior.from(historyBottomSheet);

        PageInsightService.getInsightApi().getResponse().enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                Log.d("shitshit", response.body().getPerformance().getTitle());
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                Log.d("shitshit", "Error: Request Failed " + t.getMessage());
            }
        });
    }
}
