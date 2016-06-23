package com.sjsu.priteshchandaliya.cmpeginie;

import java.util.ArrayList;

/**
 * Created by Megha on 5/4/2016.
 */

public class groupFaq {




        private String Name;
        private ArrayList<childFaq> Items;

        public String getName() {
            return Name;
        }

        public void setName(String name) {
            this.Name = name;
        }

        public ArrayList<childFaq> getItems() {
            return Items;
        }

        public void setItems(ArrayList<childFaq> Items) {
            this.Items = Items;
        }


}
