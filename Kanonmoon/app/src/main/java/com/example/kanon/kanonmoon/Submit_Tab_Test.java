package com.example.kanon.kanonmoon;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;  // don't use java.net.URI
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kanon on 12/28/2015.
 */
public class Submit_Tab_Test extends AppCompatActivity {

    private static final int EDIT = 0, DELETE = 1;

    EditText nameTxt, phoneTxt, emailTxt, addressTxt;
    ImageView contactImageImgView;          // for image
    List<Contact> Contacts = new ArrayList<Contact>();
    ListView contactListView;
    Uri imageUri = Uri.parse("android.resource://org.intracode.contactmanager/drawable/person1.png");
    DatabaseHandler dbHandler;
//    int longClickedItemIndex;
    int onClickedItemIndex;
    ArrayAdapter<Contact> contactAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.submit_tab_test);

        nameTxt = (EditText) findViewById(R.id.txtName);
        phoneTxt = (EditText) findViewById(R.id.txtPhone);
        emailTxt = (EditText) findViewById(R.id.txtEmail);
        addressTxt = (EditText) findViewById(R.id.txtAddress);
        contactListView = (ListView) findViewById(R.id.listView);
        contactImageImgView = (ImageView) findViewById(R.id.imgViewContactImg);   // for image
        dbHandler = new DatabaseHandler(getApplicationContext());

        registerForContextMenu(contactListView);

//        contactListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
//                longClickedItemIndex = position;
//                return false;
//            }
//        });

        contactListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                onClickedItemIndex = position;
//                return false;
            }
        });




        TabHost tabHost = (TabHost) findViewById(R.id.tabHost);

        tabHost.setup();

        TabHost.TabSpec tabSpec = tabHost.newTabSpec("creator");
        tabSpec.setContent(R.id.tabCreator);
        tabSpec.setIndicator("Creator");
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("list");
        tabSpec.setContent(R.id.tabContactList);
        tabSpec.setIndicator("List");
        tabHost.addTab(tabSpec);

        final Button addBtn = (Button) findViewById(R.id.btnAdd);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Contact contact = new Contact(dbHandler.getContactsCount(), String.valueOf(nameTxt.getText()), String.valueOf(phoneTxt.getText()), String.valueOf(emailTxt.getText()), String.valueOf(addressTxt.getText()), imageUri);
                if (!contactExists(contact)) {
                    dbHandler.createContact(contact);
                    Contacts.add(contact);
                    contactAdapter.notifyDataSetChanged();
                    Toast.makeText(getApplicationContext(), String.valueOf(nameTxt.getText()) + " has been added to your Contacts!", Toast.LENGTH_SHORT).show();   //????????????message
                    return;
                }
                Toast.makeText(getApplicationContext(), String.valueOf(nameTxt.getText()) + " already exists. Please use a different name.", Toast.LENGTH_SHORT).show();
            }
        });

        nameTxt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                addBtn.setEnabled(String.valueOf(nameTxt.getText()).trim().length() > 0); //???testbox??????????????????button
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        // for image
        contactImageImgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Contact Image"), 1);
            }
        });

        if (dbHandler.getContactsCount() != 0)
            Contacts.addAll(dbHandler.getAllContacts());

        populateList();
    }

    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, view, menuInfo);

        menu.setHeaderIcon(R.drawable.pencil_icon);
        menu.setHeaderTitle("Contact Options");
        menu.add(Menu.NONE, EDIT, menu.NONE, "Edit Contact");      //import android.view.Menu;   import android.view.MenuItem;
        menu.add(Menu.NONE, DELETE, menu.NONE, "Delete Contact");
    }

    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case EDIT:
                // TODO: Implement editing a contact
                break;
            case DELETE:
//                dbHandler.deleteContact(Contacts.get(longClickedItemIndex));
//                Contacts.remove(longClickedItemIndex);
                dbHandler.deleteContact(Contacts.get(onClickedItemIndex));
                Contacts.remove(onClickedItemIndex);
                contactAdapter.notifyDataSetChanged();
                break;
        }

        return super.onContextItemSelected(item);
    }

    private boolean contactExists(Contact contact) {
        String name = contact.getName();
        int contactCount = Contacts.size();

        for (int i = 0; i < contactCount; i++) {
            if (name.compareToIgnoreCase(Contacts.get(i).getName()) == 0)
                return true;
        }
        return false;
    }


    public void onActivityResult(int reqCode, int resCode, Intent data) {
        if (resCode == RESULT_OK) {
            if (reqCode == 1) {
                imageUri = data.getData();
                contactImageImgView.setImageURI(data.getData());
            }
        }
    }

    private void populateList() {
        contactAdapter = new ContactListAdapter();
        contactListView.setAdapter(contactAdapter);
    }

    private class ContactListAdapter extends ArrayAdapter<Contact> {
        public ContactListAdapter() {
            super(Submit_Tab_Test.this, R.layout.listview_item, Contacts);
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            if (view == null)
                view = getLayoutInflater().inflate(R.layout.listview_item, parent, false);

            Contact currentContact = Contacts.get(position);

            TextView name = (TextView) view.findViewById(R.id.contactName);
            name.setText(currentContact.getName());
            TextView phone = (TextView) view.findViewById(R.id.phoneNumber);
            phone.setText(currentContact.getPhone());
            TextView email = (TextView) view.findViewById(R.id.emailAddress);
            email.setText(currentContact.getEmail());
            TextView address = (TextView) view.findViewById(R.id.cAddress);
            address.setText(currentContact.getAddress());
            ImageView ivContactImage = (ImageView) view.findViewById(R.id.ivContactImage); // for image opp view
            ivContactImage.setImageURI(currentContact.getImageURI());

            return view;
        }
    }
}
