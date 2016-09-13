package it.droidcon.databinding.contact_2;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import it.droidcon.databinding.R;
import it.droidcon.databinding.databinding.Contact2Binding;

import static android.support.design.widget.Snackbar.LENGTH_LONG;

public class ContactActivity extends AppCompatActivity {

    private ContactInfo contactInfo;
    private Contact2Binding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.contact_2);
        contactInfo = new ContactInfo();
        binding.setContactInfo(contactInfo);

        binding.getRoot().postDelayed(() -> {
            contactInfo.message.set("my message");
            contactInfo.messageAvailable.set(true);
        }, 2000);
    }

    public void send(View view) {
        Snackbar.make(binding.getRoot(), contactInfo.message.get(), LENGTH_LONG).show();
    }
}
