package com.daily_cases_update.android.Services;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.daily_cases_update.android.R;

public class MaskTips extends AppCompatActivity {

    private  String wearMasksSteps;
    private String removeMaskSteps;
    private TextView wearMasksTextView;
    private TextView removeMaskTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mask_tips);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.mask_tips_action_bar);


        wearMasksSteps = "1. Wash your hands with soap and water\n" +
                "for atleast 20 seconds. Dry your hands\n" +
                "with a clean paper towel and throw the\n" +
                "paper towel away.\n" +
                "\n" +
                "\n" +
                "2. Cheak the mask for any defect such\n" +
                "as tear or missing tie or ear loop. Throw\n" +
                "away any that are defective.\n" +
                "\n" +
                "\n" +
                "3. Make sure the exterior (usually yellow\n" +
                "or blue) side of the mask is facing out,\n" +
                "away from your face.\n" +
                "\n" +
                "\n" +
                "4. Place the mask on your face with the\n" +
                "blue side facing out and the stiff\n" +
                "bendable edge at the top by your nose.\n" +
                "\n" +
                "\n" +
                "5. If the mask has ear loop, put one loop\n" +
                "around each ear.\n" +
                "\n" +
                "\n" +
                "6. If the mask has ties, pick up the mask\n" +
                "by the ties and tie upper ties behind\n" +
                "your head with a bow.\n" +
                "\n" +
                "\n" +
                "7. Once the mask is in place, use your\n" +
                "index finger and thumb to pinch the\n" +
                "bendable top edge of the mask around\n" +
                "the bridge of your nose.\n" +
                "\n" +
                "\n" +
                "8. If the mask has a lower tie, then once\n" +
                "the mask is fitted to the bridge of your\n" +
                "nose, tie the lower ties behind your head\n" +
                "with a bow.\n" +
                "\n" +
                "\n" +
                "9. Make sure the mask is completely secure.\n" +
                "Make sure it covers your nose and mouth\n" +
                "so that the bottom edge is under your chin.\n" +
                "\n" +
                "\n" +
                "10. Wash your hands.\n";



        wearMasksTextView = findViewById(R.id. wearMasksSteps);
        wearMasksTextView.setText(wearMasksSteps);





        removeMaskSteps = "1. Wash your hands before removing the\n" +
                "mask.\n" +
                "\n" +
                "\n" +
                "2. Do not touch the inside of the mask\n" +
                "(the part over nose and mouth). It may be\n" +
                "contaminated from your breathing, cough\n" +
                "or sneezing.\n" +
                "\n" +
                "\n" +
                "3. Unite or remove the ear loops and\n" +
                "remove the mask by the straps. Throw\n" +
                "the mask in the trash.\n" +
                "\n" +
                "\n" +
                "4. Wash your hands properly.\n";






        removeMaskTextView = findViewById(R.id.removeMasksSteps);
        removeMaskTextView.setText(removeMaskSteps);


    }
}