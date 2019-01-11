package me.darshpratap.coaster;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import me.darshpratap.coaster.api.PageInsightService;
import me.darshpratap.coaster.database.viewModel.CategoryViewModel;
import me.darshpratap.coaster.database.viewModel.ContentViewModel;
import me.darshpratap.coaster.database.viewModel.ResponseViewModel;
import me.darshpratap.coaster.models.db.Category;
import me.darshpratap.coaster.models.db.Response;
import retrofit2.Call;
import retrofit2.Callback;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class MainActivity extends AppCompatActivity {
    private ResponseViewModel responseViewModel;
    private CategoryViewModel categoryViewModel;
    private ContentViewModel contentViewModel;
    private LinearLayout historyBottomSheet;
    private BottomSheetBehavior sheetBehavior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        historyBottomSheet = findViewById(R.id.history_bottom_sheet);
        sheetBehavior = BottomSheetBehavior.from(historyBottomSheet);

        responseViewModel = ViewModelProviders.of(MainActivity.this).get(ResponseViewModel.class);
        categoryViewModel = ViewModelProviders.of(MainActivity.this).get(CategoryViewModel.class);
        contentViewModel = ViewModelProviders.of(MainActivity.this).get(ContentViewModel.class);

        PageInsightService.getInsightApi().getResponse().enqueue(new Callback<ResponseApi>() {
            @Override
            public void onResponse(Call<ResponseApi> call, retrofit2.Response<ResponseApi> response) {
                cascadedUpsert(response.body(), "shit: fix this soon");
            }

            @Override
            public void onFailure(Call<ResponseApi> call, Throwable t) {
                Log.d("shitshit", "Error: Request Failed " + t.getMessage());
            }
        });
    }

    private void cascadedUpsert(final ResponseApi responseApi, final String url) {
//        int id = responseViewModel.getId(url);
//        Log.d("shitid", String.valueOf(id));
//        // insert if id != 0 else update
//        if (id == 0) {
//            responseViewModel.insert(new Response(url));
//            id = responseViewModel.getId(url);
//            categoryViewModel.insert(new Category(responseApi.getPerformanceApi().getTitle(), responseApi.getPerformanceApi().getScore(), id));
//            categoryViewModel.insert(new Category(responseApi.getAccessibiltyApi().getTitle(), responseApi.getAccessibiltyApi().getScore(), id));
//            categoryViewModel.insert(new Category(responseApi.getBest_practicesApi().getTitle(), responseApi.getBest_practicesApi().getScore(), id));
//            categoryViewModel.insert(new Category(responseApi.getPwaApi().getTitle(), responseApi.getPwaApi().getScore(), id));
//            categoryViewModel.insert(new Category(responseApi.getSeoApi().getTitle(), responseApi.getSeoApi().getScore(), id));
//        } else {
//
//        }

        responseViewModel.getId(url).observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer id) {
                if (id == null) {
                    responseViewModel.insert(new Response(url));
                    categoryViewModel.insert(new Category(responseApi.getPerformanceApi().getTitle(), responseApi.getPerformanceApi().getScore(), id));
                }
            }
        });
    }
}
