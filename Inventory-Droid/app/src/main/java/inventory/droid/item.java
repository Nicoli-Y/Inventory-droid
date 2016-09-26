package inventory.droid;


import java.io.Serializable;

public final class Item implements Serializable {
        public String name;
        public String type;
        public String id;

        public Item() { super(); }

        public Item(String id, String name, String type){
            this();

            this.id = id;
            this.name = name;
            this.type = type;
        }
    @Override
    public String toString() { return id + ":" + name + ":" + type; }

    @Override
    public boolean equals(Object that) {
        if (that instanceof Item) {
            Item item = (Item) that;
            if (item.id.equals(this.id))
                return true;
            else
                return false;

        } else{
            return false;
        }
    }

}
