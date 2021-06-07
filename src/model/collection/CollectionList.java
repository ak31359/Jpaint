package model.collection;

import model.interfaces.ShapeInterface;

import java.util.ArrayList;
import java.util.List;

public class CollectionList {
    private final List<ShapeInterface> shapeList = new ArrayList<>();
    private String listLabel;

    public CollectionList(String listLabel) {
        this.listLabel = listLabel;
    }

    public void add(ShapeInterface item) {

        if (!shapeList.contains(item)) {
            shapeList.add(item);
        }
    }

    public ShapeInterface get(int index) {
        return shapeList.get(index);
    }

    public void remove(ShapeInterface item) {
        shapeList.remove(item);
    }

    public boolean contains(ShapeInterface item) {
        return shapeList.contains(item);
    }

    public void clear() {
        shapeList.clear();
    }

    public int size() {
        return shapeList.size();
    }

    public List<ShapeInterface> getList() {
        return shapeList;
    }

    public void addAll(List<ShapeInterface> list) {
        shapeList.addAll(list);
    }

    public void removeAll(List<ShapeInterface> list) {
        shapeList.removeAll(list);
    }


    @Override
    public String toString() {
        return "ShapeList{" +
                "shapeList=" + shapeList +
                ", listLabel='" + listLabel + '\'' +
                '}';
    }
}