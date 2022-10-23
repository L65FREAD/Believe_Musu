package np.com.aayushgautam.believe.WellnessCheck;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Pie;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import np.com.aayushgautam.believe.databinding.ActivityResultsBinding;

public class Results extends AppCompatActivity {
    ActivityResultsBinding binding;
    String[] s = {"Going Out","Reading","Watching Movies","Working Out","Eating Well", "Proper Sleep"};
    int[] results = {10,20,10,30,40,20};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityResultsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Objects.requireNonNull(getSupportActionBar()).hide();
        setUpPieChart();

    }

    public void setUpPieChart() {
        Pie pie = AnyChart.pie();
        List<DataEntry> dataEntries = new ArrayList<>();

        for (int i = 0; i <s.length; i++) {
            dataEntries.add(new ValueDataEntry(s[i],results[i]));
        }

        pie.background();
        pie.credits().enabled(false);
        pie.data(dataEntries);
        binding.pieChart.setChart(pie);

    }
}