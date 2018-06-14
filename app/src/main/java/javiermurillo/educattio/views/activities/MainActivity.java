package javiermurillo.educattio.views.activities;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import javiermurillo.educattio.R;
import javiermurillo.educattio.databinding.ActivityMainBinding;
import javiermurillo.educattio.utils.Utils;

import static javiermurillo.educattio.utils.Constants.LEVEL;
import static javiermurillo.educattio.utils.Constants.OPERATION;
import static javiermurillo.educattio.utils.Constants.REQUEST_CODE;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void init() {
        initBinding();
        initComponents();
    }

    private void initComponents() {
        String[] levels = {"Fácil", "Moderado", "Difícil"};
        binding.numberPicker.setMaxValue(levels.length - 1);
        binding.numberPicker.setMinValue(0);
        binding.numberPicker.setDisplayedValues(levels);
        binding.buttonInitate.setOnClickListener(v -> {
            Log.d("MainActivity", binding.numberPicker.getValue() + "");
            openActivityForResult(this,SolveActivity.class,binding.spinner.getSelectedItemPosition(),binding.numberPicker.getValue());
        });
    }

    //region Menu

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.menu_about){
            Utils.openActivity(this, AboutActivity.class);
            return true;
        }else if(id == R.id.menu_help){
            Utils.openLink(this,"xaviermasabandar.wordpress.com/category/matematicas/operaciones-basicas/definicion-y-ejemplo-de-operaciones-basicas/");
        }
        return super.onOptionsItemSelected(item);
    }

    //endregion

    public void openActivityForResult(Activity activity, Class clazz, int operation, int level){
        Intent mIntent = new Intent(activity, clazz);
        Bundle options = new Bundle();
        options.putInt(REQUEST_CODE, -1);
        mIntent.putExtra(LEVEL,level);
        mIntent.putExtra(OPERATION,operation);
        activity.startActivityForResult(mIntent,-1,options);
    }

    private void initBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    }
}
