package javiermurillo.educattio.views.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.vansuita.materialabout.builder.AboutBuilder;

import javiermurillo.educattio.R;

public class AboutActivity extends AppCompatActivity {
        //region Create & Listeners
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            //setContentView(R.layout.activity_about);
            initAboutView();
            initHomeButton();
        }

        private void initHomeButton() {
            if(getSupportActionBar() != null)
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            if(item.getItemId() == android.R.id.home){
                onBackPressed();
            }
            return super.onOptionsItemSelected(item);
        }
        //endregion

        //region Fill About
        private void initAboutView(){
            View materialAboutView = AboutBuilder.with(this)
                    .setAppName(R.string.app_name)
                    .setAppIcon(R.mipmap.ic_launcher_round)
                    .setVersionNameAsAppSubTitle()
                    .setLinksAnimated(true)
                    .setDividerDashGap(13)
                    .setName(R.string.developer)
                    .setSubTitle(R.string.developer_subtitle)
                    .setLinksColumnsCount(4)
                    .setBrief("Pásenos, profe")
                    .addShareAction(R.string.app_name)
                    .setWrapScrollView(true)
                    .setLinksAnimated(true)
                    .setShowAsCard(true)
                    .build();
            setContentView(materialAboutView);
        }
        //endregion
    }
