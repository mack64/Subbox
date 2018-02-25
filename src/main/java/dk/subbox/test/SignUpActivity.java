package dk.subbox.test;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class SignUpActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sign_up, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */


    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        //User fragment tab
        AutoCompleteTextView usernameEditText;
        EditText passwordEditText;
        EditText passwordAgainEditText;
        EditText emailEditText;

        //Personal fragment tab
        AutoCompleteTextView firstNameEditText;
        AutoCompleteTextView lastNameEditText;
        EditText birthDateEditText;

        //Contact fragment tab
        AutoCompleteTextView addresseEditText;
        AutoCompleteTextView zipCodeEditText;
        EditText cityEditText;
        Button signUpCompleteButton;
        TextView thermsOfUseTextView;
        TextView privacyPolicyTextView;

        @Override
        public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                                 Bundle savedInstanceState) {

            View rootView;

            switch (getArguments().getInt(ARG_SECTION_NUMBER)){
                default:{
                    rootView = inflater.inflate(R.layout.fragment_tab_user, container,false);
                    break;
                }
                case 1:{
                    rootView = inflater.inflate(R.layout.fragment_tab_user, container,false);

                    usernameEditText = rootView.findViewById(R.id.usernameEditText);
                    passwordEditText = rootView.findViewById(R.id.passwordEditText);
                    passwordAgainEditText = rootView.findViewById(R.id.passwordAgainEditText);
                    emailEditText = rootView.findViewById(R.id.emailEditText);

                    break;
                }
                case 2:{
                    rootView = inflater.inflate(R.layout.fragment_tab_personal,container,false);

                    firstNameEditText = rootView.findViewById(R.id.firstNameEditText);
                    lastNameEditText = rootView.findViewById(R.id.lastNameEditText);
                    birthDateEditText = rootView.findViewById(R.id.birthDateEditText);

                    final Calendar myCalender = Calendar.getInstance();

                    final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                            myCalender.set(Calendar.YEAR,year);
                            myCalender.set(Calendar.MONTH,month);
                            myCalender.set(Calendar.DAY_OF_MONTH,dayOfMonth);

                            String myFormat = "MM/dd/yyyy";
                            SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

                            birthDateEditText.setText(sdf.format(myCalender.getTime()));
                        }
                    };

                    birthDateEditText.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            DatePickerDialog dl = new DatePickerDialog(container.getContext(),
                                    date,
                                    myCalender.get(Calendar.YEAR),
                                    myCalender.get(Calendar.MONTH),
                                    myCalender.get(Calendar.DAY_OF_MONTH));

                            dl.show();
                        }
                    });


                    break;
                }
                case 3:{
                    rootView = inflater.inflate(R.layout.fragment_tab_contact,container, false);

                    addresseEditText = rootView.findViewById(R.id.addresseEditText);
                    zipCodeEditText = rootView.findViewById(R.id.zipCodeEditText);
                    cityEditText = rootView.findViewById(R.id.cityEditText);
                    signUpCompleteButton = rootView.findViewById(R.id.signUpCompleteButton);
                    thermsOfUseTextView = rootView.findViewById(R.id.thermsOfUseTextView);
                    privacyPolicyTextView = rootView.findViewById(R.id.privacyPolicyTextView);


                    Button signUpCompleteButton = rootView.findViewById(R.id.signUpCompleteButton);

                    signUpCompleteButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            String test = passwordEditText.getText().toString();

                            if (passwordEditText.getText() != passwordAgainEditText.getText()){
                                passwordEditText.setError("Password is not matching");
                                passwordAgainEditText.setError("Password is not matching");
                                //TODO: make password not matching Error
                            }

                            if (passwordEditText.getText() == null || passwordAgainEditText.getText() == null){
                                //TODO: Empty password Error
                                passwordEditText.setError("You need to provide a password");
                            }

                            if (usernameEditText.getText() == null){

                            }

                            if (emailEditText.getText() == null){

                            }
                        }
                    });



                    break;
                }
            }
            /*
            View rootView = inflater.inflate(R.layout.fragment_sign_up, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));*/

            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }
    }
}
