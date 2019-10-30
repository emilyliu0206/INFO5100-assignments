package Assignment6_Q5;

import java.util.ArrayList;
import java.util.LinkedList;

public class MyHashMap {
    int key;
    int value;
    int capacity = 16;
    LinkedList[] hashmap_linkedlist = new LinkedList[capacity];

    void put(int key, int value){
        int index = key % capacity;
        int[] key_value_pair = {key, value};
        if (hashmap_linkedlist[index] == null){
            LinkedList<int[]> key_value_pair_list = new LinkedList<>();
            key_value_pair_list.addFirst(key_value_pair);
            hashmap_linkedlist[index] = key_value_pair_list;
        } else {
            for(int i = 0; i < hashmap_linkedlist[index].size(); i++){
                int[] existing_pair = (int[]) hashmap_linkedlist[index].get(i);
                if (existing_pair[0] == key) {
                    existing_pair[1] = value;
                    return;
                }
            }
            hashmap_linkedlist[index].addFirst(key_value_pair);
        }
    }


    int get(int key){
        int index = key % capacity;
        if (hashmap_linkedlist[index] == null){
            return -1;
        }else {
            for (int i =0; i < hashmap_linkedlist[index].size(); i++ ){
                int[] existing_pair = (int[])(hashmap_linkedlist[index].get(i));
                if (existing_pair[0] == key) {
                    return existing_pair[1];
                }
            }
        }
        return -1;
    }


    void remove(int key){
        int index = key % capacity;
        if (hashmap_linkedlist[index] == null){
            System.out.println("Invaid key");
        }else {
            for (int i = 0; i < hashmap_linkedlist[index].size(); i++) {
                int[] existing_pair = (int[]) (hashmap_linkedlist[index].get(i));
                if (existing_pair[0] == key) {
                    hashmap_linkedlist[index].remove(i);
                }else {
                    System.out.println("Invaid key");
                }
            }
        }
    }
}
