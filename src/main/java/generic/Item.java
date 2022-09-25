package generic;

import model.Product;

import java.util.HashMap;
import java.util.Map;

public class Item <T>{
    private Map<T, Integer> items = new HashMap<>();


    public int getCount(T item){
        return items.getOrDefault(item, 0);
    }

    public boolean hasItem(T item){
        return items.containsKey(item);
    }
    public void addItem(T item){
        int count = getCount(item);
        items.put(item, count + 1);

    }

    public void put(T item, int quantity){
        items.put(item, quantity);
    }

    public T take(T item){
        int count = getCount(item);
        if(count > 1){
            items.put(item, count - 1);
            return item;
        } else if (count == 1){
            items.remove(item);
            return item;
        } else{
            items.remove(item);
        }

        return null;
    }
    public int getSize(){
        return items.size();
    }

    public Map<T, Integer> getItems() {
        return items;
    }

    public void setItems(Map<T, Integer> items) {
        this.items = items;
    }
}
