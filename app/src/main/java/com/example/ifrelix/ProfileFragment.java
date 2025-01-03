package com.example.ifrelix;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {

    private static final String PREFS_NAME = "ProfilePrefs";

    // Declare UI components
    private TextView fullNameTextView, emailTextView, phoneNumberTextView, schoolTextView, addressTextView, skillsTextView, aboutTextView;
    private ImageView profileImageView;
    private Button editProfileButton;

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        // Initialize UI components
        fullNameTextView = view.findViewById(R.id.fullNameTextView);
        emailTextView = view.findViewById(R.id.emailTextView);
        phoneNumberTextView = view.findViewById(R.id.phoneNumberTextView);
        schoolTextView = view.findViewById(R.id.schoolTextView);
        addressTextView = view.findViewById(R.id.addressTextView);
        skillsTextView = view.findViewById(R.id.skillsTextView);
        aboutTextView = view.findViewById(R.id.aboutTextView);
        profileImageView = view.findViewById(R.id.profileImageView);
        editProfileButton = view.findViewById(R.id.editProfileButton);

        // Retrieve and display the profile data from SharedPreferences
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(PREFS_NAME, getActivity().MODE_PRIVATE);

        String fullName = sharedPreferences.getString("fullName", "No name saved");
        String email = sharedPreferences.getString("email", "No email saved");
        String phoneNumber = sharedPreferences.getString("phoneNumber", "No phone number saved");
        String school = sharedPreferences.getString("school", "No school info saved");
        String address = sharedPreferences.getString("address", "No address saved");
        String skills = sharedPreferences.getString("skills", "No skills info saved");
        String about = sharedPreferences.getString("about", "No information available");

        // Display the data in the respective TextViews
        fullNameTextView.setText(fullName);
        emailTextView.setText(email);
        phoneNumberTextView.setText(phoneNumber);
        schoolTextView.setText(school);
        addressTextView.setText(address);
        skillsTextView.setText(skills);
        aboutTextView.setText(about);

        // Optionally, you can load a profile picture if it's saved in SharedPreferences or from a resource
        // For example, let's assume the profile image is not saved in SharedPreferences and is using a placeholder
        profileImageView.setImageResource(R.drawable.ic_profile_placeholder); // Set default image placeholder

        // Add OnClickListener for Edit Profile Button
        editProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start MeActivity when Edit Profile button is clicked
                Intent intent = new Intent(getActivity(), MeActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
