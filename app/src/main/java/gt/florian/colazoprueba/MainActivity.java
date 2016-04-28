package gt.florian.colazoprueba;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;

public class MainActivity extends AppCompatActivity {

    //NavigationDrawer
    private Toolbar appbar;
    private DrawerLayout drawerLayout;
    private NavigationView navView;
    android.support.v4.app.FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;

    //TabLaout



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        //TabLayout
       // toolbar = (Toolbar) findViewById(R.id.toolBar);
        //setSupportActionBar(toolbar);

        //NavigatioDrawer
        //appbar = (Toolbar)findViewById(R.id.appbar);
        //setSupportActionBar(appbar);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_nav_menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.containerView, new TabFragment()).commit();


        drawerLayout = (DrawerLayout)findViewById(R.id.drawerLayout);
        navView = (NavigationView)findViewById(R.id.shitstuff);


        navView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {

                        Log.i("kevin",String.valueOf(menuItem.getItemId()));

                        switch (menuItem.getItemId()) {
                            case R.id.menu_seccion_1:
                                Intent intent1 = new Intent(getApplicationContext(), PrimerosPasos.class);
                                startActivity(intent1);
                                break;
                            case R.id.menu_seccion_2:
                                Intent intent2 = new Intent(getApplicationContext(), AyudaAsistencia.class);
                                startActivity(intent2);

                                break;
                            case R.id.menu_seccion_3:
                                Intent intent3 = new Intent(getApplicationContext(), Ajustes.class);
                                startActivity(intent3);

                                break;
                            case R.id.menu_seccion_4:
                                Intent intent4 = new Intent(getApplicationContext(), TerminosCondiciones.class);
                                startActivity(intent4);

                                break;
                            case R.id.menu_seccion_5:
                                Intent intent5 = new Intent(getApplicationContext(), Creditos.class);
                                startActivity(intent5);

                                break;


                        }

                        drawerLayout.closeDrawers();

                        return true;
                    }
                });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        switch(item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

