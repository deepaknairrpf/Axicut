package com.example.dingu.axicut.Inward;

import com.example.dingu.axicut.Utils.General.MyDatabase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ServerValue;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * Created by dingu on 20/5/17.
 */

public  class InwardUtilities {
    public static String[] getCustomerDCNumbers() {

        return customerDCNumbers;
    }

    public static String[] getMaterialTypes() {



        return materialTypes;
    }

    public static String[] getLotNos() {
        return lotNos;
    }

    static String[] customerDCNumbers = {""};
    static String[] materialTypes = {""};
    static String[] lotNos = {""};

    public static String getServerDate() {
        return serverDate;
    }

    static String serverDate;
    static DatabaseReference dbRefUtilities = MyDatabase.getDatabase().getInstance().getReference("InwardUtilities");
    static DatabaseReference dbRefTimeStamp = MyDatabase.getDatabase().getInstance().getReference("Utils");

    public static void fetchDataFromDatabase()
    {
        dbRefUtilities.keepSynced(true);
        dbRefUtilities.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Map<String,Object> map1  = (Map<String, Object>) dataSnapshot.child("customerDCNumbers").getValue();

                if(map1 != null)
                customerDCNumbers = map1.keySet().toArray(new String[map1.size()]);

                Map<String,Object> map2  = (Map<String, Object>) dataSnapshot.child("materialTypes").getValue();

                if(map2 != null)
                materialTypes = map2.keySet().toArray(new String[map2.size()]);


//                materialTypes = (ArrayList3<String>) dataSnapshot.child("materialTypes").getValue();
//                lotNos = (ArrayList<String>) dataSnapshot.child("lotNos").getValue();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

   public static void fetchServerTimeStamp()
   {
       dbRefTimeStamp.keepSynced(true);
       dbRefTimeStamp.child("ServerTimeStamp").setValue(ServerValue.TIMESTAMP);
       dbRefTimeStamp.addListenerForSingleValueEvent(new ValueEventListener() {
           @Override
           public void onDataChange(DataSnapshot dataSnapshot) {

               Long timeStamp = dataSnapshot.child("ServerTimeStamp").getValue(Long.class);
               if(timeStamp != null)
               {
                   SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    serverDate =  formatter.format(new Date(timeStamp));

               }

           }

           @Override
           public void onCancelled(DatabaseError databaseError) {

           }
       });
   }


}
